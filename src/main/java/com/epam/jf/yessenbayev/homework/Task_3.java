package main.java.com.epam.jf.yessenbayev.homework;

/**
 * Необходимо смоделировать работу светофора.
 * С 0 по 3 секунду светофор горит зеленым
 * С 4 по 5 секунду светофор горит желтым
 * С 6 по 9 секунду светофор горит красным
 * На вход программе подается целое положительное число в виде строки (через параметры командной строки args), представляющее секунды с момента начала работы светофора.
 * Необходимо определить, каким цветом будет гореть светофор спустя указанное количество секунд и вывести в консоль ответ.
 * Задачу можно решить используя операторы условного ветвления if и switch, следует реализовать оба варианта.
 */
public class Task_3 {

    /**
     * @param args [0] - количество секунд, прошедших с момента начала работы светофора.
     */
    public static void main(String[] args) {
        try{
            int seconds = Integer.valueOf(args[0]) % 10;
            if (seconds < 0 ) throw new Exception("Error, number must be positive");
            String resultForIf = ifMethod(seconds);
            String resultForSwitch = switchMethod(seconds);
            System.out.println("Result for if-method - " + resultForIf);
            System.out.println("Result for switch-method - " + resultForSwitch);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error, enter the number");
        } catch (NumberFormatException e){
            System.out.println("Error, number must be an integer");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }




    }

    private static String ifMethod(int seconds){
        if (seconds >= 0 && seconds <= 3){
            return "GREEN";
        }
        else if(seconds >= 6 && seconds <= 9){
            return "RED";
        }
        else
            return "YELLOW";

    }

    private static String switchMethod(int seconds){
        switch (seconds){
            case 0:
            case 1:
            case 2:
            case 3:
                return "GREEN";

            case 4:
            case 5:
                return "YELLOW";

            case 6:
            case 7:
            case 8:
            case 9:
                return "RED";
            default:
                return null;
        }
    }
}
