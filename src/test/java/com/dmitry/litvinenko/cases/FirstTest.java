package com.dmitry.litvinenko.cases;

import com.dmitry.litvinenko.cases.util.TestResultLoggerExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.open;

@ExtendWith(TestResultLoggerExtension.class)
public class FirstTest {

    @Test
    public void openGoogleTest() {
        open("https://google.com");
    }
}
