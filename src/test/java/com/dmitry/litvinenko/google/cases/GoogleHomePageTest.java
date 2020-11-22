package com.dmitry.litvinenko.google.cases;

import com.dmitry.litvinenko.google.dialogs.TermsAndConditions;
import com.dmitry.litvinenko.google.pages.HomePage;
import org.junit.jupiter.api.Test;

public class GoogleHomePageTest {
    private HomePage homePage = new HomePage();
    private TermsAndConditions termsAndConditions = new TermsAndConditions();

    @Test
    public void checkPage() {
        homePage.get();
        termsAndConditions.acceptTerms();
        homePage.checkElements();
    }
}
