
public class Task2 {
    public static void main(String[] args) {
        String max = args[0];
        String min = args[0];
        if (args.length == 0) {
            System.out.println("Error,args is empty");
        } else {
            for (int i = 0; i < args.length; ++i) {
                if (max.length() <= args[i].length()) {
                    max = args[i];
                }
                if (min.length() >= args[i].length()) {
                    min = args[i];
                }
            }
            System.out.println("Minimum " + min);
            System.out.println("Maximum " + max);
        }
    }
}
