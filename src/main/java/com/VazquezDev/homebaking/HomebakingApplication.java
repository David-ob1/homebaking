package com.VazquezDev.homebaking;

import com.VazquezDev.homebaking.Models.Account;
import com.VazquezDev.homebaking.Models.Client;
import com.VazquezDev.homebaking.Models.Transaction;
import com.VazquezDev.homebaking.Models.TransactionType;
import com.VazquezDev.homebaking.Repositories.AccountRepository;
import com.VazquezDev.homebaking.Repositories.ClientRepository;
import com.VazquezDev.homebaking.Repositories.TransactionRepository;
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
									, AccountRepository accountRepository
									, TransactionRepository transactionRepository){

	return args -> {

		Client melba = new Client("Melba","Morel","melba@mindhub.com",passwordEncoder.encode("melbamorel"));
		clientRepository.save(melba);

		Client nicolas = new Client("Nicolas", "Gonzales","nico@gmail.com",
				passwordEncoder.encode("Ediciones1"));

		clientRepository.save(nicolas);

		Account account1 = new Account("VIN001", LocalDate.now(),20000);
		melba.addAccount(account1);
		accountRepository.save(account1);

		Account account2 = new Account("VIN002",LocalDate.now().plusDays(1),7500);
		melba.addAccount(account2);
		accountRepository.save(account2);

		Account account3 = new Account("NICO001",LocalDate.now(),10);
		nicolas.addAccount(account3);
		accountRepository.save(account3);

//		Transaction transaction = new Transaction(TransactionType.DEBIT,1000,"shop",LocalDate.now());

	};

	}

}
