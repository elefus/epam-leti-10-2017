

import java.util.ArrayList;
import java.util.List;

/*
???????? ??????
*/

public class Solution {
    public static void main(String[] args)  {
        String[] names = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate" };
        int[] times = { 341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265 };

        int [] timesSorted={ 341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265 };


        for (int i = 0; i <timesSorted.length-1; i++) {
            int min=timesSorted[i];

            for (int j = i+1; j <timesSorted.length ; j++) {
                if(min>timesSorted[j]){
                  min=timesSorted[j];
                  timesSorted[j]=timesSorted[i];
                  timesSorted[i]=min;
                }

            }
        }

        int first=0;
        int second=0;

        for (int i = 0; i < times.length; i++) {
            if (times[i]==timesSorted[0])first=i;
            if(times[i]==timesSorted[1])second=i;
        }

        System.out.println(names[first] +" "+timesSorted[0]);

        System.out.println(names[second] +" "+timesSorted[1]);




    }
}
