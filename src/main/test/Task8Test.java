import com.epam.jf.ilyinykh.homework.Task8;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task8Test {
    @Test
    void testCheckIfPoly() {
        assertTrue(Task8.checkIfPoly("13531"));
        assertTrue(Task8.checkIfPoly("118811"));
        assertTrue(Task8.checkIfPoly("1"));
        assertFalse(Task8.checkIfPoly("118911"));
        assertFalse(Task8.checkIfPoly("hello"));
        assertFalse(Task8.checkIfPoly("helloolleh"));
        assertFalse(Task8.checkIfPoly("11a11"));
        assertFalse(Task8.checkIfPoly("11aa11"));
        assertFalse(Task8.checkIfPoly("a"));
    }

    @Test
    void testGetResult() {
        assertArrayEquals("3228223".toCharArray(),
                          Task8.getResult(new String[]{"hello", "here", "a", "1a1", "1", "3228223", "abddba"}).toCharArray());
        assertArrayEquals("1".toCharArray(),
                Task8.getResult(new String[]{"hello", "here", "a", "1a1", "3228223", "1", "abddba"}).toCharArray());
    }
}
