package com.VazquezDev.homebaking.DTO;

import com.VazquezDev.homebaking.Models.Transaction;
import com.VazquezDev.homebaking.Models.TransactionType;

import java.time.LocalDate;

public class TransactionDTO {

    private long id;

    private TransactionType type;

    private  double amount;

    private  String description;

    private LocalDate date;

    public TransactionDTO(Transaction transaction) {
        id = transaction.getId();
        type = transaction.getType();
        amount = transaction.getAmount();
    description = transaction.getDescription();
    date= transaction.getDate();
    }

    public long getId() {
        return id;
    }

    public TransactionType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }
}
