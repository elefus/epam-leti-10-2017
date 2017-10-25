package main.java.com.epam.jf.yessenbayev.homework;

public class Task_2 {
    public static void main(String[] args) {
        int min = 0;
        int max = 0;

        for(int i = 0; i < args.length; i++){
            if (args[i].length() >= args[max].length())
                max = i;
            else if(args[i].length() <= args[min].length())
                min = i;
        }
        System.out.println("Min is " + args[min]);
        System.out.println("Max is " + args[max]);
    }
}
