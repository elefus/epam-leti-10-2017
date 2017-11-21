package com.epam.jf.ilyassov.homework;
public class Task3 {

    public static void main(String[] args) {
        if(args.length!=0)
        {
            int temp = Integer.parseInt(args[0]);
            temp = temp % 10;
            method_if(temp);
            method_switch(temp);
        }

    }

    private static void method_if(int temp) {

            if (temp >= 0 && temp <= 3) {

                System.out.println("The traffic light is green");

            } else if (temp >= 4 && temp <= 5) {
                System.out.println("The traffic light is yellow");

            } else if (temp >= 6 && temp <= 9) {
                System.out.println("The traffic light is red");
            }


    }

    private static void method_switch(int temp) {
            switch (temp) {
                case 0:
                case 1:
                case 2:
                case 3:
                    System.out.println("The traffic light is green");
                    break;
                case 4:
                case 5:
                    System.out.println("The traffic light is yellow");
                    break;
                case 6:
                case 7:
                case 8:
                case 9:
                    System.out.println("The traffic light is red");
                    break;
            }


    }

}
