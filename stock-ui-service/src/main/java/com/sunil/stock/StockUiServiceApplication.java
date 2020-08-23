package com.sunil.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StockUiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockUiServiceApplication.class, args);
	}

}
