package com.sedationassist.sedationassistspringbootapp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.sedationassist.model.SedationOption;
import com.sedationassist.service.CalculateOption;




public class CalculateOptionTest {
	
	//@Autowired
	CalculateOption calculateOption = new CalculateOption();
	
	
	@Test
	public void testCalculateOption() {
		//String option = "option 1";
		
		SedationOption option = new SedationOption(null, null, null);
		option.setDrug("Fentnyl");
		option.setDose("35 mcg IV");
		option.setDuration(50);
				
	//	org.junit.Assertions.assertEquals()
		assertEquals(option.toString(),calculateOption.calculatedoption(1).get(0).toString());
		//System.out.println(calculateOption.calculatedoption(1).get(0).toString().equals(option.toString()));
		//System.out.println(option);
		//System.out.println(calculateOption.calculatedoption(1).get(0));

		
	}

}
