package ru.netology.ru;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {

        private SelenideElement title = $(byText("Личный кабинет"));
        private SelenideElement title2 = $(byText("Ваши карты"));
        private static ElementsCollection list = $$("// *[@ class = 'list__item']").filter(visible);


        public DashboardPage() {
            title.shouldBe(visible);
            title2.shouldBe(visible);
        }

        public static String  getCardId(int orderNumber) {

            return list.get(orderNumber - 1).attr("data-test-id");
        }

        public static int getCardBalance(int orderNumber) {

            return extractBalance(list.get(orderNumber - 1).text());
        }

        public static int extractBalance(String text) {
            String balansPart = text.split(":")[1];
            return Integer.parseInt(balansPart.substring(0, balansPart.indexOf("р.")).trim());

        }

        public static TransferCard transferBetweenCards(int numberOrderCard) {
            list.get(numberOrderCard - 1).find("button").click();
            return new TransferCard();
        }

        public static String ErrorOnPage() {
            return $(byText("Ошибка")).shouldBe(visible).text();
        }
    }

