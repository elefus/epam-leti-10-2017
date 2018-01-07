package java.com.epam.jf.common.homework;

import com.epam.jf.common.homework.Task9;
import com.epam.jf.khvan.homework.LinkedListImplement;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;

public class Task17Test  {


    @Test
    void sortArray() {
        LinkedListImplement<Integer> list = new LinkedListImplement<>();
        list.add(4);
        list.add(5);
        list.add(3);
        list.sort(Comparator.comparing(o -> o));
        Object[] expected = new Number[]{ 3, 4, 5};
        assertArrayEquals(expected, list.toArray());
    }

}
