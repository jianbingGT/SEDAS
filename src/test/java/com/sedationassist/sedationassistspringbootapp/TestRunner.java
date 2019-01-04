package com.sedationassist.sedationassistspringbootapp;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Result result = JUnitCore.runClasses(JUnitTestSuite.class);
		Logger logger = LoggerFactory.getLogger(TestRunner.class);
		
		for (Failure failure : result.getFailures()) {
			logger.error(failure.toString());
		}
		
		logger.info(String.valueOf(result.wasSuccessful()));

	}

}
