package com.epam.jf.khvan.homework;

public class StringsQuest {
    public static void main(String [] m) {
        String shortest=m[0];
        String longest=m[0];
        for (int i = 0; i <m.length ; i++) {
            if(m[i].length()>=longest.length()){
                longest=m[i];
            }
            if(m[i].length()<=shortest.length()){
                shortest=m[i];
            }}
        System.out.println(shortest);
        System.out.println(longest);
    }
}


