package com.epam.jf.volkov.homework;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Task8Test {

  @Test
  void getNumberPalindrome() {
    String[] testArgs1 = {"234567890", "-2", "aabb", "e", "22.01", "qqee"};
    assertEquals("-2", Task8.getNumberPalindrome(testArgs1, 2));
    String[] testArgs2 = {"aaa", "bbb", "32", "434", "-90", "11", "11311"};
    assertEquals("11", Task8.getNumberPalindrome(testArgs2, 2));
    assertEquals("11311", Task8.getNumberPalindrome(testArgs2, 3));
    assertEquals("434", Task8.getNumberPalindrome(testArgs2, 1));
    String[] testArgs3 = {"234ad7890", "-32", "aabb", "1e1", "22.00", "10.0"};
    assertEquals("No palindromes detected", Task8.getNumberPalindrome(testArgs3, 2));
  }

}