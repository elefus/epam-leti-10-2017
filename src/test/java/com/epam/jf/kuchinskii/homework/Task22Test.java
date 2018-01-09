package com.epam.jf.kuchinskii.homework;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import org.junit.jupiter.api.Test;

public class Task22Test {

    @Test
    void testSameDegrees() {
        Task22 t = new Task22();
        HashMap<Integer, Integer> first = new HashMap<Integer, Integer>()
        {{
            put(0, 5);
            put(1, 1);
            put(2, 2);
        }};
        HashMap<Integer, Integer> second = new HashMap<Integer, Integer>()
        {{
            put(0, 5);
            put(1, 1);
            put(2, 2);
        }};

        HashMap<Integer, Integer> result = t.addPolynomials(first, second);

        HashMap<Integer, Integer> check = new HashMap<Integer, Integer>()
        {{
            put(0, 10);
            put(1, 2);
            put(2, 4);
        }};
        assertTrue(check.equals(result));
    }

    @Test
    void testDiffDegrees() {
        Task22 t = new Task22();
        HashMap<Integer, Integer> first = new HashMap<Integer, Integer>()
        {{
            put(1, 1);
            put(2, 2);
        }};
        HashMap<Integer, Integer> second = new HashMap<Integer, Integer>()
        {{
            put(0, 5);
            put(1, 1);
        }};

        HashMap<Integer, Integer> result = t.addPolynomials(first, second);

        HashMap<Integer, Integer> check = new HashMap<Integer, Integer>()
        {{
            put(0, 5);
            put(1, 2);
            put(2, 2);
        }};
        assertTrue(check.equals(result));
    }
}
