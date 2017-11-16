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
 * @author Anton Volkov aka thewalkingwind
 * @version 1.0.5
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

  /**
   *
   * @param args Исследуемый массив строк
   * @param count Последовательный номер возвращаемого палиндрома
   * @return Строка с числом-палиндромом, или сообщение "No palindromes detected"
   */
  public static String getNumberPalindrome(String[] args, int count) {
    int counter = 0;
    for (String word: args) {
      if (isNumber(absword(word)) && isPalindrome(absword(word))) {
        counter++;
      }
      if (counter == count) {
        return word;
      }
    }
    if (counter == 0) {
      return "No palindromes detected";
    }
    return getNumberPalindrome(args, count - 1);
  }

  /**
   *
   * @param word Исследуемая строка
   * @return Возвращает строку без минуса в качестве первого знака, если ее длина больше 1 символа
   */
  private static String absword(String word) {
    if (word.length() > 1 && word.charAt(0) == '-') {
      return word.substring(1);
    } else {
      return word;
    }
  }

  /**
   *
   * @Костыль с исключениями
   * @param word Исследуемая строка
   * @return Содержит ли строка число
   */
  private static boolean isNumber(String word) {
    try {
      Integer.parseInt(word);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  /**
   *
   * @param word Исследуемая строка
   * @return Является ли строка палиндромом
   */
  private static boolean isPalindrome(String word) {
    for (int i = 0; i < (word.length() / 2 + 1); i++) {
      if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
        return false;
      }
    }
    return true;
  }
}
