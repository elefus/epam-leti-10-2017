package com.epam.jf.dementyev.homework;

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
        try {
            int time = Integer.valueOf(args[0]) % 12;
            String color1 = SolveWithIf(time);
            String color2 = SolveWithSwitch(time);
            System.out.println(color1);
            System.out.println(color2);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Недопустимый входной аргумент");
        }
    }

    private static String SolveWithIf(int time) {
        if (time >= 0 && time <= 3)
            return "Зелёный";
        else if (time == 4 || time == 5 || time == 10 || time == 11)
            return "Жёлтый";
        else if (time >= 6 && time <= 9)
            return "Красный";
        return null;
    }

    private static String SolveWithSwitch(int time) {
        switch (time) {
            case 0:
            case 1:
            case 2:
            case 3:
                return "Зелёный";
            case 4:
            case 5:
            case 10:
            case 11:
                return "Жёлтый";
            case 6:
            case 7:
            case 8:
            case 9:
                return "Красный";
            default:
                return null;
        }
    }
}