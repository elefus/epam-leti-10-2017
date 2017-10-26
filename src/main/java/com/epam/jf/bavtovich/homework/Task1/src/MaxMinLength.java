public class MaxMinLength {

    public static void main(String...args) {

        int minLenIndex = 0;
        int maxLenIndex = 0;

        if (args.length > 0) {

            for (int i = 1; i < args.length; i++) {
                if (args[i].length() >= args[maxLenIndex].length()) {
                    maxLenIndex = i;
                }
                else {
                    if (args[i].length() <= args[minLenIndex].length()) {
                        minLenIndex = i;
                    }
                }
            }
        }

        System.out.println("Минимальная строка среди представленных: " + args[minLenIndex]);
        System.out.println("Максималья строка среди представленных: " + args[maxLenIndex]);

    }
}