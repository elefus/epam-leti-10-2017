package com.epam.jf.khvan.homework.Solution.java

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args)  {
        String[] names = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate" };
        int[] times = { 341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265 };
        int first = 0;
        int second = 0;
          for(int i = 0; i <times.length; i++) {
              if (   times[i] <=  times[first]    &&     first   != i ) {
                second= first;
                first = i;
              }
              if(   second!= i & times[second] < times[first] &   times[second]   >   times[i] ){
                  second=i;
              }}
        System.out.println("First " + names[first] + " " + times[first]);
        System.out.println("Second " + names[second] + " " + times[second]);
    }
}





