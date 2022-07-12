package br.com.pet.storeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
public class StoreapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreapiApplication.class, args);
	}

}
