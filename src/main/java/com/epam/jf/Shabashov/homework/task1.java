package com.epam.jf.Shabashov.homework;

public class task1{

	public static int getItself(int itself, int dummy)
	{
		return itself;
	}

	public static void main(String...args) {
		String[] names = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate" };
		int[] times = { 341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265 };
		int top1=0;
		int top2=0;
		for(int i=0;i<times.length;i++){
			if (times[i]<times[top1]){
				top2=i;
				if (times[top2]<times[top1]) top2 = getItself(top1,top1=top2);
			}
		}

		System.out.println("First place: "+names[top1]);
		System.out.println("With score: "+Integer.toString(times[top1]));
		System.out.println("Second place: "+names[top2]);
		System.out.println("With score: "+Integer.toString(times[top2]));
	}
}