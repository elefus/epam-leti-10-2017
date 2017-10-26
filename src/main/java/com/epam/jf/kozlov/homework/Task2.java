package main.java.com.epam.jf.kozlov.homework;

public class Task2 {
    public static void main(String[] args) {
        int max = 0;
        int min = 0;
        try {
            for (int i = 0; i < args.length; i++) {
                if (args[i].length() >= args[max].length())
                    max = i;
                if (args[i].length() <= args[min].length())
                    min = i;
            }
            System.out.println("String with minimum length:" + args[min]);
            System.out.println("String with maximum length:" + args[max]);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Error:No arguments given");
        }
    }
}
