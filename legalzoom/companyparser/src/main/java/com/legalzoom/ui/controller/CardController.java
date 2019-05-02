package com.legalzoom.ui.controller;

import com.legalzoom.ui.dao.CardDAO;
import com.legalzoom.ui.dto.cardDTO;
import com.legalzoom.ui.model.card.Card;
import com.legalzoom.ui.model.card.CardList;
import com.legalzoom.ui.service.CardTransformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Scope("session")
public class CardController {

    @Autowired
    CardTransformationService cardTransformationService;

    @Autowired
    CardDAO cardDAO;

    @RequestMapping(value = "getcards", method = RequestMethod.GET)
    public @ResponseBody
    cardDTO getCards( ) {
        cardDTO output = new cardDTO();
        List<Card> cards = cardDAO.getList();
        CardList cardList=new CardList();
        cardList.setList(cardTransformationService.transform(cards));
        output.setCardList(cardList);
        output.setStatus(cardDTO.Status.OK);
        return output;
    }

    @RequestMapping(value = "addcard", method = RequestMethod.POST)
    public cardDTO addCard(@RequestBody Card card){
        cardDTO result=new cardDTO();

        cardDAO.add(card);
        result.setStatus(cardDTO.Status.OK);
        return result;
    }

    @RequestMapping(value = "addcards", consumes = "text/csv",
            method = RequestMethod.POST)
    public cardDTO addCards(@RequestBody List<Card> cardList){
        cardDTO result=new cardDTO();
        cardDAO.add(cardList);
        result.setStatus(cardDTO.Status.OK);
        return result;
    }


}
