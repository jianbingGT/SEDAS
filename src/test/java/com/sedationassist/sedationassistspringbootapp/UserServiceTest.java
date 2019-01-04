package com.sedationassist.sedationassistspringbootapp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.sedationassist.service.UserService;


public class UserServiceTest {
	
	@Autowired
	UserService userService = new UserService();
		
	
	@Test
	public void testUserService() {
		
		
		
	}
	
	
	
	

}
