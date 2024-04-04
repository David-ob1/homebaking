package com.VazquezDev.homebaking;

import com.VazquezDev.homebaking.Models.Account;
import com.VazquezDev.homebaking.Models.Client;
import com.VazquezDev.homebaking.Repositories.AccountRepository;
import com.VazquezDev.homebaking.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@SpringBootApplication
public class HomebakingApplication {
	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(HomebakingApplication.class, args);
	}

	@Bean
	public CommandLineRunner initDat(ClientRepository clientRepository
									, AccountRepository accountRepository){

	return args -> {

		Client melba = new Client("Melba","Morel","melba@mindhub.com",passwordEncoder.encode("melbamorel"));
		clientRepository.save(melba);

		Client Nicolas = new Client("Nicolas", "Gonzales","nico@gmail.com",
				passwordEncoder.encode("Ediciones1"));

		clientRepository.save(Nicolas);

		Account account1 = new Account("VIN001", LocalDate.now(),20000);
		melba.addAccount(account1);

		accountRepository.save(account1);



	};

	}

}
