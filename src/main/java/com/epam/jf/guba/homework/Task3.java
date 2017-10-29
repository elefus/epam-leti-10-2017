package main.java.com.epam.jf.guba.homework;

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
        if (args.length < 1) {
            System.err.println("Недостаточно аргументов для выполнения задания");
            return;
        }

        String secArg = args[0];
        int seconds = Integer.parseInt(secArg) % 10;

        colorUsingIfElse(seconds);

        colorUsingSwitch(seconds);


    }

    private static void colorUsingIfElse(int seconds) {
        if (seconds >= 0 && seconds <= 3) {
            System.out.println("Зеленый");
        } else if (seconds >= 4 && seconds <= 5) {
            System.out.println("Желтый");
        } else {
            System.out.println("Красный");
        }
    }

    private static void colorUsingSwitch(int seconds) {
        switch (seconds) {
            case 0:
            case 1:
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
}
