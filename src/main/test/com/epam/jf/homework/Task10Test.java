package com.epam.jf.homework;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.epam.jf.guba.homework.Task10;
import org.junit.jupiter.api.Test;

public class Task10Test {

    Task10 task10 = new Task10();


    @Test
    void checkSingleDigitValue(){
        assertEquals(15, task10.getSumDigits(951));
    }


    @Test
    void checkZero(){
        assertEquals(0, task10.getSumDigits(0));
    }


    @Test
    void checkReflexive(){
        assertEquals(task10.getSumDigits(951), task10.getSumDigits(519));
        assertEquals(task10.getSumDigits(915), task10.getSumDigits(519));
        assertEquals(task10.getSumDigits(951), task10.getSumDigits(591));
        assertEquals(task10.getSumDigits(915), task10.getSumDigits(591));
        assertEquals(task10.getSumDigits(951), task10.getSumDigits(159));
        assertEquals(task10.getSumDigits(915), task10.getSumDigits(159));
        assertEquals(task10.getSumDigits(951), task10.getSumDigits(195));
        assertEquals(task10.getSumDigits(915), task10.getSumDigits(195));

    }


    @Test
    void checkTransitive(){
        assertEquals(task10.getSumDigits(105059), task10.getSumDigits(2882));
        assertEquals(task10.getSumDigits(105059), task10.getSumDigits(7391));
        assertEquals(task10.getSumDigits(7391), task10.getSumDigits(2882));
    }

}
