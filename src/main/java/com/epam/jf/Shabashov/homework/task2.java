package com.epam.jf.Shabashov.homework;

public class task2{
	public static void main(String[] args) {
		int nMin=0;
		int nMax=0;
		for (int i=0;i<args.length;i++) {
			if (args[i].length()>=args[nMax].length()) nMax=i;
			if (args[i].length()<=args[nMin].length()) nMin=i;
		}
		System.out.println("Minimal string: "+args[nMin]);
		System.out.println("Maximal string: "+args[nMax]);
	}
}