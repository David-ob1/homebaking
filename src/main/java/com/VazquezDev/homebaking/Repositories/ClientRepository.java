package com.VazquezDev.homebaking.Repositories;

import com.VazquezDev.homebaking.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,String> {

    Client findByEmail(String email);

    Client findClientById(String id);

    boolean existsByEmail(String email);
}
