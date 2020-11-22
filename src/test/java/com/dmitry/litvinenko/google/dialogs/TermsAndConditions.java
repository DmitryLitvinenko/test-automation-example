package com.dmitry.litvinenko.google.dialogs;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TermsAndConditions {
    private final SelenideElement accept = $("#introAgreeButton");

    public void acceptTerms() {
        accept.shouldBe(visible).click();
    }
}
