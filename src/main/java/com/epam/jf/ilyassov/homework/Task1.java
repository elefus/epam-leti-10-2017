public class Task1 {

    public static void main(String... args) {
        String[] names = {"Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate"};
        int[] times = {341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265};
        int k = Integer.MAX_VALUE;
        int index = 0;
        int second = 0;
        int index2 = 0;
        int y = 0;
        for (int i = 0; i < times.length; ++i) {
            index2++;
            if (k > times[i]) {
                y = index2;
                second = k;
                k = times[i];
                index = i;
                index2 = 0;
            }

        }
        System.out.println("First: " + names[index] + ", score: " + k);
        System.out.println("Second: " + names[index - y] + " , score: " + second);

    }
}
