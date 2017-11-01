package com.epam.jf.Guyo.homework;

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

    public static int lastDigit(String args){
        int digit = Integer.parseInt(args);
        return (digit%10);
    }

    public static String switchMethod(String args){
        switch (lastDigit(args)){
            case 0 :
            case 1 :
            case 2 :
            case 3 :
                return "Green";
            case 4 :
            case 5 :
                return "Yellow";
            case 6 :
            case 7 :
            case 8 :
            case 9 :
                return "Red";
        }
        return "";
    }

    public static String ifMethod(String args) {
        if ((lastDigit(args) >= 0) && (lastDigit(args) <= 3)) {
            return "Green";
        } else if ((lastDigit(args) >= 4) && (lastDigit(args) <= 5)) {
            return "Yellow";
        } else if ((lastDigit(args) >= 6) && (lastDigit(args) <= 9)) {
            return "Red";
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println("The " + switchMethod(args[0]) + " light is on.");
        System.out.println("And once more. The " + ifMethod(args[0]) + " light is on.");
    }
}