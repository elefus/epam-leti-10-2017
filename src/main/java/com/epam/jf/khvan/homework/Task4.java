package com.epam.jf.khvan.homework;

/**
 * На вход программе подается несколько строк (через параметры командной строки args).
 * Каждая строка представляет собой одно слово, состоящие из символов английского алфавита.
 * Необходимо найти слово, в котором число различных символов минимально.
 *
 * Символы верхнего и нижнего регистра считать различными.
 * Если таких слов несколько, найти первое из них.
 *
 * В результате выполнения в выходной поток должно быть выведено слово, содержащее наименьшее число различных символов.
 * Наиболее эффективное с точки зрения скорости и потребляемой памяти решение - реализация с использованием битовых операций.
 * Желающие могут попробовать придумать, как их можно применить в этой задаче.
 */
import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class Task4 {
    public static void main (String [] args) {
        int number = 0;
        int max = 0;
        int k = 0;
        int difLetter = 0;
        ArrayList<Integer> arrayNumberLetter = new ArrayList<>();
        int min = 0;
        for ( int r = 0; r < args.length; r++) {
            char[] letters = args[r].toCharArray();
            for ( int i = 0; i < letters.length-1; i++){ // текущую букву с остальными
                for( int j = i + 1; j < letters.length; j++){
                    if ( letters[i] == 0){continue;}
                    if( letters[i] == letters[j]){
                        letters[j] = 0;
                        number++; }
                    if ( j == letters.length - 1 & number == 0){
                        difLetter++; }
                    if ( j == letters.length - 1 & number != 0){
                        difLetter++; }
                }
            }
            if(letters[letters.length - 1]!=0){ difLetter++;}
            arrayNumberLetter.add(difLetter);
            min=arrayNumberLetter.get(0);
            if ( r > 0 & r <= 5){
                if ( min > arrayNumberLetter.get(r)){
                    min = arrayNumberLetter.get(r);
                    k = r;
                }
            }
            difLetter = 0;
        }
        System.out.println(args[k]);
    }
}



