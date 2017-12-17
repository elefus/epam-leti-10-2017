package com.epam.jf.kuchinskii.homework;
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
public class Task5 {

    public static void main(String[] args) {
        int count = 0;
        for (String arg : args) {
            if (isVowelEqualsConsonant(arg)) {
                count++;
            }
        }
        System.out.println("Количество: " + count);
    }

    static boolean isVowelEqualsConsonant(String arg) {
        int countVowel = 0;
        int countConsonant = 0;
        final long maskVowels     = 0b0000100010001010001000001000100010100010000010000010L;
        final long maskConsonants = 0b1111011101110101110111110111011101011101111101111101L;

        for (int i = 0; i < arg.length(); i++) {
            long charBit = setBit(arg.charAt(i));
            if ((charBit & maskVowels) > 0) {
                countVowel++;
            } else if ((charBit & maskConsonants) > 0) {
                countConsonant++;
            }
        }
        return countVowel == countConsonant;
    }

    /**
     * Returns {@code long} mask unique for each case sensitive English character.
     * @param code Code of a character to create a mask for.
     * @return {@code long} bit mask with single '1' shifted left 1-52 times.
     * If input is not English character returns -1.
     */
    private static long setBit(int code) {
        long res = 0;
        int position;
        if ((122 >= code) & (code >= 97)) {
            position = code % 26;
        } else if ((90 >= code) & (code >= 65)) {
            position = (code % 26) + 26;
        } else return -1;
        return res | 1L << position;
    }
}
