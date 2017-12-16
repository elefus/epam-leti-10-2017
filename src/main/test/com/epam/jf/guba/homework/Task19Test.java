package com.epam.jf.guba.homework;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Task19Test {

    private Task19 task19 = new Task19();

    @Test
    void testEmpty() {
        assertEquals(0, task19.rotateMatrixCounterclockwise(new int[0][]).length);
    }

    @Test
    void testSquare() {
        int[][] checked = { {1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}
        };
        int[][] actual = task19.rotateMatrixCounterclockwise(checked);

        int[] row1 = {3, 6, 9};
        int[] row2 = {2, 5, 8};
        int[] row3 = {1, 4, 7};

        assertThat(actual[0], is(row1));
        assertThat(actual[1], is(row2));
        assertThat(actual[2], is(row3));


    }

    @Test
    void testDoubleSquare() {
        int[][] checked = { {1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}
        };
        int[][] actual = task19.rotateMatrixCounterclockwise(task19.rotateMatrixCounterclockwise(checked));

        int[] row1 = {9, 8, 7};
        int[] row2 = {6, 5, 4};
        int[] row3 = {3, 2, 1};

        assertThat(actual[0], is(row1));
        assertThat(actual[1], is(row2));
        assertThat(actual[2], is(row3));

    }

    @Test
    void testRectangle() {
        int[][] checked = { {1, 2, 3, 10},
                            {4, 5, 6, 11},
                            {7, 8, 9, 12}
        };
        int[][] actual = task19.rotateMatrixCounterclockwise(checked);

        int[] row1 = {10, 11, 12};
        int[] row2 = {3, 6, 9};
        int[] row3 = {2, 5, 8};
        int[] row4 = {1, 4, 7};

        assertThat(actual[0], is(row1));
        assertThat(actual[1], is(row2));
        assertThat(actual[2], is(row3));
        assertThat(actual[3], is(row4));
    }

    @Test
    void testDoubleRectangle() {
        int[][] checked = { {1, 2, 3, 10},
                            {4, 5, 6, 11},
                            {7, 8, 9, 12}
        };
        int[][] actual = task19.rotateMatrixCounterclockwise(task19.rotateMatrixCounterclockwise(checked));

        int[] row1 = {12, 9, 8, 7};
        int[] row2 = {11, 6, 5, 4};
        int[] row3 = {10, 3, 2, 1};

        assertThat(actual[0], is(row1));
        assertThat(actual[1], is(row2));
        assertThat(actual[2], is(row3));
    }


}
