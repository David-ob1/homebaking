package com.VazquezDev.homebaking.Repositories;

import com.VazquezDev.homebaking.Models.ClientLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientLoanRepository extends JpaRepository<ClientLoan,Long> {


}