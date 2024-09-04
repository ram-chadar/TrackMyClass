package com.jbk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrackMyClassApplication {
	
	// get instance of logger
	static Logger logger=	LoggerFactory.getLogger(TrackMyClassApplication.class);

	

	public static void main(String[] args) {
		SpringApplication.run(TrackMyClassApplication.class, args);
		logger.info("App Started");
	}

}
