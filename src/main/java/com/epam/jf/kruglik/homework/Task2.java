package main.java.com.epam.jf.kruglikalexey.homework;

public class SecondTask {

    public static void main(String... args) {
        String minString = null;
        String maxString = null;
        int maxNumb = Integer.MIN_VALUE;
        int minNumb = Integer.MAX_VALUE;

       for (String s :args){
            if (s.length() >= maxNumb) {
                maxNumb = s.length();
                maxString = s;
            }

            if (s.length() <= minNumb) {
                minNumb = s.length();
                minString = s;
            }
        }

        System.out.println("Max string: " + maxString);
        System.out.println("Min string: " + minString);
    }
}
