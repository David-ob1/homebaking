package com.VazquezDev.homebaking.Controllers;


import com.VazquezDev.homebaking.DTO.TransactionDTO;
import com.VazquezDev.homebaking.Models.Transaction;
import com.VazquezDev.homebaking.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping("{id}")
    public ResponseEntity<Object> getTransaction(@PathVariable long id ){
        Transaction transaction = transactionRepository.findTransactionById(id);

//        TransactionDTO transactionDTO = new TransactionDTO(transaction);

        return new ResponseEntity<>(new TransactionDTO(transaction), HttpStatus.OK);
    };

    @GetMapping("/all")
    public Set<TransactionDTO> getAllTransactions (){
        return transactionRepository.findAll().stream()
                .map(transaction -> new TransactionDTO(transaction))
                .collect(Collectors.toSet());
    }


}
