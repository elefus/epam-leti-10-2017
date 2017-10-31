package com.epam.jf.khvan.homework;

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
        // TODO решение задачи
        if(args.length>0){
            int n =Integer.parseInt(args[0]);
            switch (n){
                case 0..3:System.out.println("Green");
                    break;
                case 4..5:System.out.println("Yellow");
                    break;
                case 6..9:System.out.println("Red");
                    break;
                default:
                    System.out.println("Inavailable"); }

                    if(n>=0 & n <=3){
                System.out.println("Green");
            }
            else  if(n>=4 & n<=5){
                System.out.println("Yellow");
            }
            else  if(n>=6 & n<=9){
                System.out.println("Red");
            } else {
                System.out.println("Inavailable");
            }
        }
    }
}
