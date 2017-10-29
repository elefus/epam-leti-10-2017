package com.epam.jf.kozlov.homework;

public class Task3 {

    /**
     * @param args [0] - количество секунд, прошедших с момента начала работы светофора.
     */
    public static void main(String[] args) throws IllegalArgumentException {
        try {
            int i = Integer.parseInt(args[0]);
            if(i < 0)
                throw new IllegalArgumentException("Error:Input argument must be positive");
            IfResolve(i%10);
            SwitchResolve(i%10);
        }
        catch (NumberFormatException e){
            System.out.println("Error:Input argument must be a number");
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Error:No arguments given");
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    private static void IfResolve(int time){
        System.out.println("If method:");
        if(time >= 0 && time <= 3 )
            System.out.println("Green\n");
        else if(time >= 4 && time <= 5 )
            System.out.println("Yellow\n");
        else if(time >= 6 && time <= 9 )
            System.out.println("Red\n");
    }

    /*
    Еслибы диапозоны были большии, имело бы смысл создать перечисление со значениями GREEN, YELLOW, RED.
    Но так как у нас небольшой диапозон значений, то можно обойтись и данным решением.
     */
    private static void SwitchResolve(int time){
        System.out.println("Switch method:");
        switch (time){
            case 0:
            case 1:
            case 2:
            case 3:
                System.out.println("Green\n");
                break;
            case 4:
            case 5:
                System.out.println("Yellow\n");
                break;
            case 6:
            case 7:
            case 8:
            case 9:
                System.out.println("Red\n");
                break;
        }

    }
}
