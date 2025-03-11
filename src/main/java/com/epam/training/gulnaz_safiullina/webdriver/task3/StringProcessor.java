package com.epam.training.gulnaz_safiullina.webdriver.task3;

import java.util.HashSet;
import java.util.Set;

public class StringProcessor {
    /**
     * Finds the maximum number of consecutive unequal characters in the given string.
     * The input string must not contain spaces, and the comparison is case-sensitive.
     * If the input is null, empty or blank, the method returns 0.
     *
     * @param input the input string without spaces
     * @return the length of the longest substring of consecutive unique characters
     */
    public static int maxConsecutiveUniqueCharacters(String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }

        Set<Character> seen = new HashSet<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < input.length(); right++) {
            while (seen.contains(input.charAt(right))) {
                seen.remove(input.charAt(left));
                left++;
            }
            seen.add(input.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    /**
     * Determines the maximum number of consecutive identical Latin letters in the given string.
     * The method is case-sensitive and only considers letters from the Latin alphabet (A-Z, a-z).
     * If the input is null, empty, or contains non-digit characters, the method will return 0 or
     * throw an exception.
     *
     * @param input the input string
     * @return the length of the longest substring of consecutive identical Latin letters
     * @throws IllegalArgumentException if the input contains non-digit characters
     */
    public static int maxConsecutiveIdenticalLetters(String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }

        if (!input.matches("[a-zA-Z]+")) { // Check if input contains only Latin letters
            throw new IllegalArgumentException("Input must contain only Latin characters.");
        }

        return maxConsecutiveIdenticalCharacters(input);
    }


    /**
     * Determines the maximum number of consecutive identical digits in the given string.
     * The input string must contain only numeric digits (0-9). If the input is null, empty,
     * or contains non-digit characters, the method will return 0 or throw an exception.
     *
     * @param input the input string containing digits
     * @return the length of the longest sequence of consecutive identical digits
     * @throws IllegalArgumentException if the input contains non-digit characters
     */
    public static int maxConsecutiveIdenticalDigits(String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }

        if (!input.matches("\\d+")) { // Check if input contains only digits
            throw new IllegalArgumentException("Input must contain only digits.");
        }

        return maxConsecutiveIdenticalCharacters(input);
    }

    private static int maxConsecutiveIdenticalCharacters(String input) {
        int maxCount = 1;
        int currentCount = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                currentCount++;
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                }
            } else {
                currentCount = 1;
            }
        }

        return maxCount;
    }

}