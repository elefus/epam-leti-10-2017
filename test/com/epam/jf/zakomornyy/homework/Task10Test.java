package com.epam.jf.zakomornyy.homework;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task10Test {
    @Test
    void getSumDigitsTest1(){
        Task10 task10 = new Task10();
        assertEquals(task10.getSumDigits(0), 0);
    }

    @Test
    void getSumDigitsTest2(){
        Task10 task10 = new Task10();
        assertEquals(task10.getSumDigits(146), 11);
    }

    @Test
    void getSumDigitsTest3(){
        System.out.println(-15%10);
        Task10 task10 = new Task10();
        assertEquals(task10.getSumDigits(-1111), 4);
    }

    @Test
    void getSumDigitsTest4(){
        Task10 task10 = new Task10();
        assertEquals(task10.getSumDigits(1234),
                     task10.getSumDigits(-4231));
    }

    @Test
    void getSumDigitsTest5(){
        Task10 task10 = new Task10();
        assertEquals(task10.getSumDigits(Long.MIN_VALUE), 89);
    }
}
