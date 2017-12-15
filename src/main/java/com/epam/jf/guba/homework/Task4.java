package main.java.com.epam.jf.guba.homework;

/**
 * На вход программе подается несколько строк (через параметры командной строки args).
 * Каждая строка представляет собой одно слово, состоящие из символов английского алфавита.
 * Необходимо найти слово, в котором число различных символов минимально.
 * <p>
 * Символы верхнего и нижнего регистра считать различными.
 * Если таких слов несколько, найти первое из них.
 * <p>
 * В результате выполнения в выходной поток должно быть выведено слово, содержащее наименьшее число различных символов.
 * Наиболее эффективное с точки зрения скорости и потребляемой памяти решение - реализация с использованием битовых операций.
 * Желающие могут попробовать придумать, как их можно применить в этой задаче.
 */
public class Task4 {

    /**
     * @param args анализируемые строки.
     */
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Недостаточно аргументов");
            return;
        }

        String result = null;
        int minDiff = Integer.MAX_VALUE;
        StringBuilder temp = new StringBuilder();

        for (String candidat : args) {
            for (Character letter : candidat.toCharArray()) {
                if (!temp.toString().contains(letter.toString())) temp.append(letter);
            }

            int currentWordLength = temp.toString().length();
            if (currentWordLength < minDiff) {
                minDiff = currentWordLength;
                result = candidat;
            }
            temp.delete(0, temp.toString().length());
        }

        if (result != null) {
            System.out.println(result);
        } else {
            System.err.println("Все входные строки - пустые");
            ;
        }


    }
}
