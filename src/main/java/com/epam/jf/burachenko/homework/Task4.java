package com.epam.jf.burachenko.homework;

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
public class Task4 {

    /**
     * @param args анализируемые строки.
     */
    public static void main(String[] args) {
        int count;
        int min = args[0].length();
        int i_min = 0;
        for (int k = 0; k < args.length; k++) { // count - счётчик различных букв, нужен только первого цикла
            count = 0;
            String alph = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            for(int i = 0; i < args[k].length(); i++)
                for(int j = 0; j < alph.length(); j++)
                    if((args[k].charAt(i)^alph.charAt(j)) == 0) {
                        count++;
                        alph = alph.replace(alph.charAt(j), '\0');
                        break;
                    }

            if(count < min) {
                min = count;
                i_min = k;
            }
        }

        System.out.println("Слово с наименьшим количеством различных символов: " + args[i_min]);
    }
}
