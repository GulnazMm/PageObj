package ru.netology.ru;

import lombok.Value;

import java.util.ArrayList;
import java.util.List;

public class DataHelper {
    private DataHelper(){}


@Value
    public static class AuthInfo{
        public String login;
        public String password;

    }
    public static AuthInfo getAuthInfo(){return new AuthInfo("vasya", "qwerty123");}

    @Value
    public static class VerificationCode{
        public String code;
    }

    public static VerificationCode getVerificationCode(AuthInfo authInfo) {return new VerificationCode("12345");}

    @Value
    public static class Card{
         String number;
         int balance;
         String id;
    }
    public static Card getCard(int orderNumber) {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("5559 0000 0000 0001", DashboardPage.getCardId ("1"), DashboardPage.getCardBalance(1)));
        cards.add(new Card("5559 0000 0000 0002", DashboardPage.getCardId("2"), DashboardPage.getCardBalance(2)));
        return cards.get(orderNumber- 1);

    }


    }

