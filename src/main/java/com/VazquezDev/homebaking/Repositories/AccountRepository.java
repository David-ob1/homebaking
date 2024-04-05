package com.VazquezDev.homebaking.Repositories;

import com.VazquezDev.homebaking.Models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account,String> {
    Account findAccountById (String id);
    boolean existsByNumber (String number);

}
