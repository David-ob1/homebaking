package com.VazquezDev.homebaking.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Client cardHolder;

    private CardType cardType;
    private CardColor cardColor;

    private long number;

    private String cvv;

    private LocalDate fromDate;

    private LocalDate thruDate;


    public Card() {
    }

    public Card(Client cardHolder, CardType cardType, CardColor cardColor, long number, String cvv, LocalDate fromDate, LocalDate thruDate) {
        this.cardHolder = cardHolder;
        this.cardType = cardType;
        this.cardColor = cardColor;
        this.number = number;
        this.cvv = cvv;
        this.fromDate = fromDate;
        this.thruDate = thruDate;
    }

    public long getId() {
        return id;
    }


    public Client getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(Client cardHolder) {
        this.cardHolder = cardHolder;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public CardColor getCardColor() {
        return cardColor;
    }

    public void setCardColor(CardColor cardColor) {
        this.cardColor = cardColor;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getThruDate() {
        return thruDate;
    }

    public void setThruDate(LocalDate thruDate) {
        this.thruDate = thruDate;
    }
}
