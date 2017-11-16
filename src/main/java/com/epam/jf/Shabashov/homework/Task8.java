package com.epam.jf.Shabashov.homework;

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
     */
    public static void main(String[] args) {
        int answer = 0;
        int numberFind = 2;
        for (int i = 0; i < args.length; i++) {
            char[] chars = args[i].toCharArray();
            if (isNumber(chars)){
                if (isPolindrom(chars)){
                    answer = i;
                    numberFind--;
                    if(numberFind==0){
                        break;
                    }
                }
            }
        }
        System.out.println(args[answer]);

    }

    public static boolean isPolindrom(char[] line){

        for (int i = 0; i < line.length/2; i++) {
            if (line[i]!=line[line.length-i - 1]){
                return false;
            }
        }
        return true;
    }

    public static boolean isNumber(char[] line){
        for (char letter : line) {
            if (!(letter>='0' && letter<='9')){
                return false;
            }
        }
        return true;
    }
}
