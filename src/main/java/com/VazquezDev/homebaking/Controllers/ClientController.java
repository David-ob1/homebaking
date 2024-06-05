package com.VazquezDev.homebaking.Controllers;

import com.VazquezDev.homebaking.DTO.ClientDTO;
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
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/new")
    public ResponseEntity<String> addClient (@RequestBody NewClient newClient){

        if(clientRepository.existsByEmail(newClient.email())){
            return new ResponseEntity<>("Email already in use",HttpStatus.FORBIDDEN);
        }

    Client client = new Client(newClient.name(),newClient.lastName(),newClient.email(),passwordEncoder.encode(newClient.password()));
    clientRepository.save(client);

    return  new ResponseEntity<>("todo salio bien", HttpStatus.CREATED);

    }

    @GetMapping("/all")
    public List<ClientDTO> getAllClients(){

        List <ClientDTO> clients = clientRepository.findAll()
                    .stream()
                    .map(client -> new ClientDTO(client)).collect(Collectors.toList());


        return clients;

    }


    @GetMapping("{id}")
    public ResponseEntity<Object> getClient(@PathVariable UUID id){
        Client client = clientRepository.findClientById(id);

    if (client != null){
        return new ResponseEntity<>(new ClientDTO(client),HttpStatus.OK);
    }else {
    return new ResponseEntity<>("User not found",HttpStatus.FORBIDDEN);
    }

    }

}
