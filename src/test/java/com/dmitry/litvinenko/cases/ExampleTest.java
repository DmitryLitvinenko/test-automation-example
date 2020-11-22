package com.dmitry.litvinenko.cases;

import com.dmitry.litvinenko.util.TestResultLoggerExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static java.lang.Integer.divideUnsigned;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(TestResultLoggerExtension.class)
public class ExampleTest {

    @Test
    @DisplayName("Positive test")
    public void positiveTest() {
        assertTrue(true);
    }

    @Test
    @DisplayName("Negative test")
    public void negativeTest() {
        assertTrue(false);
    }

    @Test
    @DisplayName("Parallel test")
    public void parallelTest() {
        final String name = "Dimitry";

        assertAll("name test",
                () -> {
                    assertNotNull(name);
                    assertAll("check name",
                            () -> assertTrue(name.startsWith("D")),
                            () -> assertTrue(name.endsWith("y"))
                    );
                }
        );
    }

    @ParameterizedTest(name = "My birth year is not {0}")
    @ValueSource(ints = {2016, 2020, 2048})
    @DisplayName("Parameterized test")
    public void parameterizedTest(int year) {
        assertTrue(year != 1992);
    }

    @Test
    @Tag("slow")
    @DisplayName("Tag test, slow")
    public void testAddMaxInteger() {
        assertEquals(2147483646, Integer.sum(2147183646, 300000));
    }

    @Test
    @Tag("fast")
    @DisplayName("Tag test, fast")
    public void testDivide() {
        assertThrows(ArithmeticException.class, () -> divideUnsigned(42, 0));
    }
}
