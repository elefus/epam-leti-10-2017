package com.epam.jf.Guyo.homework;

class Task1{

    public static void main (String[] args){

        String[] names = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate" };
        int[] times = {341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265};
        int indexFirst = 0;
        int indexSecond = 1;
        int temp;

        if (times[indexSecond] < times[indexFirst]){
            temp = indexFirst;
            indexFirst = indexSecond;
            indexSecond = temp;
        }
        for (int i = 2; i < times.length ; i++) {
            if(times[i] < times[indexFirst]) {
                indexSecond = indexFirst;
                indexFirst = i;
            }
            else if(times[i] < times[indexSecond]){
                indexSecond = i;
            }
        }
        System.out.println("First place - " + names[indexFirst] + " with " + times[indexFirst]);
        System.out.println("Second place - " + names[indexSecond] + " with " + times[indexSecond]);
    }
}
