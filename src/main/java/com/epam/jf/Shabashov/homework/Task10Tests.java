package com.epam.jf.Shabashov.homework;

import org.jetbrains.annotations.TestOnly;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Task10Tests {
    Task10 task = new Task10();
    @Test
    public void test1()
    {
        assertEquals(0,task.getSumDigits(0));
    }
    @Test
    public void test2()
    {
        assertEquals(1,task.getSumDigits(1));
    }
    @Test
    public void test3()
    {
        assertEquals(8,task.getSumDigits(512));
    }
    @Test
    public void test4()
    {
        assertEquals(5,task.getSumDigits(5000000));
    }

    @Test
    public void test5()
    {
        assertEquals(60,task.getSumDigits(111999111999L));
    }

}
