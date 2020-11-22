package com.dmitry.litvinenko.google.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.dmitry.litvinenko.configuration.PropertiesConfiguration.getGoogleHomeUrl;
import static com.dmitry.litvinenko.util.ElementWaiter.isElementVisible;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePage extends GenericPage {
    private final SelenideElement searchFiled = $(".q");
    private final SelenideElement logo = $("#hplogo");
    private final SelenideElement googleSearchBtn = $(".btnK");
    private final SelenideElement imFeelingLuckyBtn = $(".btnI");

    public void get() {
        open(getGoogleHomeUrl());
    }

    public void checkElements() {
        assertAll("Check home page main elements visibility",
                () -> assertTrue(isElementVisible(searchFiled), "Search field not visible"),
                () -> assertTrue(isElementVisible(logo), "Logo not visible"),
                () -> assertTrue(isElementVisible(googleSearchBtn), "Search button field not visible"),
                () -> assertTrue(isElementVisible(imFeelingLuckyBtn), "Feeling lucky button field not visible")
        );
    }

    public void search(final String text) {
        searchFiled.shouldBe(Condition.visible).val(text);
    }
}
