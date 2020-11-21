package com.dmitry.litvinenko.cases;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class  FirstTest {

    @Test
    public void openGoogleTest() {
        open("https://google.com");
    }
}
