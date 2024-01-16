package com.sm.demo;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyApplicationUsingJPAH2Db {
	
	public static void main(String [] args) {
		SpringApplication myApp = new SpringApplication(MyApplicationUsingJPAH2Db.class);
		myApp.setDefaultProperties(Collections.singletonMap("server.port", "8089"));
		myApp.run(args);
	}
}
