package com.legalzoom.ui.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.legalzoom.ui.model.card.CardList;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class cardDTO {


    public enum Status{
        OK,KO
    }

    private Status status;
    private String message;
    CardList cardList;

    public CardList getCardList() {

        return cardList;
    }

    public void setCardList(CardList cardList) {
        this.cardList = cardList;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
