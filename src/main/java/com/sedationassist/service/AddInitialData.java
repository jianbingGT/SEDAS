package com.sedationassist.service;

import com.sedationassist.model.*;
import com.sedationassist.repositories.PatientMongoRepository;
import com.sedationassist.repositories.SedationRecordRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class AddInitialData implements CommandLineRunner {
    @Autowired
    PatientMongoRepository patientRepository;

    @Autowired
    SedationRecordRepository sedationrecordRepository;

    @Override
    public void run(String... strings) throws Exception {

      //  this.patientRepository.deleteAll();
      //  this.sedationrecordRepository.deleteAll();


            SedationRecord record1 = sedationrecordRepository.save(new SedationRecord( new PatientFHIR("Yanqun Xu","18","2008-01-15","patient1","170","100",
                "140/85","female","17.3",false,false,false,false,"256-865-7789",
                 "1675 Cleveland Ave, Blacksburg, VA, 24060" ),"1", "I", "Fentanyl, 10, 20", new Feedback("1", "1", "9","good")));

            SedationRecord record2 = sedationrecordRepository.save(new SedationRecord(new PatientFHIR("Yanqun Xu","18","2008-01-15","patient1","170","100","100/110","female","17.3",false,false,false,false,"256-865-7789","1675 Cleveland Ave, Blacksburg, VA, 24060" ),
                   "1", "I", "Fentanyl, 15, 30", new Feedback("2", "5", "8","good")));

            SedationRecord record3 = sedationrecordRepository.save(new SedationRecord(new PatientFHIR("Jeremy Grey","55", "1963-10-05","patient2","190","150","99/110","male","20.7",false,false,false,false,"256-865-7789","1675 Cleveland Ave, Blacksburg, VA, 24060" ),
                    "1", "I", "Fentanyl, 15, 30", new Feedback("2", "6", "8","good")));


        }
}
