public class Task2 {

    public static void main(String...args) {
        String min = args[0];
        String max = args[0];

       for (String s :args){
            if (s.length() >= max.length()) {
                max = s;
            }

            if (s.length() <= min.length()) {
                min = s;
            }
        }

        System.out.println("Max string: " + max);
        System.out.println("Min string: " + min);
    }
}
