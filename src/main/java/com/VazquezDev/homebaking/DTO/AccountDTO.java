package com.VazquezDev.homebaking.DTO;

import com.VazquezDev.homebaking.Models.Account;

import java.time.LocalDate;

public class AccountDTO {

    private String id;

    private String number;
    private LocalDate creationDate;

    private double balance;

    public AccountDTO(Account account){
        id =account.getId();
        number = account.getNumber();
        creationDate =account.getCreationDate();
        balance = account.getBalance();

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
