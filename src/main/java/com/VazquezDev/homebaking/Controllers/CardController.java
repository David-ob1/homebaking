package com.VazquezDev.homebaking.Controllers;

import com.VazquezDev.homebaking.DTO.CardDTO;
import com.VazquezDev.homebaking.Models.Card;
import com.VazquezDev.homebaking.Repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/Cards")
public class CardController {
    @Autowired
    private CardRepository cardRepository;

    @GetMapping("/all")
    public List<Card> getAllCards(){ return cardRepository.findAll(); }

    @GetMapping("/card/{id}")
    public ResponseEntity<Object> getCard(@PathVariable Long id){

        Card card = cardRepository.findCardById(id);

        if (card != null){
            return new ResponseEntity<>(new CardDTO(card), HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Card not found", HttpStatus.FORBIDDEN);
        }

    }


}
