package com.epam.jf.ilyassov.homework;

import java.util.HashMap;
import java.util.Map;

public class Task22 extends com.epam.jf.common.homework.Task22 {

    public static void main(String[] args) {
        Task22 task = new Task22();
        HashMap<Integer, Integer> first=new HashMap<>();
        HashMap<Integer, Integer> second=new HashMap<>();
        for (int i = 0; i < 4; i++) {
            first.put(i,i+1);
            second.put(i+1,i+1);
        }
        HashMap<Integer, Integer> result = task.addPolynomials(first, second);
        for (Map.Entry entry : result.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: "
                    + entry.getValue());
        }
    }
    @Override
    public HashMap<Integer, Integer> addPolynomials(HashMap<Integer, Integer> first, HashMap<Integer, Integer> second) {

        HashMap<Integer, Integer> result=new HashMap<>(first);

        second.forEach((Integer key, Integer value) ->{
            if(!result.containsKey(key)){
                result.put(key,value);
            }
            else {
                    result.replace(key,result.get(key)+value);
            }
        });

        return result;
    }
}