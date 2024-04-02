package com.VazquezDev.homebaking.Controllers;

import com.VazquezDev.homebaking.DTO.NewClient;
import com.VazquezDev.homebaking.Models.Client;
import com.VazquezDev.homebaking.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/new")
    public ResponseEntity<String> addClient (@RequestBody NewClient newClient){

    Client client = new Client(newClient.name(),newClient.lastName(),newClient.email(),newClient.password());
    clientRepository.save(client);

    return  new ResponseEntity<>("todo salio bien", HttpStatus.CREATED);

    }

    @GetMapping("/all")
    public List<Client> getAll(){return clientRepository.findAll();}

//    @GetMapping("/current")
//    public



}
