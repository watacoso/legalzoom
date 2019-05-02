package com.legalzoom.ui.model.card;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.opencsv.bean.CsvBindByName;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Card implements Serializable {

    @CsvBindByName
    private String name;
    @CsvBindByName
    private String cardNumber;
    private String censoredCardNumber;
    @CsvBindByName
    @JsonFormat(pattern="MMM-yyyy")
    private Date expiryDate;


    public Card() {

    }

    public String getName() {
        return name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCensoredCardNumber() {
        return censoredCardNumber;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new RuntimeException("name required");
        }
        this.name = name;
    }

    public void setCardNumber(String cardNumber) {
        if (cardNumber == null || cardNumber.isEmpty()) {
            throw new RuntimeException("cardnumber required");
        }

        if (!cardNumber.matches("[0-9]{16}")) {
            throw new RuntimeException("cardnumber wrong format");
        }
        this.cardNumber = cardNumber;
    }

    public void setCensoredCardNumber(String censoredCardNumber) {
        if (censoredCardNumber == null || censoredCardNumber.isEmpty()) {
            throw new RuntimeException("cardnumber required");
        }

        if (!censoredCardNumber.matches("[*]{12}[0-9]{4}")) {
            throw new RuntimeException("censoredcardnumber wrong format");
        }
        this.censoredCardNumber = censoredCardNumber;
    }
    @DateTimeFormat(pattern = "MM-yyyy")
    public void setExpiryDate(Date expiryDate) {
        if (expiryDate == null) {
            throw new RuntimeException("expirydate required");
        }
        this.expiryDate = expiryDate;
    }
}
