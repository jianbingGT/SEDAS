package com.sedationassist.sedationassistspringbootapp;

import com.sedationassist.model.PatientFHIR;
import com.sedationassist.model.User;
import com.sedationassist.service.PatientInfo;
import com.sedationassist.service.UserService;
import org.bson.types.ObjectId;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;
import org.junit.runner.RunWith;
//import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
/*

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(
		classes = Application.class)
public class SedationAssistSpringBootAppApplicationTests {
    private static PatientInfo patientInfo;
    private static UserService userService;
    private static User user;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContect = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    @Before
    public void setUp(){
        patientInfo = new PatientInfo();
        userService = new UserService();

    }
    public void setupOutput(){
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContect));
    }
    @After
    public void teardown(){}
    public void teardownOutput(){
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

	@Test
	public void findpatientinfobyIDTest() {
        PatientFHIR patientFHIR = patientInfo.findpatientinfobyID("5beba4f1c10a8a4ce4a30a73");
        assertEquals(-1, patientFHIR.getGender());

	}

//	@Test
//    public void findByUsernameTest(){
//        User user = userService.findByUsername("jameshello");
//        assertEquals("jameshello", userService.save());
//    }
//    @Test
//    public void getIDTest(){
//        ObjectId objectId = user.getId();
//        assertEquals("5be7049f0a758c15f067d93b", user.getId());
//
//
//    }

}
*/