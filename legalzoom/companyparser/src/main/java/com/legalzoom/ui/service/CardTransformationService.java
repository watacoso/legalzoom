package com.legalzoom.ui.service;

import com.legalzoom.ui.model.card.Card;

import java.util.List;

public interface CardTransformationService {

     List<Card>  transform(List<Card> cardListInput);
}
