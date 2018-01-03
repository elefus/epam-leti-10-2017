package com.epam.jf.guba.homework;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.epam.jf.common.homework.Task20.IPoem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

public class Task20Test {

    private Task20 task20;
    private static final Set<IPoem> POEMS = new HashSet<>();

    static {
        POEMS.add(new IPoem() {
            @Override
            public List<String> getLines() {
                return new ArrayList<String>(Arrays.asList("A", "AAA", "AAAAAAAB"));
            }

            @Override
            public String getAuthor() {
                return "first";
            }
        });
        POEMS.add(new IPoem() {
            @Override
            public List<String> getLines() {
                return new ArrayList<String>(Arrays.asList("A", "AAA", "AAAAAAAB"));
            }

            @Override
            public String getAuthor() {
                return "second";
            }
        });
        POEMS.add(new IPoem() {
            @Override
            public List<String> getLines() {
                return new ArrayList<String>(Arrays.asList("B", "BBB", "BBBBBBA"));
            }

            @Override
            public String getAuthor() {
                return "second";
            }
        });
    }


    @Test
    void testExceptions() {
        assertThrows(IllegalArgumentException.class, () -> (new Task20()).sortPoems(null, null));
    }

    @Test
    void testSingle() {
        task20 = new Task20();
        List<String> actual = task20.sortPoems(POEMS, "first");
        List<String> expected = new ArrayList<>(Arrays.asList("A", "AAA", "AAAAAAAB"));
        assertThat(actual, is(expected));
        assertEquals(actual.get(0), "A");
        assertEquals(actual.get(actual.size() - 1), "AAAAAAAB");
    }

    @Test
    void testMulty() {
        task20 = new Task20();
        List<String> actual = task20.sortPoems(POEMS, "second");
        List<String> expected = new ArrayList<>(Arrays.asList("A", "B", "AAA", "BBB", "BBBBBBA", "AAAAAAAB"));
        assertThat(actual, is(expected));
        assertEquals(actual.get(0), "A");
        assertEquals(actual.size(), 6);
    }

    @Test
    void testNone() {
        task20 = new Task20();
        List<String> actual = task20.sortPoems(POEMS, "third");
        List<String> expected = new ArrayList<>();
        assertThat(actual, is(expected));
        assertEquals(actual.size(), 0);
    }
}
