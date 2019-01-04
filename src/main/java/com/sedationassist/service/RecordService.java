package com.sedationassist.service;

import com.sedationassist.model.PatientFHIR;
import com.sedationassist.model.PatientMongo;
import com.sedationassist.model.SedationOption;
import com.sedationassist.model.SedationRecord;
import com.sedationassist.repositories.SedationRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class RecordService {
    @Autowired
    private SedationRecordRepository sedationRecordRepository;

    public SedationRecord create(PatientFHIR p){
        return sedationRecordRepository.save(new SedationRecord(p));
    }
    public SedationRecord findSedationRecordbyID(String ID) {

        //PatientFHIR patientFHIR = new PatientFHIR();
        List<SedationRecord> oldrecord = sedationRecordRepository.findByPatientFHIR_PatientId(ID);
        if (oldrecord != null || oldrecord.size() != 0) {
            Collections.sort(oldrecord, new Comparator<SedationRecord>() {
                @Override
                public int compare(SedationRecord o1, SedationRecord o2) {
                    return (int) (o2.getDatetime()-o1.getDatetime());
                }
            });
            return oldrecord.get(0);
        }
        return  null;
 }
    public List<SedationRecord>  findSedationRecordListByID(String ID) {

        PatientFHIR patientFHIR = new PatientFHIR();
        List<SedationRecord> oldrecord = sedationRecordRepository.findByPatientFHIR_PatientId(ID);
        if (oldrecord != null || oldrecord.size() != 0) {
            Collections.sort(oldrecord, new Comparator<SedationRecord>() {
                @Override
                public int compare(SedationRecord o1, SedationRecord o2) {
                    return (int) (o2.getDatetime()-o1.getDatetime());
                }
            });
            return oldrecord;
        }
        return  null;
    }
    public int GetRecordSize(){
        List<SedationRecord> oldrecord = sedationRecordRepository.findAll();
        return oldrecord.size();
    }
}
