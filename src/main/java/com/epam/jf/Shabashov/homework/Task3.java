package com.epam.jf.Shabashov.homework;

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
        int value = Integer.parseInt(args[0]);
        System.out.println("Traffic light by if " + getColorByIf(value));
        System.out.println("Traffic light by switch " + getColorBySwitch(value));
    }

    public static String getColorByIf(int n) {
        if (n <= 3) {
            return "Green";
        }
        if (n <= 5) {
            return "Yellow";
        }
        if (n<=9){
            return "red";
        }
        return null;
    }

    public static String getColorBySwitch(int n) {
        switch (n) {
            case 0:
            case 1:
            case 2:
            case 3:
                return "Green";
            case 4:
            case 5:
                return "Yellow";
            case 6:
            case 7:
            case 8:
            case 9:
                return "Red";
            default:
                return null;

        }
    }

}
