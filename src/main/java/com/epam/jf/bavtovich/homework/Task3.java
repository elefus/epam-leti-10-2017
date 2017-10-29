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
        String answer = "";
        if (time <= 3) {
            answer = "Green light";
        }
        if (time > 3 & time <6) {
            answer = "Yellow light";
        }
        if (time > 6) {
            answer = "Red light";
        }
        return answer;
    }

    private static String whatColorIndicateSwitch(int time) {
        String answer = "";
        switch (time) {
            case 0:
            case 1:
            case 2:
            case 3:
                answer = "Green light";
                break;
            case 4:
            case 5:
                answer = "Yellow light";
                break;
            case 6:
            case 7:
            case 8:
            case 9:
                answer = "Red light";
        }
        return answer;
    }

}
