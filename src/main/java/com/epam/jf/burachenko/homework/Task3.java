package com.epam.jf.burachenko.homework;

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
    public static void main(String...args) {
        char lastDigit = args[0].charAt(args[0].length()-1);

        System.out.print("Через if:\n\t");
        if (lastDigit <= '3') {
            System.out.println("Светофор горит зелёным");
        }
        else if (lastDigit <= '5') {
            System.out.println("Светофор горит жёлтым");
        }
        else if (lastDigit <= '9') {
            System.out.println("Светофор горит красным");
        }

        System.out.print("Через switch:\n\t");
		switch(lastDigit) {
            case '0':
            case '1':
            case '2':
            case '3':
                System.out.println("Светофор горит зелёным");
                break;
            case '4':
            case '5':
                System.out.println("Светофор горит жёлтым");
                break;
            case '6':
            case '7':
            case '8':
            case '9':
                System.out.println("Светофор горит красным");
                break;
        }
    }
}