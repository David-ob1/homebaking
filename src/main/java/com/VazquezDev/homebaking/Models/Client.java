package com.VazquezDev.homebaking.Models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;



    private String name,lastName,email,password;
    @OneToMany(mappedBy = "client",fetch = FetchType.EAGER)
    private Set<Account> accounts = new HashSet<>();//genera un espacio de referencia

    @OneToMany(mappedBy = "client",fetch = FetchType.EAGER)
    private Set<ClientLoan> clientLoans = new HashSet<>();

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private Set<Card> cards = new HashSet<>();

    public Client() {
    }

    public Client(String name, String lastName, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void addAccount (Account account){
        account.setClient(this);
        this.accounts.add(account);

    }

//    le indico al prestamo le agrego el cliente
//    y al cliente le agrego el prestamo
    public void addClientLoan (ClientLoan clientLoan){
        clientLoan.setClient(this);
        this.clientLoans.add(clientLoan);

    }

    public Set<ClientLoan> getClientLoans() {
        return clientLoans;
    }

    public void addCard(Card card){
        card.setClient(this);
        this.cards.add(card);

    }

    public Set<Card> getCards() {
        return cards;
    }


}
