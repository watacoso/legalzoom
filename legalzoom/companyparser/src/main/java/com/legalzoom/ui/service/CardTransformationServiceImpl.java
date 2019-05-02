package com.legalzoom.ui.service;

import com.legalzoom.ui.model.card.Card;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardTransformationServiceImpl implements CardTransformationService {
    @Override
    public List<Card> transform(List<Card> cardListInput) {
        List<Card> outputCardList = cardListInput
                .stream().map(this::getCensoredCard)
                .sorted((b1,b2)-> b2.getExpiryDate().compareTo(b1.getExpiryDate()))
                .collect(Collectors.toList());
        return outputCardList;
    }


    private Card getCensoredCard(Card card){
        String censoredCardNumber=getCensorcardNumber(card.getCardNumber());
        Card newCard =new Card();
        newCard.setName(card.getName());
        newCard.setCensoredCardNumber(censoredCardNumber);
        newCard.setExpiryDate(card.getExpiryDate());
        return newCard;
    }

    private String getCensorcardNumber(String uncensoredCardNumber){
        return String
                .format("%16s",uncensoredCardNumber.substring(12,16))
                .replace(" ","*");
    }
}
