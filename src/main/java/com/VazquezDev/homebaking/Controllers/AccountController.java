package com.VazquezDev.homebaking.Controllers;

import com.VazquezDev.homebaking.Models.Account;
import com.VazquezDev.homebaking.Repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;


    @GetMapping("/all")
    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }
}
