package main.java.com.epam.jf.yessenbayev.homework;

public class Task_1 {
    public static void main(String[] args) {
        String[] names = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma",
                "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate" };
        int[] times = { 341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265 };

        int max = 0;
        int preMax = 0;
        for(int i = 0; i < times.length; i++){
            if (max != i && times[i] > times[max]) {
                preMax = max;
                max = i;
            } else
            if (preMax != i && times[i] > times[preMax] && times[i] < times[max])
                preMax = i;
        }

        System.out.println("Fastest person is " + names[max] + " with " + times[max]);
        System.out.println("Second person is " + names[preMax] + " with " + times[preMax]);
    }
}
