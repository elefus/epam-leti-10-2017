package com.epam.jf.burachenko.homework;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class Task20Test {
    @Test
    void testSortPoems3() {
        Set<com.epam.jf.common.homework.Task20.IPoem> poems = new HashSet<>();
        poems.add(new Task20.IPoem(Arrays.asList("The angel was flying through sky in midnight,",
                                                 "And softly he sang in his flight;",
                                                 "And clouds, and stars, and the moon in a throng",
                                                 "Hearkened to that holy song."),
                                    "Lermontov"));
        poems.add(new Task20.IPoem(Arrays.asList("When I often stay a motley crowd in,",
                                                 "When before my eyes, as in an awful dream,",
                                                 "To humming orchestras and dances, ",
                                                 "And foolish whispering of speeches learnt by eart,",
                                                 "Flit figures of the people lost of heart,",
                                                 "And masques with a false politeness;"),
                                    "Lermontov"));
        poems.add(new Task20.IPoem(Arrays.asList("Not long ago, in a charming dream,",
                                                 "I saw myself -- a king with crown's treasure;",
                                                 "I was in love with you, it seemed,",
                                                 "And heart was beating with a pleasure.",
                                                 "I sang my passion's song by your enchanting knees.",
                                                 "Why, dreams, you didn't prolong my happiness forever?",
                                                 "But gods deprived me not of whole their favor:",
                                                 "I only lost the kingdom of my dreams."),
                                    "Pushkin"));

        List<String> res = Arrays.asList("The angel was flying through sky in midnight,",
                                         "And softly he sang in his flight;",
                                         "And clouds, and stars, and the moon in a throng",
                                         "Hearkened to that holy song.",
                                         "When I often stay a motley crowd in,",
                                         "When before my eyes, as in an awful dream,",
                                         "To humming orchestras and dances, ",
                                         "And foolish whispering of speeches learnt by eart,",
                                         "Flit figures of the people lost of heart,",
                                         "And masques with a false politeness;");
        res.sort(Comparator.comparingInt(String::length));

        System.out.println(Arrays.toString(new Task20().sortPoems(poems, "Lermontov").toArray()));
        System.out.println(res);

        assertArrayEquals(res.toArray(), new Task20().sortPoems(poems, "Lermontov").toArray());
    }
}