package com.example.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CrudUsingFileSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudUsingFileSystemApplication.class, args);
	}

}
