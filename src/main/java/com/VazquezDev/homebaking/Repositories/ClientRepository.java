package com.VazquezDev.homebaking.Repositories;

import com.VazquezDev.homebaking.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,String> {

    Client findByEmail(String email);

    boolean existsByEmail(String email);
}
