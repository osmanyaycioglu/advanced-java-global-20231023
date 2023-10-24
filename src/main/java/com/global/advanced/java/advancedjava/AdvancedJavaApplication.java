package com.global.advanced.java.advancedjava;

import com.global.advanced.java.advancedjava.java.properties.AppProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdvancedJavaApplication implements ApplicationRunner {

	@Autowired
	private AppProperty appProperty;

	public static void main(String[] args) {
		SpringApplication.run(AdvancedJavaApplication.class, args);

		Class<AdvancedJavaApplication> c = AdvancedJavaApplication.class;
		c.getDeclaredMethods();
	}

	@Override
	public void run(final ApplicationArguments args) throws Exception {
		System.out.println("Spring properties : " + appProperty);
	}
}
