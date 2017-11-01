package main.java.com.epam.jf.vasiliev.homework;

public class Task1 {
    public static void main(String...args) {
		String[] names = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma",
		 "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate" };
   		int[] times = { 341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265 };

   		int first = 0;
   		int second = 0;
   		for(int i = 0; i < times.length;i++) {
   			if(times[i] < times[first]) {
   				first = i;
   				if(second < first) {
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