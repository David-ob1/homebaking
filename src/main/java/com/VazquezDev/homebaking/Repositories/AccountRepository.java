package com.VazquezDev.homebaking.Repositories;

import com.VazquezDev.homebaking.Models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,String> {

    boolean existsByNumber (String number);

}
