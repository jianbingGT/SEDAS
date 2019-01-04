package com.sedationassist.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.validation.Valid;

import com.sedationassist.model.*;
import com.sedationassist.repositories.SedationRecordRepository;
import com.sedationassist.repositories.UserRepo;
import com.sedationassist.service.CalculateOption;
import com.sedationassist.service.PatientInfo;
import com.sedationassist.service.RecordService;
import org.bson.types.ObjectId;
import org.hl7.fhir.dstu3.model.Bundle;
import org.hl7.fhir.dstu3.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sedationassist.application.SedationAssistApplication;
import com.sedationassist.configuration.SecurityService;
import com.sedationassist.repositories.PatientMongoRepository;
import com.sedationassist.service.UserService;
import com.sedationassist.validator.UserValidator;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.api.IGenericClient;

@Controller
@EnableConfigurationProperties
public class RiskAssessmentController {
	//leave these two score here
	String patientscore;
	String patientcategory;
	
	// make change on the rest vars
	String patientFirstName;
	String patientLastName;
	String patientBirthday;
	String patientName;
	String patientAge;
	String patientId;
	String patientHeight;
	String patientWeight;
	String patientBloodPres;
	String patientGender;
	String patientBmi;
	Boolean isSmoking;
	Boolean isBenzo;
	Boolean isOpioid;
	Boolean isOther;
	String patientPhone;
	String patientAddress;

	ObjectId sedationID;
	
	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;

	@Autowired
	private PatientInfo patientInfo;

	@Value("${hapi.fhir.server.url}")
	private String serverBase;

	@Autowired
	private PatientMongoRepository patientrepository;

	@Autowired
    private CalculateOption calulationoption;

	@Autowired
	private RecordService recordService;

	@Autowired
    private UserRepo userRepo;

	@Autowired
    private SedationRecordRepository sedationrecordRepository;

	@GetMapping(value = "/login")
	public String getlogin() {
		return "login";
	}
	
	@PostMapping(value = "/login")
	public String login(@RequestParam("username") String username,  @RequestParam("password") String password) {
		securityService.autologin(username, password);
		return "redirect:/index";
	}

	@GetMapping("/registration")
	public String registration(ModelMap model) {
		model.addAttribute("userForm", new UserForm());
		return "registration";
	}

	@PostMapping(value = "/registration")
	public String registration(@ModelAttribute("userForm") UserForm userForm, BindingResult bindingResult, ModelMap model) {
		userValidator.validate(userForm, bindingResult);
		if (bindingResult.hasErrors()) {
			return "registration";
		}
		User newUser = new User(userForm.getUsername(), userForm.getPasswordConfirm());
		userService.save(newUser);
		securityService.autologin(newUser.getUsername(), userForm.getPasswordConfirm());
		return "redirect:/index";
	}

	//show index once finish login/registration
	@GetMapping("/index")
	public String showIndexPage() {
		return "index";
	}

	// confirm old patient's info if searching for an old patient
	@PostMapping("/confirmPatientInfoForm")
	public String confirmPatientInfoForm(@RequestParam("patientFirstName") String patientFirstName,
										 @RequestParam("patientLastName") String patientLastName,
										 @RequestParam("patientBirthDate") String patientBirthDate,
										 ModelMap model) {
		// add your code here: get this patient using patientID; you can either return a patient info obejct, or put all the patient related info for frontend
//				System.out.println(patientID);

		PatientFHIR cur = patientInfo.findpatientinfobyID(patientFirstName + " " + patientLastName, patientBirthDate);
		patientId = cur.getPatientId(); //when you save the patient, get this patient's id
		if (patientId == null || patientId.length() == 0){
			return "redirect:/inputNewPatientInfo";
		}

		// serach this patient's info and use these info to filled in the form; no need to save to global
		String[] names = cur.getPatientName().split(" ");
		patientFirstName = names[0]; //put first name and last name together
		patientLastName = names[names.length-1];
		patientAge = cur.getPatientAge(); //calculate it according to birthday
		patientBirthday = cur.getPatientBirthday();
		patientId = cur.getPatientId(); //when you save the patient, get this patient's id
	/*	if (patientId == null || patientId.length() == 0){
			int size = recordService.GetRecordSize();
			patientId = "patient" + size;
		}
		*/
		patientHeight = cur.getPatientHeight();
		patientWeight = cur.getPatientWeight();
		patientBloodPres = cur.getPatientBloodPres();
		patientGender = cur.getPatientGender();
		patientBmi = cur.getPatientBmi();
		isSmoking = cur.getSmoking();// these four vars can only pass true/false to frontend once you get string "yes" printed: so in DB you can only assign "yes" for "no";
		//confirm with frontend by printing the value passed by frontend in other controller
		isBenzo = cur.getBenzo();
		isOpioid = cur.getOpioid();
		isOther = cur.getOther();
		patientPhone = cur.getPatientPhone();
		patientAddress =  cur.getPatientAddress();

		model.addAttribute("patientFirstName", patientFirstName);
		model.addAttribute("patientLastName", patientLastName);
		model.addAttribute("patientBirthday", patientBirthday);
		model.addAttribute("patientId", patientId);
		model.addAttribute("patientHeight", patientHeight);
		model.addAttribute("patientWeight", patientWeight);
		model.addAttribute("patientBloodPres", patientBloodPres);
		model.addAttribute("patientGender", patientGender);
		model.addAttribute("patientBmi", patientBmi);
		model.addAttribute("isSmoking", isSmoking);
		model.addAttribute("isBenzo", isBenzo);
		model.addAttribute("isOpioid", isOpioid);
		model.addAttribute("isOther", isOther);
		model.addAttribute("phone", patientPhone);
		model.addAttribute("address", patientAddress);
		return "updateOldPatientInfo";
	}
	
	// input new patient's info if a new patient is coming
	@GetMapping("/inputNewPatientInfo")
	public String showPatientInfoForm() {
		return "inputNewPatientInfo";
	}
	// update old patient's info
	@PostMapping("/saveOldPatientInfo")
	public String saveOldPatientInfo(@RequestParam("patientId") String patientId, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
									 @RequestParam("gender") String gender, @RequestParam("birthday") String birthday,
									 @RequestParam("height") String height, @RequestParam("weight") String weight, @RequestParam("bloodpressure") String bloodpressure,
									 @RequestParam("bmi") String bmi, @RequestParam("tobacco") String tobacco, @RequestParam("benz") String benz,
									 @RequestParam("opiod") String opiod, @RequestParam("other") String other, @RequestParam("phone") String phone, @RequestParam("address") String address, ModelMap model) {
//		System.out.println(firstName);
//		System.out.println(lastName);
//		System.out.println(gender);
//		System.out.println(birthday);
//		System.out.println(height);
//		System.out.println(weight);
//		System.out.println(bmi);
//		System.out.println(tobacco);
//		System.out.println(benz);
//		System.out.println(opiod);
//		System.out.println(other);
//		System.out.println(phone);
//		System.out.println(address);
		// here is the perfect place to save the patient's info into DB no matter new or old patient
		// assign these vars with input value, which will be used by other controller: so register a new patient will also change the gobal patient info
		PatientFHIR cur = new PatientFHIR();
		patientName = firstName +" "+ lastName;
		cur.setPatientName(patientName);
        patientBirthday = birthday;
        cur.setPatientBirthday(patientBirthday);
		String birthYear = birthday.substring(0,4);
		Date curdate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(curdate);
		String age = String.valueOf(cal.get(Calendar.YEAR) - Integer.parseInt(birthYear));//Sun Aug 26 00:00:00 CDT 1984
		patientAge = age; //calculate it according to birthday
		cur.setPatientAge(patientAge);
//        List<SedationRecord> sedationRecordList = sedationrecordRepository.findAll();
//		String newid = "mongo"+sedationRecordList.size();

		this.patientId = patientId; //when you save the patient, get this patient's id
		cur.setPatientId(patientId);
		patientHeight = height;
		cur.setPatientHeight(patientHeight);
		patientWeight = weight;
		cur.setPatientWeight(patientWeight);
		patientBloodPres = bloodpressure;
		cur.setPatientBloodPres(patientBloodPres);
		patientGender = gender;
		cur.setPatientGender(patientGender);
		patientBmi = bmi;
		cur.setPatientBmi(patientBmi);

		isSmoking = false;// these four vars can only pass true/false to frontend, you need to see the printed "tobacco" value, and then assign boolean to these vars
		if(tobacco.equals("yes")){
			isSmoking = true;
		}
		cur.setSmoking(isSmoking);
		isBenzo = true;
		if(benz.equals("no")){
			isBenzo = false;
		}
		cur.setBenzo(isBenzo);
		isOpioid = true;
		if(opiod.equals("no")){
			isOpioid = false;
		}
		cur.setOpioid(isOpioid);
		isOther = true;
		if(other.equals("no")){
			isOther = false;
		}
		cur.setOther(isOther);
		patientPhone = phone;
		cur.setPatientPhone(patientPhone);
		patientAddress =  address;
		cur.setPatientAddress(patientAddress);

		SedationRecord currecord = recordService.create(cur);
		sedationID = currecord.getSedation_id();
		System.out.println(sedationID.toString());

//		sedationrecordRepository.save(currecord);
		// pass these value to patientinfo page to show these info
		model.addAttribute("patientName", patientName);
		model.addAttribute("patientAge", patientAge);
		model.addAttribute("patientId", patientId);
		model.addAttribute("patientHeight", patientHeight);
		model.addAttribute("patientWeight", patientWeight);
		model.addAttribute("patientBloodPres", patientBloodPres);
		model.addAttribute("patientGender", patientGender);
		model.addAttribute("patientBmi", patientBmi);
		model.addAttribute("isSmoking", isSmoking); //writing logic to get this value according to printed tobacco
		model.addAttribute("isBenzo", isBenzo);
		model.addAttribute("isOpioid", isOpioid);
		model.addAttribute("isOther", isOther);
		model.addAttribute("phone", patientPhone);
		model.addAttribute("address", patientAddress);
		model.addAttribute("sedationID", sedationID);
		List<SedationRecord> records = recordService.findSedationRecordListByID(patientId);
		for(SedationRecord sedationRecord: records){
			if(sedationRecord.getPatientscore() != null){
				System.out.println("********* patient score: "+sedationRecord.getPatientscore());
			}
            if(sedationRecord.getSedationoption() != null){
                System.out.println("********* sedation option: "+sedationRecord.getSedationoption());
            }
            if(sedationRecord.getPatientcategory() != null){
                System.out.println("********* patient category: "+sedationRecord.getPatientcategory());
            }
			System.out.println("***");
		}
		return "patientinfo";
	}

	// save new patient's info
	@PostMapping("/savePatientInfo")
	public String savePatientInfo(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
			@RequestParam("gender") String gender, @RequestParam("birthday") String birthday,
			@RequestParam("height") String height, @RequestParam("weight") String weight, @RequestParam("bloodpressure") String bloodpressure,
			@RequestParam("bmi") String bmi, @RequestParam("tobacco") String tobacco, @RequestParam("benz") String benz,
			@RequestParam("opiod") String opiod, @RequestParam("other") String other, @RequestParam("phone") String phone, @RequestParam("address") String address, ModelMap model) {
//		System.out.println(firstName);
//		System.out.println(lastName);
//		System.out.println(gender);
//		System.out.println(birthday);
//		System.out.println(height);
//		System.out.println(weight);
//		System.out.println(bmi);
//		System.out.println(tobacco);
//		System.out.println(benz);
//		System.out.println(opiod);
//		System.out.println(other);
//		System.out.println(phone);
//		System.out.println(address);
		// here is the perfect place to save the patient's info into DB no matter new or old patient
		// assign these vars with input value, which will be used by other controller: so register a new patient will also change the gobal patient info
		PatientFHIR cur = new PatientFHIR();
		patientName = firstName +" "+ lastName;
		cur.setPatientName(patientName);
		System.out.println(birthday);
		cur.setPatientBirthday(birthday);
		int year = Integer.valueOf(birthday.substring(0,4));
		Date curd = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(curd);
		int age = cal.get(Calendar.YEAR) - year;
		patientAge = String.valueOf(age); //calculate it according to birthday
		System.out.println(birthday);
		cur.setPatientAge(patientAge);


//       List<SedationRecord> sedationRecordList = sedationrecordRepository.findAll();
//		String newid = "patient"+sedationRecordList.size();

		int patientSize = recordService.GetRecordSize();
		String newid = "patient"+patientSize;

		patientId = newid; //when you save the patient, get this patient's id
		cur.setPatientId(newid);
		patientHeight = height;
		cur.setPatientHeight(patientHeight);
		patientWeight = weight;
		cur.setPatientWeight(patientWeight);
		patientBloodPres = bloodpressure;
		cur.setPatientBloodPres(patientBloodPres);
		patientGender = gender;
		cur.setPatientGender(patientGender);
		patientBmi = bmi;
		cur.setPatientBmi(patientBmi);

		isSmoking = false;// these four vars can only pass true/false to frontend, you need to see the printed "tobacco" value, and then assign boolean to these vars
		if(tobacco.equals("yes")){
			isSmoking = true;
		}
		cur.setSmoking(isSmoking);
		isBenzo = true;
		if(benz.equals("no")){
			isBenzo = false;
		}
		cur.setBenzo(isBenzo);
		isOpioid = true;
		if(opiod.equals("no")){
			isOpioid = false;
		}
		cur.setOpioid(isOpioid);
		isOther = true;
		if(other.equals("no")){
			isOther = false;
		}
		cur.setOther(isOther);
		patientPhone = phone;
		cur.setPatientPhone(patientPhone);
		patientAddress =  address;
		cur.setPatientAddress(patientAddress);

		SedationRecord currecord = recordService.create(cur);
		sedationID = currecord.getSedation_id();
		System.out.println(sedationID.toString());

		//sedationrecordRepository.save(currecord);
		// pass these value to patientinfo page to show these info
		model.addAttribute("patientName", patientName);
		model.addAttribute("patientAge", patientAge); 
		model.addAttribute("patientId", patientId);
		model.addAttribute("patientHeight", patientHeight);
		model.addAttribute("patientWeight", patientWeight);
		model.addAttribute("patientBloodPres", patientBloodPres);
		model.addAttribute("patientGender", patientGender);
		model.addAttribute("patientBmi", patientBmi);
		model.addAttribute("isSmoking", isSmoking); //writing logic to get this value according to printed tobacco
		model.addAttribute("isBenzo", isBenzo);
		model.addAttribute("isOpioid", isOpioid);
		model.addAttribute("isOther", isOther);
		model.addAttribute("phone", patientPhone);
		model.addAttribute("address", patientAddress);
		model.addAttribute("sedationID", sedationID);
		return "patientinfo";
	}
	
	@PostMapping("/patientinfo")
	public String showPatientInfo(ModelMap model) {
		
				
		model.addAttribute("patientName", patientName);
		model.addAttribute("patientAge", patientAge);
		model.addAttribute("patientId", patientId);
		model.addAttribute("patientHeight", patientHeight);
		model.addAttribute("patientWeight", patientWeight);
		model.addAttribute("patientBloodPres", patientBloodPres);
		model.addAttribute("patientGender", patientGender);
		model.addAttribute("patientBmi", patientBmi);
		model.addAttribute("isSmoking", isSmoking);
		model.addAttribute("isBenzo", isBenzo);
		model.addAttribute("isOpioid", isOpioid);
		model.addAttribute("isOther", isOther);
		model.addAttribute("phone", patientPhone);
		model.addAttribute("address", patientAddress);

		return "patientinfo";
	}


	@PostMapping("/dose")
	public String showDose(@RequestParam("sedationID") String sedationID, @RequestParam("myscore") String myscore, @RequestParam("mycategory") String mycategory, ModelMap model) {
		System.out.println(myscore);
		// save these two score to gobal
		patientscore = myscore;
		patientcategory = mycategory;
		model.addAttribute("finalscore", patientscore);
		model.addAttribute("finalcategory", patientcategory);
		SedationRecord sedationRecord = recordService.findSedationRecordbyID(patientId);
		sedationRecord.setPatientscore(myscore);
		sedationRecord.setPatientcategory(mycategory);
		//System.out.println("************pre"+sedationRecord.getSedation_id());
		sedationrecordRepository.save(sedationRecord);
		//SedationRecord savedSedationRecord = recordService.findSedationRecordbyID(patientId);
		//System.out.println("************after"+savedSedationRecord.getSedation_id());
		//recordService.update(sedationID,patientscore,patientcategory);
		//SedationRecord sedationRecord = sedationrecordRepository.findByID(sedationID);
		//System.out.println("************"+sedationRecord.getDatetime());
		model.addAttribute("sedationID", sedationID);
		// pass all the patient info here to add background info for this page:
		model.addAttribute("patientName", patientName);
		model.addAttribute("patientAge", patientAge);
		model.addAttribute("patientId", patientId);
		model.addAttribute("patientHeight", patientHeight);
		model.addAttribute("patientWeight", patientWeight);
		model.addAttribute("patientBloodPres", patientBloodPres);
		model.addAttribute("patientGender", patientGender);
		model.addAttribute("patientBmi", patientBmi);
		model.addAttribute("isSmoking", isSmoking); //writing logic to get this value according to printed tobacco
		model.addAttribute("isBenzo", isBenzo);
		model.addAttribute("isOpioid", isOpioid);
		model.addAttribute("isOther", isOther);
		model.addAttribute("phone", patientPhone);
		model.addAttribute("address", patientAddress);
		
		return "dose";
	}

	@PostMapping("/guidelines")
	public String showGuidelines(ModelMap model, @RequestParam("doseOption") String doseOption) {
		// pass all the patient info here to add background info for this page:
				model.addAttribute("patientName", patientName);
				model.addAttribute("patientAge", patientAge); 
				model.addAttribute("patientId", patientId);
				model.addAttribute("patientHeight", patientHeight);
				model.addAttribute("patientWeight", patientWeight);
				model.addAttribute("patientBloodPres", patientBloodPres);
				model.addAttribute("patientGender", patientGender);
				model.addAttribute("patientBmi", patientBmi);
				model.addAttribute("isSmoking", isSmoking); //writing logic to get this value according to printed tobacco
				model.addAttribute("isBenzo", isBenzo);
				model.addAttribute("isOpioid", isOpioid);
				model.addAttribute("isOther", isOther);
				model.addAttribute("phone", patientPhone);
				model.addAttribute("address", patientAddress);

		SedationRecord sedationRecord = recordService.findSedationRecordbyID(patientId);
		sedationRecord.setSedationoption(doseOption);
		sedationrecordRepository.save(sedationRecord);
				
				//TO DO: need to PARSE the dose option and save dose option to DB: 
				//since doctor could go back and change into new option, please save this record ID to gobal, 
				// so you can easily get it. remember to get the record ID when you save it first time
				
				
				//System.out.println(doseOption);
				
		return "guidelines";
	}
	
	@PostMapping("/backtodose")
	public String backtodose(ModelMap model) {
		model.addAttribute("finalscore", patientscore);
		model.addAttribute("finalcategory", patientcategory);
		
		// pass all the patient info here to add background info for this page:
		model.addAttribute("patientName", patientName);
		model.addAttribute("patientAge", patientAge); 
		model.addAttribute("patientId", patientId);
		model.addAttribute("patientHeight", patientHeight);
		model.addAttribute("patientWeight", patientWeight);
		model.addAttribute("patientBloodPres", patientBloodPres);
		model.addAttribute("patientGender", patientGender);
		model.addAttribute("patientBmi", patientBmi);
		model.addAttribute("isSmoking", isSmoking); //writing logic to get this value according to printed tobacco
		model.addAttribute("isBenzo", isBenzo);
		model.addAttribute("isOpioid", isOpioid);
		model.addAttribute("isOther", isOther);
		model.addAttribute("phone", patientPhone);
		model.addAttribute("address", patientAddress);
		return "dose";
	}
	
	@PostMapping("/feedback")
	public String showFeedback(ModelMap model) {
		// pass all the patient info here to add background info for this page:
		model.addAttribute("patientName", patientName);
		model.addAttribute("patientAge", patientAge); 
		model.addAttribute("patientId", patientId);
		model.addAttribute("patientHeight", patientHeight);
		model.addAttribute("patientWeight", patientWeight);
		model.addAttribute("patientBloodPres", patientBloodPres);
		model.addAttribute("patientGender", patientGender);
		model.addAttribute("patientBmi", patientBmi);
		model.addAttribute("isSmoking", isSmoking); //writing logic to get this value according to printed tobacco
		model.addAttribute("isBenzo", isBenzo);
		model.addAttribute("isOpioid", isOpioid);
		model.addAttribute("isOther", isOther);
		model.addAttribute("phone", patientPhone);
		model.addAttribute("address", patientAddress);
		return "feedback";
	}
	
	@PostMapping("/backtoguide")
	public String backtoguide(ModelMap model) {
		// pass all the patient info here to add background info for this page:
		model.addAttribute("patientName", patientName);
		model.addAttribute("patientAge", patientAge); 
		model.addAttribute("patientId", patientId);
		model.addAttribute("patientHeight", patientHeight);
		model.addAttribute("patientWeight", patientWeight);
		model.addAttribute("patientBloodPres", patientBloodPres);
		model.addAttribute("patientGender", patientGender);
		model.addAttribute("patientBmi", patientBmi);
		model.addAttribute("isSmoking", isSmoking); //writing logic to get this value according to printed tobacco
		model.addAttribute("isBenzo", isBenzo);
		model.addAttribute("isOpioid", isOpioid);
		model.addAttribute("isOther", isOther);
		model.addAttribute("phone", patientPhone);
		model.addAttribute("address", patientAddress);
		return "guidelines";
	}
	
	@PostMapping("/end")
	public String showEnd(@RequestParam("selection") String selection, @RequestParam("degree") String degree, 
			              @RequestParam("satisfaction") String satisfaction, @RequestParam("recovery") String recovery) {
		//TO DO: save feedback to db
//		System.out.println(selection);
//		System.out.println(degree);
//		System.out.println(satisfaction);
//		System.out.println(recovery);
		Feedback feedback = new Feedback(selection, degree, satisfaction, recovery);
		SedationRecord sedationRecord = recordService.findSedationRecordbyID(patientId);
		sedationRecord.setFeedback(feedback);
		sedationrecordRepository.save(sedationRecord);

		return "login";
	}

	@GetMapping("/")
	public ModelAndView showForm() {
		return new ModelAndView("showPatientForm", "patientForm", new PatientForm());
	}
	
	@GetMapping(value = { "/hello" })
	public String welcome(ModelMap model) {
		return "hello";
	}

	@GetMapping("/mongowelcome")
	public String mongowelcome(ModelMap model) {

		List<PatientMongo> patient = patientrepository.findAll();
		if (patient == null) {
			model.addAttribute("weight", "null patient found");
			return "connected";
		} else {
			model.addAttribute("name", patient.get(0).getName());
			model.addAttribute("weight", patient.get(0).getWeight());
			model.addAttribute("height", patient.get(0).getHeight());
			return "connected";
		}

	}

	@PostMapping("/calculateRisk")
	public String calculateRisk(@Valid @ModelAttribute("patientForm") PatientForm patientForm, BindingResult result,
			ModelMap model) {
		if (result.hasErrors()) {
			return "error";
		}
		model.addAttribute("name", patientForm.getName());
		return "welcome";
	}

//	@GetMapping("/welcome")
//	public String welcome2() {
//		FhirContext ctx = FhirContext.forDstu3();
//		IGenericClient client = ctx.newRestfulGenericClient(serverBase);
//		Bundle results = client.search().forResource(Patient.class).where(Patient.FAMILY.matches().value("duck"))
//				.returnBundle(org.hl7.fhir.dstu3.model.Bundle.class).execute();
//		// return "Found " + results.getEntry().size() + " ";
//		ModelAndView hi = new ModelAndView("./webapp/hello.jsp");
//		return "hello";
//
//	}

	@GetMapping("/testFhir")
	public String testFhir(ModelMap model) {
		FhirContext ctx = FhirContext.forDstu3();
		IGenericClient client = ctx.newRestfulGenericClient(serverBase);
		Bundle results = client.search().forResource(Patient.class).where(Patient.FAMILY.matches().value("duck"))
				.returnBundle(org.hl7.fhir.dstu3.model.Bundle.class).execute();
		int number = results.getEntry().size();
		model.addAttribute("number", number);
		return "testFhir";

	}

    @GetMapping("/testFhir2")
    public String getbirthday(ModelMap model) {
	    int age = 0;
	    Date cur = new Date();
        FhirContext ctx = FhirContext.forDstu3();
        IGenericClient client = ctx.newRestfulGenericClient(serverBase);
        Patient patient = client.read()
                .resource(Patient.class)
                .withId("1")
                .execute();
        Date birthdate = patient.getBirthDate();
        if (birthdate != null){
            age = (int)(birthdate.getTime()- cur.getTime())/(1000*60*60*24*365);
        }
        else {
            age = 0;
        }

        model.addAttribute("number", age);
        return "showage";

    }


	@GetMapping("/showoption")
	public String showoption(ModelMap model) {
	   /*
	    model.addAttribute("drug",x);
        model.addAttribute("dose",x);
        model.addAttribute("duration",x);
	    return "showOption";
    }*/

		List<SedationOption> options = calulationoption.calculatedoption(1);
		//return "hello";
        System.out.println(options.get(0).toString());
        if (options == null) {
			model.addAttribute("drug", "null drug");
			return "showOption";
		} else {
			model.addAttribute("drug", options.get(0).getDrug());
			model.addAttribute("dose", options.get(0).getDose());
			model.addAttribute("duration", options.get(0).getDuration());
			return "showOption";
		}
	}

    @GetMapping("/all")
    public  String findAll(){
	    String res = "";
	    String pid ="";
        List<SedationRecord> sedationRecordList = sedationrecordRepository.findAll();
        for(SedationRecord sedationRecord: sedationRecordList){
            res += "sedationRecord ID:" + sedationRecord.getSedation_id().toString() + "\n";
            pid += "sedationRecord patientID:" + sedationRecord.getPatientFHIR().getPatientId() + "\n";
            System.out.println(sedationRecord.getSedation_id().toString());
            System.out.println(sedationRecord.getPatientFHIR().getPatientId());
            System.out.println(sedationRecord.getPatientFHIR().getSmoking());
        }
//        List<User> userList = userRepo.findAll();
//        for(User user:userList){
//            res += "user Name:" + user.getUsername() +"\n";
//            System.out.println(user.getUsername());
//
//        }
	    return res;
    }
	// @RequestMapping("/hello")
	// public String hello(Model model, @RequestParam(value="name", required=false,
	// defaultValue="World") String name) {
	// model.addAttribute("name", name);
	// return "hello";
	// }

	// @GetMapping("/welcome")
	// public String calculateRisk(Map<String, Object> model) {
	// model.put("name", name);
	// return "welcome";
	// }

	// @RequestMapping("/welcome")
	// public String foo() {
	// return "welcome";
	// }
}
