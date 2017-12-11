package main.java.com.epam.jf.Kazakov.homework;

public class Task3 {
    private static String switchMethodOfColorDetect(String args) {
        char lastChar = args.charAt(args.length() - 1);
        switch (lastChar) {
            case '0':
            case '1':
            case '2':
            case '3': {
                return "green";
            }
            case '4':
            case '5': {
                return "yellow";
            }
            case '6':
            case '7':
            case '8':
            case '9': {
                return "red";
            }
        }
        return "";
    }

    private static String ifMethodOfColorDetect(String args) {
        char lastChar = args.charAt(args.length() - 1);
        if(lastChar == '0' || lastChar == '1' || lastChar == '2' || lastChar == '3') {
            return "green";
        }
        else if(lastChar == '4' || lastChar == '5') {
            return "yellow";
        }
        else if(lastChar == '6' || lastChar == '7' || lastChar == '8' || lastChar == '9') {
            return "red";
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println("Switch method: ");
        System.out.println("Traffic light is on " + switchMethodOfColorDetect(args[0]) + " after " + args[0] + " seconds");
        System.out.println("\"If\" method: ");
        System.out.println("Traffic light is on " + ifMethodOfColorDetect(args[0]) + " after " + args[0] + " seconds");
    }
}
