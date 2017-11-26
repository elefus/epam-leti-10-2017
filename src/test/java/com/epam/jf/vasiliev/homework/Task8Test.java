package com.epam.jf.vasiliev.homework;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Task8Test {

    @Test
    void testOnVoidString() {
        assertFalse(Task8.isPalindromeNumb(""));
    }

    @Test
    void testOnOneBigLetter() {
        assertFalse(Task8.isPalindromeNumb("A"));
    }

    @Test
    void testOnOneSmallLetter() {
        assertFalse(Task8.isPalindromeNumb("z"));
    }

    @Test
    void testOnOneDigit() {
        assertTrue(Task8.isPalindromeNumb("9"));
    }

    @Test
    void testOnStringWithDigitsAndLetters() {
        assertFalse(Task8.isPalindromeNumb("asdfDSf123fsdaf7"));
    }

    @Test
    void testOnPalindromeNumberWithEvenLength() {
        assertTrue(Task8.isPalindromeNumb("123321"));
    }

    @Test
    void testOnPalindromeNumberWithNotEvenLength() {
        assertTrue(Task8.isPalindromeNumb("4561654"));
    }

    @Test
    void testOnPalindromeString() {
        assertFalse(Task8.isPalindromeNumb("AhghA"));
    }

    @Test
    void testOnMaxLong() {
        assertFalse(Task8.isPalindromeNumb(String.valueOf(Long.MAX_VALUE)));
    }

    @Test
    void testOnDouble() {
        assertFalse(Task8.isPalindromeNumb("11.11"));
    }

    @Test
    void testNotLetterNotNumberChars() {
        assertFalse(Task8.isPalindromeNumb("[^^]"));
    }

    @Test
    void testOnBigPalindrome() {
        assertTrue(Task8.isPalindromeNumb("1111111111111111111777777790977777771111111111111111111"));
    }

    @Test
    void testWithoutPalindrome() {
        String[] toCheck = {
                "1123456",
                "lol",
                "not a palindrome",
                "347824a",
                "123h321"
        };

        assertEquals("",Task8.findPalindromes(toCheck));
    }

    @Test
    void testOnOnePalindrome() {
        String[] toCheck = {
                "1123456",
                "lol",
                "not a palindrome",
                "347824a",
                "1239321"
        };

        assertEquals("1239321", Task8.findPalindromes(toCheck));
    }

    @Test
    void testOnSeveralPalindromes() {
        String[] toCheck =  {
                "111",
                "5",
                "999"
        };

        assertEquals("999", Task8.findPalindromes(toCheck));
    }
}
