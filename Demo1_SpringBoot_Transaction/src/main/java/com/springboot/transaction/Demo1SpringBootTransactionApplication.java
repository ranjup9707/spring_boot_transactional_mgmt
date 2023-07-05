package com.springboot.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Demo1SpringBootTransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(Demo1SpringBootTransactionApplication.class, args);
	}

}
