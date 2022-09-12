package ru.netology.ru;

import com.codeborne.selenide.Selenide;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CardTest {

    @BeforeEach
     void setUp(){

            Selenide.open("http://localhost:9999");
        }

@Test
    void shouldTransferFromFirstCardToSecond(){
    var amountTransfer = 10000;
    var requiredCard = 2;
    DataHelper.Card cardFirstBeforeTransfer = DataHelper.getCard(1);
    DataHelper.Card cardSecondBeforeTransfer = DataHelper.getCard(2);
    DashboardPage.transferBetweenCards(requiredCard);
    TransferCard.transferMoney(amountTransfer, cardFirstBeforeTransfer.getNumber());
    DataHelper.Card cardFirstAfterTransfer = DataHelper.getCard(1);
    DataHelper.Card cardSecondAfterTransfer = DataHelper.getCard(2);

    assertEquals(cardFirstBeforeTransfer.getBalance() - amountTransfer, cardFirstAfterTransfer.getBalance());
    assertEquals(cardSecondBeforeTransfer.getBalance() + amountTransfer, cardSecondAfterTransfer.getBalance());
    }

    @Test
    void shouldTransferFromSecondCardToFirst(){
        var amountTransfer = 5500;
        var requiredCard = 1;
        DataHelper.Card cardFirstBeforeTransfer = DataHelper.getCard(1);
        DataHelper.Card cardSecondBeforeTransfer = DataHelper.getCard(2);
        DashboardPage.transferBetweenCards(requiredCard);
        TransferCard.transferMoney(amountTransfer, cardFirstBeforeTransfer.getNumber());
        DataHelper.Card cardFirstAfterTransfer = DataHelper.getCard(1);
        DataHelper.Card cardSecondAfterTransfer = DataHelper.getCard(2);

        assertEquals(cardFirstBeforeTransfer.getBalance() - amountTransfer, cardFirstAfterTransfer.getBalance());
        assertEquals(cardSecondBeforeTransfer.getBalance() + amountTransfer, cardSecondAfterTransfer.getBalance());
    }



}
