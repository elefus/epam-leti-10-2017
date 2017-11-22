package com.epam.jf.guba.homework;

/**
 * На вход программе подается несколько строк (через параметры командной строки args).
 * Каждая строка представляет собой одно слово.
 * В результате выполнения в выходной поток должно быть выведено количество слов,
 * состоящих только из символов латинского алфавита и содержащих равное количество гласных и согласных букв.
 * <p>
 * Количество различных вхождений одной буквы в слове учитывается.
 * <p>
 * Входные данные:
 * args = ["Язык", "программирования", "Java", "is", "widespread"]
 * <p>
 * Выходные данные:
 * 2
 */
public class Task5 {

    /**
     * @param args анализируемые строки.
     */
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Слишком мало аргументов");
            return;
        }
        int result = 0;

        for (String string : args) {
            if(checkLanguage(string) && checkLetters(string)){
                result++;
            }
        }

        System.out.println("Количество строк удовлетворяющих критерию " + result);
    }

    private static boolean checkLanguage(String string) {
        for(char letter : string.toLowerCase().toCharArray()){
            if(letter < 'a' || letter > 'z'){
                return false;
            }
        }
        return true;
    }

    private static boolean checkLetters(String string) {
        String temp = string.toLowerCase();
        int fullLength = temp.length();
        temp = temp.replaceAll("a|e|i|o|u|", "");
        int withoutVowels = temp.length();
        return withoutVowels == fullLength / 2;
    }
}
