package com.dmitry.litvinenko.util;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;

import java.util.Optional;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;
import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;

public class ElementWaiter {

    private ElementWaiter() {
        throw new IllegalStateException("Util class");
    }

    private static final Integer DEFAULT_WAIT_TIME_MILLIS = 500;
    private static final Integer DEFAULT_FLUENT_WAIT_TIME_MILLIS = 7000;

    public static boolean isElementVisible(final SelenideElement e, final Integer timeoutMillis) {
        try {
            e.waitUntil(visible, timeoutMillis);
            return true;
        } catch (ElementNotFound ignore) {
            return false;
        }
    }

    public static boolean isElementVisible(final SelenideElement e) {
        return isElementVisible(e, DEFAULT_FLUENT_WAIT_TIME_MILLIS);
    }

    public static Optional<SelenideElement> waitElement(final SelenideElement e,
                                                        final Condition visibility,
                                                        final long fluentWaitInMillis,
                                                        final long afterSleepInMillis) {
        try {
            return ofNullable(e.waitUntil(visibility, fluentWaitInMillis))
                    .map(se -> {
                        sleep(afterSleepInMillis);
                        return e;
                    });
        } catch (ElementNotFound ignore) {
            return empty();
        }
    }

    public static Optional<SelenideElement> waitElement(final SelenideElement e,
                                                        final Condition visibility,
                                                        final long fluentWaitInMillis) {
        return waitElement(e, visibility, fluentWaitInMillis, DEFAULT_WAIT_TIME_MILLIS);
    }

    public static Optional<SelenideElement> waitElement(final SelenideElement e,
                                                        final Condition visibility) {
        return waitElement(e, visibility, DEFAULT_FLUENT_WAIT_TIME_MILLIS, DEFAULT_WAIT_TIME_MILLIS);
    }
}
