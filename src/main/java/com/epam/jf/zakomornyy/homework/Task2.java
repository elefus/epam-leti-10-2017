package com.epam.jf.zakomornyy.homework;

public class Task2 {
    public static void main(String[] args){
        if(args.length != 0){
            String lastMin = args[0],
                    lastMax = args[0];
            for(String str : args){
                if(str.length() >= lastMax.length()){
                    lastMax = str;
                }
                if(str.length() <= lastMin.length()){
                    lastMin = str;
                }
            }
            System.out.println("lastMax: " + lastMax + "\nlastMin: " + lastMin);
        }
    }
}