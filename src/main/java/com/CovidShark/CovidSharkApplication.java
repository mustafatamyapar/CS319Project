package com.CovidShark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class CovidSharkApplication {

	public static void main(String[] args) {

		SpringApplication.run(CovidSharkApplication.class, args);
		Form form = new Form("26/12/21");
	}

}
