package com.VazquezDev.homebaking.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Client cardHolder;

//    private CardType cardType;
    private CardColor cardColor;

    private String number;

    private String cvv;

    private LocalDate fromDate;

    private LocalDate thruDate;

    @ManyToOne(fetch = FetchType.EAGER)
    private Client client;


    public Card() {
    }

    public Card(Client cardHolder, CardColor cardColor, String number, String cvv, LocalDate fromDate, LocalDate thruDate) {
        this.cardHolder = cardHolder;
//        this.cardType = cardType;
        this.cardColor = cardColor;
        this.number = number;
        this.cvv = cvv;
        this.fromDate = fromDate;
        this.thruDate = thruDate;
    }

    public Long getId() {
        return id;
    }


    public Client getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(Client cardHolder) {
        this.cardHolder = cardHolder;
    }


    public CardColor getCardColor() {
        return cardColor;
    }

    public void setCardColor(CardColor cardColor) {
        this.cardColor = cardColor;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
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

    @JsonIgnore
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
