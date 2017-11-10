package main.java.com.epam.jf.yessenbayev.homework;

/**
 * На вход программе подается несколько строк (через параметры командной строки args).
 * Каждая строка представляет собой одно слово.
 * В результате выполнения в выходной поток должно быть выведено количество слов,
 * состоящих только из символов латинского алфавита и содержащих равное количество гласных и согласных букв.
 *
 * Количество различных вхождений одной буквы в слове учитывается.
 *
 * Входные данные:
 * args = ["Язык", "программирования", "Java", "is", "widespread"]
 *
 * Выходные данные:
 * 2
 */
public class Task_5 {

    /**
     * @param args анализируемые строки.
     */
    public static void main(String[] args) {
        int correctWordCounter = 0;
        if (args.length > 0) {
            for (String word: args) {
                if (isWordCorrect(word)) {
                    correctWordCounter++;
                }
            }
            System.out.println(correctWordCounter);
        } else {
            System.out.println("Error");
        }
    }

    /**
     *
     * @param word - слово, которое будет рассматриваться
     * @return true, если слово состоит из букв латинского алфавита и количество согласных букв = количеству гласных
     */
    private static boolean isWordCorrect(String word) {
        String temp = word.toLowerCase();
        int charCounter = 0;
        for (int i = 0; i < temp.length(); i++) {
            if ("bcdfghjklmnpqrstvwxz".indexOf(temp.charAt(i)) != -1) {
                charCounter++;
            } else if ("aeiouy".indexOf(temp.charAt(i)) != -1) {
                charCounter--;
            } else {
                return false;
            }
        }
        if (charCounter == 0) {
            return true;
        }

        return false;
    }
}