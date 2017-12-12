package com.epam.jf.ilyassov.homework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task14ImpTest {

    @Test
    void TestMethod() {
        int arr[][]={ {1,3,2}, {4,7,1},{0,5,5}};
        Task14Imp task14Imp = new Task14Imp();
        task14Imp.sortMatrixByValuesInColumn(arr,2);
        assertEquals(4,arr[0][0]);
        assertFalse(10==arr[2][2]);


    }
}