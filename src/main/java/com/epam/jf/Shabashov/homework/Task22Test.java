package com.epam.jf.Shabashov.homework;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Task22Test {
    private Task22 tt = new Task22();

    @Test
    void test1() {
        HashMap<Integer,Integer> first = new HashMap<>();
        HashMap<Integer,Integer> second = new HashMap<>();
        HashMap<Integer,Integer> answer = new HashMap<>();
        answer.put(1,14);
        answer.put(2,14);
        answer.put(3,20);
        answer.put(4,21);
        answer.put(5,31);
        first.put(1,4);
        first.put(2,5);
        first.put(3,16);
        first.put(4,21);
        second.put(1,10);
        second.put(2,9);
        second.put(3,4);
        second.put(5,31);
        HashMap<Integer,Integer> map = tt.addPolynomials(first,second);
        map.forEach((Integer key,Integer val)->{
            if (answer.containsKey(key) && val.equals(answer.get(key))){
                answer.remove(key);
            }else{
                assertTrue(false);
            }
        });
        if (!answer.isEmpty())assertTrue(false);
    }

    @Test
    void testTwoPlynomsWithDifferentDegreesAndWithZeroCoefs() {
        HashMap<Integer, Integer> first = new HashMap<>();
        first.put(6,-4);
        first.put(2,2);
        first.put(0,-6);

        HashMap<Integer, Integer> second = new HashMap<>();
        second.put(4,13);
        second.put(2,-2);
        second.put(1,3);
        second.put(0,2);

        HashMap<Integer,Integer> expected = new HashMap<>();
        expected.put(6,-4);
        expected.put(4,13);
        expected.put(1,3);
        expected.put(0,-4);

        HashMap<Integer, Integer> result = tt.addPolynomials(first,second);
        System.out.println(Arrays.toString(expected.entrySet().toArray()));
        System.out.println(Arrays.toString(result.entrySet().toArray()));
        assertArrayEquals(expected.entrySet().toArray(), result.entrySet().toArray());
    }


}