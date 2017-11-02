package com.epam.jf.zakomornyy.homework;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;


public class Task6 {

    /**
     * @param args анализируемые строки.
     */
    public static void main(String[] args) {
        StringWithComparator[] strings = new StringWithComparator[args.length];
        for(int i = 0; i < strings.length; i++){
            strings[i] = new StringWithComparator(args[i]);
        }
        Arrays.sort(strings);
        for (StringWithComparator str: strings) {
            System.out.println(str);
        }
    }

    static class StringWithComparator implements Comparable<StringWithComparator>{

        private final String str;

        StringWithComparator(String str) {
            this.str = str;
        }
        @Override
        public String toString() {
            return str;
        }
        @Override
        public int compareTo(@NotNull StringWithComparator o) {
            if(str.length() == o.str.length()) {
                return str.compareTo(o.str);
            } else if(str.length() > o.str.length()) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}

