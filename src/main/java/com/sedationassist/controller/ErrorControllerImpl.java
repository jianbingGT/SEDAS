package com.sedationassist.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorControllerImpl implements ErrorController{

	 private static final String PATH = "/error";

	    @RequestMapping(value = PATH)
	    public String error(ModelMap model) {
	    	model.addAttribute("error", "Please input valid username and password!");
	        return "login";
	    }

	    @Override
	    public String getErrorPath() {
	        return PATH;
	    }
}