package com.epam.training.gulnaz_safiullina.webdriver.task3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestStringProcessor {

    @ParameterizedTest
    @MethodSource("providerMaxConsecutiveUniqueCharacters")
    void testMaxConsecutiveUniqueCharacters(String input, int expected) {
        int actual = StringProcessor.maxConsecutiveUniqueCharacters(input);
        assertEquals(expected, actual, "Failed for input: " + input);
    }

    private static Stream<Arguments> providerMaxConsecutiveUniqueCharacters() {
        return Stream.of(
                Arguments.of("abcddcba", 4),                      // Multiple consecutive unique letters
                Arguments.of("aaaa", 1),                          // All identical letters
                Arguments.of("a", 1),                             // Single character
                Arguments.of("", 0),                              // Empty string
                Arguments.of(null, 0),                            // Null input
                Arguments.of("   ", 0),                           // Blank input (whitespace only)
                Arguments.of("abcdef", 6),                        // Non-repeating letters
                Arguments.of("abcdefghijklmnopqrstuvwxyz", 26),   // Non-repeating letters long
                Arguments.of("aabbaabb", 2),                      // Mixed consecutive letters
                Arguments.of("ababab", 2),                        // Alternating letters
                Arguments.of("aAaAaA", 2),                        // Case sensitivity (assuming case-sensitive comparison)
                Arguments.of("a!@#b$%^c&*()", 13),                // Non-letter characters
                Arguments.of("a1b2c3d4", 8)                       // Mixed Non-letter and letter characters
        );
    }


    @ParameterizedTest
    @MethodSource("providerMaxConsecutiveIdenticalLetters")
    void testMaxConsecutiveIdenticalLetters_ValidInputs(String input, int expected) {
        int actual = StringProcessor.maxConsecutiveIdenticalLetters(input);
        assertEquals(expected, actual, "Failed for input: " + input);
    }

    // Test invalid inputs (non-Latin letters)
    @ParameterizedTest
    @ValueSource(strings = {"b12a34", "   abc   ", "123!!", "!!!", "a@a!a#"})
    void testMaxConsecutiveIdenticalLetters_InvalidInputs(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            StringProcessor.maxConsecutiveIdenticalLetters(input);
        });
    }

    private static Stream<Arguments> providerMaxConsecutiveIdenticalLetters() {
        return Stream.of(
                Arguments.of("aaabbb", 3),       // Multiple consecutive letters
                Arguments.of("abc", 1),          // No consecutive letters
                Arguments.of("", 0),             // Empty string
                Arguments.of(null, 0),           // Null input
                Arguments.of("   ", 0),          // Blank input (whitespace only)
                Arguments.of("a", 1),            // Single character
                Arguments.of("aaaaa", 5),        // All identical letters
                Arguments.of("ababab", 1),       // Alternating letters
                Arguments.of("aabbaa", 2),       // Mixed consecutive letters
                Arguments.of("abcdef", 1),       // Non-repeating letters
                Arguments.of("AABBBcc", 3),      // Case sensitivity (assuming case-sensitive comparison)
                Arguments.of("aAaA", 1)         // Mixed case, no consecutive identical letters
        );
    }



    @ParameterizedTest
    @MethodSource("provideValidInputs")
    void testMaxConsecutiveIdenticalDigits_ValidInputs(String input, int expected) {
        int actual = StringProcessor.maxConsecutiveIdenticalDigits(input);
        assertEquals(expected, actual, "Failed for input: " + input);
    }

    private static Stream<Arguments> provideValidInputs() {
        return Stream.of(
                Arguments.of("112233", 2),      // Multiple consecutive digits
                Arguments.of("111222333", 3),   // Longer consecutive sequences
                Arguments.of("123456", 1),      // No consecutive digits
                Arguments.of("999999", 6),      // All identical digits
                Arguments.of("1", 1),           // Single digit
                Arguments.of("", 0),            // Empty string
                Arguments.of("    ", 0),        // Blank string
                Arguments.of(null, 0)           // Null value
        );
    }

    // Test invalid inputs (non-digit characters)
    @ParameterizedTest
    @ValueSource(strings = {"12a34", "abc", "123!!", " 123 ", "1.23"})
    void testMaxConsecutiveIdenticalDigits_InvalidInputs(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            StringProcessor.maxConsecutiveIdenticalDigits(input);
        });
    }
}