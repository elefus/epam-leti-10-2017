package com.epam.jf.kuchinskii.homework;

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

    public static void main(String[] args) {
        try {
            int seconds = Integer.valueOf(args[0]);
            System.out.print("Output using \'Switch\' : ");
            outputSwitch(seconds);
            System.out.print("Output using \'If\' : ");
            outputIf(seconds);
        } catch (NumberFormatException e) {
            System.out.println("Неправильный ввод числа.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("На входе нет аргументов.");
        }
    }

    private static void outputIf(int seconds) {
        seconds = seconds % 10;
        if (seconds < 4) {
            System.out.println("Зелёный");
        } else if (seconds < 6) {
            System.out.println("Жёлтый");
        } else {
            System.out.println("Красный");
        }
    }

    private static void outputSwitch(int seconds) {
        seconds = seconds % 10;
        switch (seconds) {
            case 0:
            case 1:
            case 2:
            case 3:
                System.out.println("Зелёный");
                break;
            case 4:
            case 5:
                System.out.println("Жёлтый");
                break;
            case 6:
            case 7:
            case 8:
            case 9:
                System.out.println("Красный");
                break;
            default:
                System.out.println("Что-то пошло не так :|");
        }
    }
}
