package org.babareko.graduationBoot;

import lombok.AllArgsConstructor;
import org.babareko.graduationBoot.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class GraduationBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraduationBootApplication.class, args);
	}




}
