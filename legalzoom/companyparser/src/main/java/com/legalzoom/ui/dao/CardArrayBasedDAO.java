package com.legalzoom.ui.dao;

import com.legalzoom.ui.model.card.Card;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
@Repository
@Scope(value="session")
public class CardArrayBasedDAO implements CardDAO {



    List<Card> cardList;

    @PostConstruct
    private void init(){
        cardList =new ArrayList<>();
    }

    @Override
    public void add(Card card) {
        cardList.add(card);
    }

    @Override
    public void add(List<Card> cardList) {
        cardList.addAll(cardList);
    }

    @Override
    public List<Card> getList() {
        return cardList;
    }
}
