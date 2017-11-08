package com.epam.jf.volkov.homework;

/**
 * На вход программе подается несколько строк (через параметры командной строки args).
 * Требуется упорядочить и вывести строки в порядке возрастания значений их длины.
 * В случае, если длины строк совпадают - упорядочить их в лексикографическом порядке.
 */
public class Task6 {

  /**
  * @param args анализируемые строки.
  */
  public static void main(String[] args) {
    if (args.length > 0) {
      sort(args);
      System.out.println("Sorted words:");
      for (int index = 0; index < args.length; index++) {
        System.out.println(index + 1 + ".\t" + args[index]);
      }
    } else {
      System.out.println("No args detected.");
    }
  }

  private static void sort(String[] array) {
    /**
     * @param array[] - ссылка на сортируемый массив
     * Было лень копипастить что-то более быстрее чем O(N!)
     */
    for (int word = 0; word < array.length; word++) {
      for (int anotherWord = 0; anotherWord < array.length; anotherWord++) {
        if (compare(array[word], array[anotherWord])) {
          swap(array, word, anotherWord);
        }
      }
    }
  }

  private static boolean compare(String compared, String another) {
    /**
    * @param compared первая сравниваемая строка
    * @param another вторая сравниваемая срока
    * @return true если строки нужно поменять местами, иначе false
    */
    return ((compared.length() < another.length())
          || compareLexic(compared,another));
  }

  private static boolean compareLexic(String compared, String another) {
    /**
    * @param compared первая сравниваемая строка
    * @param another вторая сравниваемая срока
    * @return true если строки равны и поданы не в лексикографическом порядке, иначе false
    */
    if (compared.length() == another.length()) {
      for (int currentCharacter = 0; currentCharacter < compared.length(); currentCharacter++) {
        if (((int) compared.charAt(currentCharacter)) - ((int) another.charAt(currentCharacter)) < 0) {
          return true;
        } else if (((int) compared.charAt(currentCharacter)) - ((int) another.charAt(currentCharacter)) > 0) {
          return false;
        }
      }
    }
    return false;
  }

  private static void swap(String[] array, int firstIndex, int secondIndex) {
    String temp = array[firstIndex];
    array[firstIndex] = array[secondIndex];
    array[secondIndex] = temp;
    /**
     * @param array[] Ссылка на модифицируемый массив строк
     * @param firstIndex Индекс первого заменяемого элемента
     * @param secondIndex Индекс второго заменяемого элемента
     */
  }
}
