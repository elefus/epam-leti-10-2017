package com.epam.jf.bavtovich.homework;

public class Task3 {

    public static void main(String...args) {
        if (args.length != 1) {
            System.out.println("Invalid format of input data");
        } else {

            int timeFromBeginCycle = Integer.parseInt(args[0]) % 10;

            String ifLight = whatColorIndicateIf(timeFromBeginCycle);
            String switchLight = whatColorIndicateSwitch(timeFromBeginCycle);

            System.out.println("if: " + ifLight);
            System.out.println("switch: " + switchLight);
        }
    }

    private static String whatColorIndicateIf(int time) {
        if (time <= 3) {
            return "Green light";
        }
        else if (time < 6) {
            return "Yellow light";
        }
        return "Red light";
    }

    private static String whatColorIndicateSwitch(int time) {
        switch (time) {
            case 0:
            case 1:
            case 2:
            case 3:
                return "Green light";
            case 4:
            case 5:
                return "Yellow light";
            default:
                return "Red light";
        }
    }

}
