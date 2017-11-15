package com.epam.jf.ilyassov.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task9ImplTest {
    @Test
    public void checkIsPowerOfTwo()
    {
        Task9Impl task9 = new Task9Impl();
        for (int i = 0; i < 129; i++) {
            if(i==1||i==2||i==4||i==8||i==16||i==32||i==64||i==128)
            {
                assertTrue(task9.isPowerOfTwo(i));
            }
            else
                assertFalse(task9.isPowerOfTwo(i));
        }
    }

}