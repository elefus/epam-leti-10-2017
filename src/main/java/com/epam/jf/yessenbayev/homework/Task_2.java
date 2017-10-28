package main.java.com.epam.jf.yessenbayev.homework;

public class Task_2 {
    public static void main(String[] args) {


        if (args.length > 0){

            int max = 0;
            int min = 0;

            for(int i = 0; i < args.length; i++){
                if (args[i].length() >= args[max].length()) max = i;
                if (args[i].length() <= args[min].length()) min = i;

            }

            System.out.println("Max is " + args[max]);
            System.out.println("Min is " + args[min]);

        } else System.out.println("Error! Please input args");



    }
}

