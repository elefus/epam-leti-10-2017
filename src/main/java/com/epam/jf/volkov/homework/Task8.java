package com.epam.jf.volkov.homework;

/**
 * На вход программе подается несколько строк (через параметры командной строки args).
 * Каждая строка представляет собой одно слово.
 *
 * Помимо обычных слов, во входной последовательности могут встречаться целые числа.
 * Среди них необходимо найти число-палиндром (одинаково читающееся в обоих направлениях).
 * Если таких чисел больше одного, найти второе из них.
 *
 * Одна цифра является палиндромом.
 * Ограничения на размер числа нет.
 */
public class Task8 {

  /**
  * @param args анализируемые строки.
  *
  */
  public static void main(String[] args) {
    if (args.length > 0) {
      String palindromeNumber = getNumberPalindrome(args, 2);
      System.out.println(palindromeNumber);
    } else {
      System.out.println("No args detected");
    }
  }

  public static String getNumberPalindrome(String[] args, int count) {
    int counter = 0;
    for (int i = 0; i < args.length; i++) {
      if (isNumber(args[i]) && isPalindrome(args[i])) {
        counter++;
      }
      if (counter == count) {
        return args[i];
      }
    }
    return getNumberPalindrome(args, count - 1);
  }

  private static boolean isNumber(String word) {
    try {
      Integer.parseInt(word);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  private static boolean isPalindrome(String word) {
    for (int i = 0; i < (word.length() / 2 + 1); i++) {
      if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
        return false;
      }
    }
    return true;
  }
}
