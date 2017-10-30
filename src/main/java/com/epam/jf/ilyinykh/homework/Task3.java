package com.epam.jf.ilyinykh.homework;

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
        int number = Integer.valueOf(args[0]) % 10;
        ifMethod(number);
        switchMethod(number);
    }

    private static void switchMethod(int number) {
        switch (number) {
            case 0:
            case 2:
            case 3:
                System.out.println("Зеленый");
                break;
            case 4:
            case 5:
                System.out.println("Желтый");
                break;
            case 6:
            case 7:
            case 8:
            case 9:
                System.out.println("Красный");
        }
    }

    private static void ifMethod(int number) {
        if (number <= 3) {
            System.out.println("Заленый");
        } else if (number <= 5) {
            System.out.println("Желтый");
        } else if (number <= 9) {
            System.out.println("Красный");
        }
    }
}
