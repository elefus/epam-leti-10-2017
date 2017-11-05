package com.epam.jf.burachenko.homework;

public class Task1 {
	public static void main(String...args) {
		String[] names = {"Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate"};

		int[] times = {341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265};

		int i_first = 0;
		int i_second = 0;

		int first;
		int second;
		if(times[0] < times[1]) {
			first = times[0];
			second = times[1];
		}
		else {
			first = times[1];
			second = times[0];
		}

		for (int i = 2; i < times.length; i++) {
			if (times[i] < first) {
				first = times[i];
				i_first = i;
			}
			else
				if (times[i] < second) {
					second = times[i];
					i_second = i;
				}
		}
		System.out.println("Первым прибежал(а): " + names[i_first] + " за " + times[i_first]);
		System.out.println("Вторым прибежал(а): " + names[i_second] + " за " + times[i_second]);
	}
}
