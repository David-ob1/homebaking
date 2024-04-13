package com.VazquezDev.homebaking.Repositories;

import com.VazquezDev.homebaking.Models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {

Transaction findTransactionById(Long id);
}
