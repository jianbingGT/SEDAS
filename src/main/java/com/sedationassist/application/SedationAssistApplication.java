package com.sedationassist.application;


import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.client.interceptor.LoggingInterceptor;
import org.hl7.fhir.dstu3.model.CapabilityStatement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.sedationassist.repositories.PatientMongoRepository;

@SpringBootApplication
@ComponentScan("com.sedationassist")
@EnableMongoRepositories(basePackages ="com.sedationassist.repositories")
public class SedationAssistApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SedationAssistApplication.class);
	}
	 
    public static void main(String[] args) {
        SpringApplication.run(SedationAssistApplication.class, args);
    }

//    @Bean
//    public LoggingInterceptor loggingInterceptor() {
//        return new LoggingInterceptor(true);
//    }
//
//    @Bean
//    public CommandLineRunner runner(final IGenericClient fhirClient) {
//        return new CommandLineRunner() {
//
//            @Override
//            public void run(String... args) throws Exception {
//                fhirClient.capabilities()
//                        .ofType(CapabilityStatement.class)
//                        .execute();
//            }
//        };
//    }
    
//    Bundle results = fhirClient
//	          .search()
//	          .forResource(Patient.class)
//	          .where(Patient.FAMILY.matches().value("duck"))
//	          .returnBundle(org.hl7.fhir.dstu3.model.Bundle.class)
//	          .execute();
//	     
//	    System.out.println("Found " + results.getEntry().size() + " patients named 'duck'");

}
