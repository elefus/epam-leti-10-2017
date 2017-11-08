package com.epam.jf.polovinkin.homework;

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
        ifSolution(args);
        switchSolution(args);
    }

    public static void ifSolution(String[] args) {
        int val = Integer.valueOf(args[0]) % 10;
        if (val < 4) {
            System.out.println("ЗЕЛЕНЫЙ");
        } else if (val < 6) {
            System.out.println("ЖЕЛТЫЙ");
        } else if (val < 10) {
            System.out.println("КРАСНЫЙ");
        }
    }

    public static void switchSolution(String[] args) {
        int val = Integer.valueOf(args[0]) % 10;
        switch (val) {
            case 0:
            case 1:
            case 2:
            case 3:
                System.out.println("ЗЕЛЕНЫЙ");
                break;
            case 4:
            case 5:
                System.out.println("ЖЕЛТЫЙ");
                break;
            case 6:
            case 7:
            case 8:
            case 9:
                System.out.println("КРАСНЫЙ");
                break;
        }
    }
}