package com.hci.doatap;

import com.hci.doatap.model.AppUser;
import com.hci.doatap.model.Role;
import com.hci.doatap.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class DoatapApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoatapApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveUser((new AppUser(null, "nikos", "konstas", "dimitris", "zoi", "nikos@mail.com", "1234", "1111", new ArrayList<>())));
			userService.saveUser((new AppUser(null, "thanasis", "oikonomou", "panagiotis", "katerina", "thanasis@mail.com", "1234", "2222", new ArrayList<>())));
			userService.saveUser((new AppUser(null, "admin", "admin", "kostas", "giota", "admin@mail.com", "0000", "1111", new ArrayList<>())));
			userService.addRoleToUser("nikos@mail.com", "ROLE_USER");
			userService.addRoleToUser("thanasis@mail.com", "ROLE_USER");
			userService.addRoleToUser("admin@mail.com", "ROLE_ADMIN");



		};
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}



}