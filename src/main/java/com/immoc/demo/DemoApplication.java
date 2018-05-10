package com.immoc.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
//	@Override
//	protected SpringApplicationBuilder configure(
//			SpringApplicationBuilder application) {
//		return application.sources(DemoApplication.class);
//	}
}
