package com.topo;

import com.topo.entities.AppRole;
import com.topo.services.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.Stream;

@SpringBootApplication
public class SecServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(AccountService accountService) {
		return args -> {
			accountService.save(new AppRole("USER"));
			accountService.save(new AppRole("ADMIN"));

			Stream.of("user1", "user2", "user3").forEach(username -> {
				accountService.saveUser(username, "1234", "1234");
				accountService.addRoleToUser(username, "USER");
			});

			Stream.of("admin").forEach(username -> {
				accountService.saveUser(username, "1234", "1234");
				accountService.addRoleToUser(username, "ADMIN");
			});
		};
	}

	@Bean
	BCryptPasswordEncoder getBCryptPasswordEncoder() {
		return  new BCryptPasswordEncoder();
	}

}
