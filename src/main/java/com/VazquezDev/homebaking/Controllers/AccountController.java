package com.VazquezDev.homebaking.Controllers;

import com.VazquezDev.homebaking.DTO.AccountDTO;
import com.VazquezDev.homebaking.Models.Account;
import com.VazquezDev.homebaking.Repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/all")
    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<Object> getAccount(@PathVariable String id){

         Account account = accountRepository.findAccountById(id);

         if (account != null){
             return new ResponseEntity<>(new AccountDTO(account), HttpStatus.OK);
         }else{
             return new ResponseEntity<>("Account not found", HttpStatus.FORBIDDEN);
         }

    }





}
