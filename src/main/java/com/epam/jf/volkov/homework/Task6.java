package com.epam.jf.volkov.homework;

/**
 * На вход программе подается несколько строк (через параметры командной строки args).
 * Требуется упорядочить и вывести строки в порядке возрастания значений их длины.
 * В случае, если длины строк совпадают - упорядочить их в лексикографическом порядке.
 * @author Anton Volkov aka thewalkingwind
 * @version 1.0.1
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

  /**
   * Сортирует переданный массив, сложность O(N*N)
   * @param array - ссылка на сортируемый массив
   */
  private static void sort(String[] array) {
    for (int word = 0; word < array.length; word++) {
      for (int anotherWord = 0; anotherWord < array.length; anotherWord++) {
        if (isUncompared(array[word], array[anotherWord])) {
          swap(array, word, anotherWord);
        }
      }
    }
  }

  /**
   * Сравнивает строки по длине и содержимому
   * @param compared Первая сравниваемая строка
   * @param another Вторая сравниваемая срока
   * @return Строки нужно поменять местами для сортировки
   */
  private static boolean isUncompared(String compared, String another) {
    return ((compared.length() < another.length())
          || isUnomparedLexic(compared,another));
  }

  /**
   *
   * @param compared Первая сравниваемая строка
   * @param another Вторая сравниваемая срока
   * @return Cтроки равны и поданы не в лексикографическом порядке
   */
  private static boolean isUnomparedLexic(String compared, String another) {
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

  /**
   * Меняет элементы местами
   * @param array Ссылка на модифицируемый массив строк
   * @param firstIndex Индекс первого заменяемого элемента
   * @param secondIndex Индекс второго заменяемого элемента
   */
  private static void swap(String[] array, int firstIndex, int secondIndex) {
    String temp = array[firstIndex];
    array[firstIndex] = array[secondIndex];
    array[secondIndex] = temp;
  }
}
