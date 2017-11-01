package com.epam.jf.savchenkov.homework;

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

        int seconds = Integer.valueOf(args[0]) % 10;
        System.out.println("Используя if - " + ifMethod(seconds));
        System.out.println("Используя switch - " + switchMethod(seconds));
    }

    public static String ifMethod(int sec) {
        if (0 <= sec && sec <= 3) {
            return "Зеленый";
        }
        else if (4 <= sec && sec <= 5) {
            return "Желтый";
        }
        else return "Красный";
    }

    public static String switchMethod(int sec) {
        switch (sec) {
            case 0:
            case 1:
            case 2:
            case 3:
                return "Зеленый";
            case 4:
            case 5:
                return "Желтый";
            case 6:
            case 7:
            case 8:
            case 9:
                return "Красный";
            default:
                return "Плохой аргумент";
        }
    }
}
