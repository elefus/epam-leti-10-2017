package com.epam.jf.khvan.homework;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

public class Task20Test {

    private Task20Implememnt task20;
    private static  Set<Task20.IPoem> POEMS = new HashSet<>();

    static {
        POEMS.add(new Task20.IPoem() {
            @Override
            public List<String> getLines() {
                return new ArrayList<String>(Arrays.asList("Я", "памятник", "себе"));
            }

            @Override
            public String getAuthor() {
                return "Pushkin";
            }
        });
        POEMS.add(new Task20.IPoem() {
            @Override
            public List<String> getLines() {
                return new ArrayList<String>(Arrays.asList("A", "AA", "ACAB"));
            }

            @Override
            public String getAuthor() {
                return "Lermontov";
            }
        });
        POEMS.add(new Task20.IPoem() {
            @Override
            public List<String> getLines() {
                return new ArrayList<String>(Arrays.asList("B", "cc", "BIQLE"));
            }

            @Override
            public String getAuthor() {
                return "Lermontov";
            }
        });
    }

    @Test
    void testSingle() {
        task20 = new Task20Implememnt();
        List<String> actual = task20.sortPoems(POEMS, "Pushkin");
        List<String> expected = new ArrayList<>(Arrays.asList("Я", "себе" , "памятник"));
        assertEquals(actual, expected);
        assertEquals(actual.get(0), "Я");
        assertEquals(actual.get(actual.size() - 1), "памятник");
    }

    @Test
    void testManyPoems() {
        task20 = new Task20Implememnt();

        List<String> actual = task20.sortPoems(POEMS, "Lermontov");
        List<String> expected = new ArrayList<>(Arrays.asList("A", "B", "AA", "cc", "ACAB", "BIQLE"));
        assertThat(actual, is(expected));
        assertEquals(actual.get(0), "A");
        assertEquals(actual.size(), 6);
    }

    @Test
    void testEmpty() {
        task20 = new Task20Implememnt();

        List<String> actual = task20.sortPoems(POEMS, "Pasternac");
        List<String> expected = new ArrayList<>();
        assertThat(actual, is(expected));
        assertEquals(actual.size(), 0);
    }
}

