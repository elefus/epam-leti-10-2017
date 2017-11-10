package main.java.com.epam.jf.Kazakov.homework;

public class Task1 {
    public static void main(String...args) {
        String[] names = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate" };
        int[] times = { 341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 455, 231, 543 };

        int minTime = times[0];
        int indexMinTime = 0;
        int secondMinTime = times[1];
        int indexSecondMinTime = 1;

        if(minTime > secondMinTime) {
            int temp_time = minTime;
            int temp_index = indexMinTime;
            minTime = secondMinTime;
            indexMinTime = indexSecondMinTime;
            secondMinTime = temp_time;
            indexSecondMinTime = temp_index;
        }

        for (int i = 1; i < times.length; ++i) {
            if(times[i] < minTime) {
                indexSecondMinTime = indexMinTime;
                secondMinTime = minTime;
                minTime = times[i];
                indexMinTime = i;
            }
            else if(times[i] < secondMinTime && times[i] > minTime) {
                secondMinTime = times[i];
                indexSecondMinTime = i;
            }
        }

        System.out.println("1st time has " + names[indexMinTime] + " with a result " + minTime);
        System.out.println("2nd time has " + names[indexSecondMinTime] + " with a result " + secondMinTime);
    }
}
