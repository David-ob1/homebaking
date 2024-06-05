package com.VazquezDev.homebaking.Repositories;

import com.VazquezDev.homebaking.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {

    Client findByEmail(String email);

    Client findClientById(UUID id);

    boolean existsByEmail(String email);
}
