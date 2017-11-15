package com.epam.jf.plokhoi.homework;

/**
 * Необходимо смоделировать работу светофора.
 * С 0 по 3 секунду светофор горит зеленым
 * С 4 по 5 секунду светофор горит желтым
 * С 6 по 9 секунду светофор горит красным
 * На вход программе подается целое положительное число в виде строки (через параметры командной строки args), представляющее секунды с момента начала работы светофора.
 * Необходимо определить, каким цветом будет гореть светофор спустя указанное количество секунд и вывести в консоль ответ.
 * Задачу можно решить используя операторы условного ветвления if и switch, следует реализовать оба варианта.
 */
public class Task3 {

    /**
     * @param args [0] - количество секунд, прошедших с момента начала работы светофора.
     */
    public static void main(String[] args) {
        char lastDigit = args[0].charAt(args[0].length() - 1);
        Color calculatedColorUsingIf = calculateColorUsingIf(lastDigit);
        Color calculatedColorUsingSwitch = calculateColorUsingSwitch(lastDigit);
        if (calculatedColorUsingIf != calculatedColorUsingSwitch) {
            throw new IllegalStateException();
        }
        System.out.println(calculatedColorUsingIf);
    }

    private static Color calculateColorUsingIf(char second) {
        if (second < '4') {
            return Color.GREEN;
        } else if (second < '6') {
            return Color.YELLOW;
        } else {
            return Color.RED;
        }
    }

    private static Color calculateColorUsingSwitch(char second) {
        switch (second) {
            case '0':
            case '1':
            case '2':
            case '3':
                return Color.GREEN;

            case '4':
            case '5':
                return Color.YELLOW;

            default:
                return Color.RED;
        }
    }

    private enum Color {
        GREEN,
        YELLOW,
        RED
    }
}
