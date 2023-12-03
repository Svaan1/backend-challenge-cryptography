package com.svaan1.backendcryptography;

import com.svaan1.backendcryptography.converter.TransactionConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendCryptographyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendCryptographyApplication.class, args);
	}

	@Bean
	public TransactionConverter transactionConverter() {
		return new TransactionConverter();
	}
}
