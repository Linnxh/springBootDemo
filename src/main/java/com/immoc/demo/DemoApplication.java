package com.immoc.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.immoc")
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
