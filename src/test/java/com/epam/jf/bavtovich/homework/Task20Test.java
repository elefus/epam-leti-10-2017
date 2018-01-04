package com.epam.jf.bavtovich.homework;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task20Test {
    @Test
    void sortPoems() {

        String text1 = "Был и я среди донцов,\n" +
                          "Гнал и я османов шайку;\n" +
                          "В память битвы и шатров\n" +
                          "Я домой привез нагайку";
        String text2 = "На походе, на войне\n" +
                        "Сохранил я балалайку -\n" +
                        "С нею рядом, на стене\n" +
                        "Я повешу и нагайку.\n";
        String text3 =  "Еду. Тихо. Слышны звоны\n" +
                        "Под копытом на снегу.\n" +
                        "Словно серые вороны\n" +
                        "Раскричались на лугу.\n" +
                        "Заколдован невидимкой,\n" +
                        "Дремлет лес под сказку сна,\n" +
                        "Словно белою косынкой\n" +
                        "Повязалася сосна.";

        Task20.Poem pushkinFirst = new Task20.Poem("Пушкин", text1);
        Task20.Poem pushkinSecond = new Task20.Poem("Пушкин", text2);
        Task20.Poem eseninFirst = new Task20.Poem("Есенин", text3);

        Set<Task20.Poem> poems = new HashSet<Task20.Poem>();
        poems.add(pushkinFirst);
        poems.add(pushkinSecond);
        poems.add(eseninFirst);

        String[] expectedResult = {"На походе, на войне",
                                           "Я повешу и нагайку.",
                                           "С нею рядом, на стене",
                                           "Был и я среди донцов,",
                                           "Сохранил я балалайку -",
                                           "Я домой привез нагайку",
                                           "Гнал и я османов шайку;",
                                           "В память битвы и шатров"};
        assertArrayEquals(Task20.sortPoems(poems, "Пушкин").toArray(), expectedResult);

        String[] expectedResult2 = {"Повязалася сосна.",
                                    "Словно серые вороны",
                                    "Под копытом на снегу.",
                                    "Раскричались на лугу.",
                                    "Словно белою косынкой",
                                    "Заколдован невидимкой,",
                                    "Еду. Тихо. Слышны звоны",
                                    "Дремлет лес под сказку сна,"};
        assertArrayEquals(Task20.sortPoems(poems, "Есенин").toArray(), expectedResult2);

    }

}