package com.epam.jf.ilyassov.homework;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class Task10ImplTest {
    @Test
    public void getSumDigitsTest()
    {
        Task10Impl task10=new Task10Impl();
        assertEquals(35, task10.getSumDigits(88874));
        assertEquals(31, task10.getSumDigits(408874));
        assertEquals(10, task10.getSumDigits(244));
        assertEquals(9, task10.getSumDigits(9000));
    }


}