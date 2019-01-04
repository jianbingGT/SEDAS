package com.sedationassist.service;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import com.sedationassist.model.PatientFHIR;

import com.sedationassist.model.SedationRecord;
import com.sedationassist.repositories.SedationRecordRepository;
import org.hl7.fhir.dstu3.model.*;
import org.hl7.fhir.exceptions.FHIRException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.math.MathContext;
import java.math.RoundingMode;

import java.util.*;


@Service
public class PatientInfo {

    @Autowired
    SedationRecordRepository sedationRecordRepository;

    @Value("${hapi.fhir.server.url}")
    private String serverBase;

    private boolean FindinMongo;

    private Patient patient;
    private FhirContext ctx;
    private IGenericClient client;

    public PatientFHIR findpatientinfobyID(String Name, String DOB) {
//    public PatientFHIR findpatientinfobyID(ID) {

            FindinMongo = false;
        PatientFHIR patientFHIR = new PatientFHIR();
//        List<SedationRecord> oldrecord = sedationRecordRepository.findByPatientFHIR_PatientId(ID);
        List<SedationRecord> oldrecord = sedationRecordRepository.findByPatientFHIR_patientNameAndPatientFHIR_PatientBirthday(Name, DOB);

        if ( oldrecord.size() != 0) {
//            System.out.println(ID);
//            System.out.println(oldrecord.size());
            Collections.sort(oldrecord, new Comparator<SedationRecord>() {
                @Override
                public int compare(SedationRecord o1, SedationRecord o2) {
                    return (int) (o2.getDatetime() - o1.getDatetime());
                }
            });
            patientFHIR = oldrecord.get(0).getPatientFHIR();
            FindinMongo = true;
            return patientFHIR;
        }
        if (!FindinMongo) {
// implement get info from hfir here
            String patientName = "EnterName EnterName";
            String patientAge = "Enter age";
            String patientBirthday = "";
            String patientId = "";
            String patientHeight = "Enter height";
            String patientWeight = "Enter weight";
            String patientBloodPres = "Enter blood pressure";
            String patientGender = "female";
            String patientBmi = "Enter BMI";
            Boolean isSmoking = true;
            Boolean isBenzo = false;
            Boolean isOpioid = false;
            // psychoative
            Boolean isPsychoactive = false;
            String patientPhone = "Enter phone number";
            String patientAddress = "Enter address";

            ctx = FhirContext.forDstu3();
            client = ctx.newRestfulGenericClient(serverBase);

            String[] names = Name.split(" ");
            String FirstName = names[0]; //put first name and last name together
            String LastName = names[names.length-1];

            try {
                Bundle patient_bundle = client.search().forResource(Patient.class)
                        .where(Patient.GIVEN.matchesExactly().value(FirstName))
                        .and(Patient.FAMILY.matchesExactly().value(LastName))
                        .and(Patient.BIRTHDATE.exactly().day(DOB))
                        .returnBundle(Bundle.class).execute();
                System.out.println(patient_bundle.getTotal());
                patient = (Patient) patient_bundle.getEntry().get(0).getResource();
            } catch (Exception e) {

                System.out.println("patient not found");
                e.printStackTrace();
                return new PatientFHIR(patientName, patientAge,patientBirthday, patientId, patientHeight,
                        patientWeight, patientBloodPres, patientGender, patientBmi,
                        isSmoking, isBenzo, isOpioid, isPsychoactive, patientPhone, patientAddress);
            }

            patientName = patient.getName().get(0).getGivenAsSingleString() + " " + patient.getName().get(0).getFamily(); //passed the test
            patientGender = patient.getGenderElement().getValueAsString(); //passed the test
            patientId = patient.getIdElement().getIdPart();

            //get the patient address
            try {
                String line = "";
                for (StringType s : patient.getAddress().get(0).getLine()) {
                    line += s.toString();
                    line += ", ";
                }
                patientAddress = line +
                        patient.getAddress().get(0).getCity() + ", " +
                        patient.getAddress().get(0).getState() + ", " +
                        patient.getAddress().get(0).getPostalCode() + ", " +
                        patient.getAddress().get(0).getCountry();
            } catch (Exception e) {
                patientAddress = "no address record";
            }

            //get the patient phone
            try {
                patientPhone = patient.getTelecom().get(0).getValue().toString();
            } catch (Exception e) {
                patientPhone = "no phone record";
            }

            patientAge = String.valueOf(parseDOB(patient.getBirthDateElement()));

            patientBirthday = patient.getBirthDateElement().getValueAsString();


            String obs_height = "8302-2";
            String obs_weight = "29463-7";
            String obs_bmi = "39156-5";
            String obs_BloodPres = "55284-4";
            String obs_tabacco = "72166-2";
            String cond_psychoactive = "2403008";


            patientHeight = getObsValue(patientId, obs_height).split(" ")[0];
            patientWeight = getObsValue(patientId, obs_weight).split(" ")[0];
            patientBmi = getObsValue(patientId, obs_bmi).split(" ")[0];
            patientBloodPres = getBloodPres(patientId, obs_BloodPres).split(" ")[0];

            //get tobacco
            Bundle bundle_smoke = client.search().forResource(Observation.class)
                    .where(Observation.PATIENT.hasId(patientId))
                    .and(Observation.CODE.exactly().code(obs_tabacco))
                    .returnBundle(Bundle.class)
                    .execute();
            if (bundle_smoke.getTotal() > 0) {
                while (true) {
                    for (Bundle.BundleEntryComponent entry : bundle_smoke.getEntry()) {
                        Observation obs = (Observation) entry.getResource();
                        String smoke_status_valueset = null;
                        try {
                            smoke_status_valueset = obs.getValueCodeableConcept().getCoding().get(0).getCode();
                        } catch (FHIRException e) {
                            e.printStackTrace();
                        }
                        if (smoke_status_valueset == "266919005") {
                            isSmoking = false;
                        } else if (smoke_status_valueset == "266927001") {
                            isSmoking = null;
                        } else {
                            isSmoking = true;
                        }
                    }
                    if (bundle_smoke.getLink(Bundle.LINK_NEXT) == null) {
                        break;
                    }
                    // load next page
                    bundle_smoke = client.loadPage().next(bundle_smoke).execute();
                }
            }

            // get psy
            Bundle bundle_psy = client.search().forResource(Condition.class)
                    .where(Condition.PATIENT.hasId(patientId))
                    .and(Condition.CODE.exactly().code(cond_psychoactive))
                    .returnBundle(Bundle.class)
                    .execute();

            if (bundle_psy.getEntry().size() > 0) {
                isSmoking = true;
            }

            //get benzo
            String med_benzodiazepine = "47355007";
            Bundle bundle_ben = client.search().forResource(MedicationStatement.class)
                    .where(MedicationStatement.PATIENT.hasId(patientId))
                    .and(MedicationStatement.CODE.exactly().code(med_benzodiazepine))
                    .returnBundle(Bundle.class)
                    .execute();
            if (bundle_ben.getEntry().size() > 0) {
                isBenzo = true;
            }
            return new PatientFHIR(patientName, patientAge, patientBirthday, patientId, patientHeight,
                    patientWeight, patientBloodPres, patientGender, patientBmi,
                    isSmoking, isBenzo, isOpioid, isPsychoactive, patientPhone, patientAddress);
        }

        return patientFHIR;

    }

    private String getBloodPres(String id, String lonic_code) {
        Bundle resultBundle = client.search().forResource(Observation.class)
                .where(Observation.PATIENT.hasId(id))

                .and(Observation.CODE.exactly().code(lonic_code))
                .returnBundle(Bundle.class)
                .execute();
//        System.out.println(resultBundle.getTotal());
        String result = "no record";


        if (resultBundle.getTotal() == 0) {
            return result;
        }

        DateTimeType latest = new DateTimeType(new Date(Long.MIN_VALUE));

        boolean next = true;
        while (next) {
            for (Bundle.BundleEntryComponent entry : resultBundle.getEntry()) {
                Observation obs = (Observation) entry.getResource();
//                System.out.println(obs.getCode().getCoding().get(0).getCode());
                try {
                    if (obs.getEffectiveDateTimeType().after(latest)) {
                        Quantity quantity_dia = (Quantity) obs.getComponent().get(0).getValue();
                        Quantity quantity_sys = (Quantity) obs.getComponent().get(1).getValue();
//                        System.out.println(quantity.getValue().toString());
                        String result_dia = quantity_dia.getValue().toString();
                        String result_sys = quantity_sys.getValue().toString();
                        result = result_sys + "/" + result_dia + " " + quantity_dia.getUnit();
                        latest = obs.getEffectiveDateTimeType();
                    }
                } catch (FHIRException e) {
                    e.printStackTrace();
                }
            }
            if (resultBundle.getLink(Bundle.LINK_NEXT) == null) {
                break;
            }
            // load next page
            resultBundle = client.loadPage().next(resultBundle).execute();
        }

        return result;
    }

    private String getObsValue(String patientID, String lonic_code) {
        Bundle resultBundle = client.search().forResource(Observation.class)
                .where(Observation.PATIENT.hasId(patientID))
                .and(Observation.CODE.exactly().code(lonic_code))
                .returnBundle(Bundle.class)
                .execute();
//        System.out.println(resultBundle.getTotal());
        String result = "no record";

        if (resultBundle.getTotal() == 0) {
            return result;
        }

        DateTimeType latest = new DateTimeType(new Date(Long.MIN_VALUE));
        boolean next = true;
        while (next) {
            for (Bundle.BundleEntryComponent entry : resultBundle.getEntry()) {
                Observation obs = (Observation) entry.getResource();
//                System.out.println(obs.getCode().getCoding().get(0).getCode());
                try {

                    if (obs.getEffectiveDateTimeType().after(latest)) {
                        Quantity quantity = (Quantity) obs.getValue();
//                        System.out.println(quantity.getValue().toString());
                        result = quantity.getValue().round(new MathContext(4, RoundingMode.HALF_UP))
                                + " " + quantity.getUnit();
                        latest = obs.getEffectiveDateTimeType();
                    }
                    ;

                } catch (FHIRException e) {
                    e.printStackTrace();
                }
            }
            if (resultBundle.getLink(Bundle.LINK_NEXT) == null) {
                break;
            }
            // load next page
            resultBundle = client.loadPage().next(resultBundle).execute();
        }

        return result;
    }

    private int parseDOB(DateType birthDateElement) {
        int birthYear = birthDateElement.getYear();
        Date cur = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(cur);
        int age = cal.get(Calendar.YEAR) - birthYear;
        return age;
    }
}

