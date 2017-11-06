package main.java.com.epam.jf.yessenbayev.homework;
import java.util.Arrays;
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
public class Task_4 {

    /**
     * @param args анализируемые строки.
     */
    public static void main(String[] args) {
        if(args.length > 0){
            int minUniqueSymbols = Integer.MAX_VALUE;
            int answer = 0;
            for(int i = 0; i < args.length; i++){
                System.out.println(args[i] + " : " + uniqueSymbolCount(args[i]));
                int temp = uniqueSymbolCount(args[i]);
                if (temp < minUniqueSymbols){
                    minUniqueSymbols = temp;
                    answer = i;
                }
            }
            System.out.println(args[answer]);
        } else{
            System.out.println("Error");
        }
    }

    public static int uniqueSymbolCount(String word){
        int count = 1;
        char[] temp = word.toCharArray();
        Arrays.sort(temp);
        for(int i = 0; i < temp.length - 1; i++){
            if (temp[i] != temp[i+1])
                count++;
        }
        return count;
    }
}
