package com.exsgi.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.exsgi.api","com.exsgi.controller","com.exsgi.model","com.exsgi.exception","com.exsgi.security"})

public class MerkleCloudsProjectsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MerkleCloudsProjectsApplication.class, args);
	}
}
