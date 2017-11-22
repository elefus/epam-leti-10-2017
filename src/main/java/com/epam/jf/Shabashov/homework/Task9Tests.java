package com.epam.jf.Shabashov.homework;

import org.jetbrains.annotations.TestOnly;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Task9Tests {
    Task9 task = new Task9();
    @Test
    public void test1()
    {
        assertFalse(task.isPowerOfTwo(0));
    }
    @Test
    public void test2()
    {
        assertTrue(task.isPowerOfTwo(1));
    }
    @Test
    public void test3()
    {
        assertTrue(task.isPowerOfTwo(512));
    }
    @Test
    public void test4()
    {
        assertFalse(task.isPowerOfTwo(511));
    }

    @Test
    public void test5()
    {
        assertFalse(task.isPowerOfTwo(513));
    }

}
