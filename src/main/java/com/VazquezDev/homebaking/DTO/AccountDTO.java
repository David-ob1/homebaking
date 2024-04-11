package com.VazquezDev.homebaking.DTO;

import com.VazquezDev.homebaking.Models.Account;
import com.VazquezDev.homebaking.Models.Transaction;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public class AccountDTO {

    private String id;

    private String number;
    private LocalDate creationDate;

    private double balance;


    private Set<TransactionDTO> transactions;

    public AccountDTO(Account account){
        id =account.getId();
        number = account.getNumber();
        creationDate =account.getCreationDate();
        balance = account.getBalance();
        transactions = account.getTransactions().stream().map(transaction -> new TransactionDTO(transaction)).collect(Collectors.toSet());
    }

    public String getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public double getBalance() {
        return balance;
    }


}
