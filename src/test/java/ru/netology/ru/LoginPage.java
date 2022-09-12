package ru.netology.ru;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
        public LoginPage() {}

        private SelenideElement loginField = $("[data-test-id='login']");
        private SelenideElement passwordField = $("[data-test-id='password']");
        private SelenideElement loginButton = $("[data-test-id='action-login']");


        public VerificationPage validLogin(DataHelper.AuthInfo info) {
            loginField.setValue(info.getLogin());
            passwordField.setValue(info.getPassword());
            loginButton.click();
            return new VerificationPage();
        }
    }

