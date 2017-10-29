package com.epam.jf.zakomornyy.homework;

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
        if(args.length >= 1){
            try{
                int seconds = Integer.parseInt(args[0]);
                if(seconds >= 0){
                    trafficLightsSimulationWithIf(seconds);
                    trafficLightsSimulationWithSwitch(seconds);
                } else {
                    System.out.println("Number must be positive");
                }
            }catch(NumberFormatException e){
                System.out.println("Argument must be Integer");
            }
        }else {
            System.out.println("Enter at least one argument");
        }

    }

    public static void trafficLightsSimulationWithIf(int seconds){
        int secondsModTen = seconds % 10;
        if(secondsModTen >= 0 && secondsModTen <= 3) {
            System.out.println("Green");
        } else if(secondsModTen >= 4 && secondsModTen <= 5) {
            System.out.println("Yellow");
        } else {
            System.out.println("Red");
        }
    }

    public static void trafficLightsSimulationWithSwitch(int seconds){
        int secondsModTen = seconds % 10;
        switch (secondsModTen) {
            case 0:
            case 1:
            case 2:
            case 3:
                System.out.println("Green");
                break;
            case 4:
            case 5:
                System.out.println("Yellow");
                break;
            case 6:
            case 7:
            case 8:
            case 9:
                System.out.println("Red");
                break;
        }
    }
}
