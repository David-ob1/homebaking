package com.VazquezDev.homebaking.DTO;

import com.VazquezDev.homebaking.Models.Client;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ClientDTO {

    private String id;

    private String name,lastName,email;

    private List<AccountDTO> accounts;

    private List<ClientLoanDTO> loans;

    private List<CardDTO> cards;

    public ClientDTO(Client client){
        id=client.getId();
        name = client.getName();
        lastName=client.getLastName();
        email = client.getEmail();
        accounts = client.getAccounts()
                .stream()
                .map(account -> new AccountDTO(account) )
                .collect(Collectors.toList());
//        loans = client.getClientLoans()
//                .stream()
//                .map(clientLoan -> new ClientLoanDTO(clientLoan)).collect(Collectors.toList());
//        cards = clent.get

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public List<AccountDTO> getAccounts() {
        return accounts;
    }

    public List<ClientLoanDTO> getLoans() {
        return loans;
    }

//    public List<CardDTO> getCards() {
//        return cards;
//    }
}
