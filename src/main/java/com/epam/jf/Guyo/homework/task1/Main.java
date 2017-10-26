package com.company;

class Main{

    public static void main (String[] args){

        String[] names = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate" };
        int[] times = { 341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265 };

        int min1 = times[0];
        int min2 = times[1];
        int temp;
        int count1 = 0;
        int count2 = 0;

        if (min1 > min2){
            temp = min1;
            min1 = min2;
            min2 = temp;
        }

        for(int i = 2; i <= (times.length-1); i++){
            if (times[i] < min1){
                min1 = times[i];
                count1 = i;
            }
        }

        for(int j = 2; j <= (times.length-1); j++){
            if(j == count1){
                continue;
            }
            else{
                if (times[j] < min2){
                    min2 = times[j];
                    count2 = j;
                }
            }
        }

        System.out.println("First place - " + names[count1] + " with " + times[count1]);
        System.out.println("Second place - " + names[count2] + " with " + times[count2]);
    }
}
