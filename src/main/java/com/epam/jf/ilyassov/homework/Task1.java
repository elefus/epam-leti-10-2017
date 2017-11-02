public class Task1 {

    public static void main(String... args) {
        String[] names = {"Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate"};
        int[] times = {341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265};
        int k = Integer.MAX_VALUE;
        int min_index = 0;
        int sec_index=0;
        int second=Integer.MAX_VALUE;
        for (int i = 0; i < times.length; ++i) {
            if (k > times[i]) {
                second=k;
                k = times[i];
                min_index = i;
            }
            else
            if(second>times[i])
            {
                second=times[i];
                sec_index=i;
            }
        }
        System.out.println("First: " + names[min_index] + ", score: " + k);
        System.out.println("Second: " + names[sec_index] + " , score: " + second);

    }
}
