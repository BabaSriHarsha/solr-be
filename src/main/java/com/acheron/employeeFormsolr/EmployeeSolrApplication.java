package com.acheron.employeeFormsolr;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.acheron.employeeFormsolr.repository.jpa.**")
public class EmployeeSolrApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeSolrApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
	}
}