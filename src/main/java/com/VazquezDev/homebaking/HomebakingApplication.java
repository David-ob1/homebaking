package com.VazquezDev.homebaking;

import com.VazquezDev.homebaking.Models.*;
import com.VazquezDev.homebaking.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.List;


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
									, TransactionRepository transactionRepository
									, LoanRepository loanRepository
									, ClientLoandRepository clientLoandRepository){

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

		Transaction transaction1 = new Transaction(TransactionType.DEBIT,1000,"shop",LocalDate.now());
		account2.addTransactions(transaction1);
		transactionRepository.save(transaction1);

		Transaction transaction2 = new Transaction(TransactionType.CREDIT,200,"bonus",LocalDate.now());
		account2.addTransactions(transaction2);
		transactionRepository.save(transaction2);

		Transaction transaction3 = new Transaction(TransactionType.CREDIT,900,"salary",LocalDate.now());
		account2.addTransactions(transaction3);
		transactionRepository.save(transaction3);

	//defino las listas de element Collection
		List<Integer> paymentMorgage =List.of(12,24,36,48,60);
		List <Integer> paymetPersonal = List.of(6,12,24);
		List <Integer> paymetAutomotive = List.of(6,12,24,36);

//el ultimo valor viene de la lista de arriba que seria el @ElementC
	Loan Morgage = new Loan("Morgage",500000,paymentMorgage);
	Loan Personal = new Loan("Personal",100.000,paymetPersonal);
	Loan Automotive = new Loan("Automotive",300.000,paymetAutomotive);




	};

	}

}
