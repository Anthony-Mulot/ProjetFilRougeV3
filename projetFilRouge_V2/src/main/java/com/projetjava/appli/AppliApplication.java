package com.projetjava.appli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@SpringBootApplication
public class AppliApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppliApplication.class, args);
	}

}
