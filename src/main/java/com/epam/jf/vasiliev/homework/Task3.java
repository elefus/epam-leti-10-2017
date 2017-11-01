package main.java.com.epam.jf.vasiliev.homework;

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
        int numb = Integer.parseInt(args[0]) % 10;
        System.out.println(detectColorIf(numb));
        System.out.println(detectColorSwitch(numb));
    }

    private static String detectColorIf(int numb) {
        if(numb >= 0 && numb < 4)
            return "Green";
        if(numb >= 4 && numb < 6)
            return "Yellow";
        if(numb >= 6 && numb < 10)
            return "Red";
        return "Can't resolve color!";
    }

    private static String detectColorSwitch(int numb) {
        switch(numb) {
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
                return "Can't resolve color!";
        }
    }
}
