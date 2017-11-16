package com.epam.jf.Shabashov.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task11Tests {
    Task11 task = new Task11();
    @Test
    public void test1()
    {
        assertEquals(0,task.reverse(0));
    }
    @Test
    public void test2()
    {
        assertEquals(1,task.reverse(1));
    }
    @Test
    public void test3()
    {
        assertEquals(215,task.reverse(512));
    }
    @Test
    public void test4()
    {
        assertEquals(5,task.reverse(5000000));
    }

    @Test
    public void test5()
    {
        assertEquals(987654321,task.reverse(123456789));
    }

}
