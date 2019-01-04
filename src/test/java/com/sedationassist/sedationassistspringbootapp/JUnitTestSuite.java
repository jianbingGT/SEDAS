package com.sedationassist.sedationassistspringbootapp;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	RiskAssessmentControllerTest.class,
	AddInitialDataTest.class,
	CalculateOptionTest.class,
	PatientInfoTest.class,
	RecordServiceTest.class,
	UserServiceTest.class
	
	
})
public class JUnitTestSuite {

}
