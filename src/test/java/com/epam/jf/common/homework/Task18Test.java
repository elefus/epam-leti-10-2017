package java.com.epam.jf.common.homework;

import com.epam.jf.khvan.homework.Task18Implement;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Task18Test {

    @Test
    void test1() {
        List<Integer> test = Arrays.asList(1, 2, 3, 4, 5);
        assertArrayEquals(test.toArray(), new Task18Implement().getSublistOfMaximumIncreasingSequence(test).toArray());
    }

    @Test
    void test2() {
        List<Integer> test = Arrays.asList(4, 4, 3, 2, 1);
        assertArrayEquals(new Integer[]{4},  new Task18Implement().getSublistOfMaximumIncreasingSequence(test).toArray());
    }


    @Test
    void test3() {
        List<Integer> test = Arrays.asList(7, 5, 6, 1, 2, 3);
        assertArrayEquals(new Integer[]{1, 2, 3},  new Task18Implement().getSublistOfMaximumIncreasingSequence(test).toArray());
    }

    @Test
    void test4() {
        List<Integer> test = Arrays.asList(7, 8, -9, 5, 6, 1);
        assertArrayEquals(new Integer[]{-9, 5, 6}, new Task18Implement().getSublistOfMaximumIncreasingSequence(test).toArray());
    }
}

