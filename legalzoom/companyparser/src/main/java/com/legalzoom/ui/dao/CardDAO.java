package com.legalzoom.ui.dao;

import com.legalzoom.ui.model.card.Card;

import java.util.List;

public interface CardDAO {

    void add(Card card);
    void add(List<Card> cardList);
    List<Card> getList();
}
