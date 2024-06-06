package com.VazquezDev.homebaking.Repositories;

import com.VazquezDev.homebaking.Models.Card;
import org.hibernate.Cache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository <Card,Long> {

    Card findCardById(Long id);
    boolean existsByNumber(String number);

//    boolean existsByClientAndCardColorAndCardType(Card card);

}
