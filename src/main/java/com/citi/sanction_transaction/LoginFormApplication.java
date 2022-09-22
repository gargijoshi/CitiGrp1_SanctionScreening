package com.citi.sanction_transaction;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.citi.sanction_transaction.storage.StorageProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class LoginFormApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginFormApplication.class, args);
	}
}