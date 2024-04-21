package com.VazquezDev.homebaking.Repositories;

import com.VazquezDev.homebaking.Models.Card;
import org.hibernate.Cache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository <Card,Long> {

    boolean existsByNumber(long number);
    boolean existsByClientAndColorAndCardType(Card card);

}
