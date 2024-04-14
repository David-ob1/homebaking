package com.VazquezDev.homebaking.Repositories;

import com.VazquezDev.homebaking.Models.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository <Loan,Long> {


}
