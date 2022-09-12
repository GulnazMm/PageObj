package ru.netology.ru;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TransferCard {
    public TransferCard() {
        SelenideElement title = $(byText("Пополнение карты"));
        title.shouldBe(visible);
    }

    private static final SelenideElement transferAmount = $("[data-test-id='amount'] span");
    private static final SelenideElement numberCardField = $("[data-test-id='from'] span");
    private static final SelenideElement buttonTransfer = $("[data-test-id='action-transfer']");

    public static void transferMoney(int amount, String number) {

        transferAmount.setValue(String.valueOf(amount));
        numberCardField.setValue(number);
        buttonTransfer.click();
    }
}



