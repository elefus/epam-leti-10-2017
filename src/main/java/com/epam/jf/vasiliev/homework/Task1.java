package com.epam.jf.vasiliev.homework;

public class Task1 {
    public static void main(String...args) {
		String[] names = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma",
		 "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate" };
   		int[] times = { 11, 341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265 };

   		int first = times[0] > times[1] ? 1 : 0;
   		int second = 1 - first;

   		for(int i = 2; i < times.length;++i) {
   			if(times[i] < times[second]) {
   				second = i;
				if(times[first] >= times[second]) {
					int buff = first;
					first = second;
					second = buff;
				}
   			}
   		}

   		System.out.println("First is " + names[first] + ",time - " + times[first]);
   		System.out.println("Second is " + names[second] + ",time - " + times[second]);
	}
}