package com.VazquezDev.homebaking.Controllers;

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
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/all")
    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity<Object> getAccount(@PathVariable UUID id){
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }


}
