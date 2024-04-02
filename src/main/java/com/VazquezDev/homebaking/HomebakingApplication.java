package com.VazquezDev.homebaking;

import com.VazquezDev.homebaking.Models.Client;
import com.VazquezDev.homebaking.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class HomebakingApplication {
	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(HomebakingApplication.class, args);
	}

	@Bean
	public CommandLineRunner initDat(ClientRepository clientRepository){

	return args -> {

		Client melba = new Client("Melba","Morel","melba@mindhub.com","melbamorel");
		clientRepository.save(melba);

	};

	}

}
