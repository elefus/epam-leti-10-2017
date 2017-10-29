package com.epam.jf.volkov.homework;

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
            int time = Integer.parseInt(args[0])%12;
            // || GREEN 0 1 2 3 | YELLOW 4 5 | RED 6 7 8 9 | YELLOW 10 11 || GREEN 12 13 14 15 | YELLOW 16 17 | RED 18 19 ..
            String ifresult = ifelsemethod(time);
            String switchresult = switchmethod(time);
            System.out.println("The if-else operator result color is: "+ifresult);
            System.out.println("The switch operator result color is: "+switchresult);
        } catch (Exception e) {
            System.out.println("There is an exception. Check the args.");
        }
    }



    private static String ifelsemethod(int seconds) {
        if (seconds>=6&&seconds<=9) return "RED";
        else if (seconds<4) return "GREEN";
        else return "YELLOW";
    }

    private static String switchmethod(int seconds) {
        String result = "string";
        switch (seconds) {
            case 0:
            case 1:
            case 2:
            case 3:
                result = "GREEN";
                break;
            case 4:
            case 5:
            case 10:
            case 11:
                result = "YELLOW";
                break;
            case 6:
            case 7:
            case 8:
            case 9:
                result = "RED";
                break;
            default:
                result = "ERROR";
                break;
        }
        return result;
    }

}
