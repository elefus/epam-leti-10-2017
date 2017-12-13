package com.epam.jf.dementyev.homework;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.epam.jf.common.homework.Task20.IPoem;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class Task20Test {

    @Test
    void sortPoems() {
        Set<IPoem> poems = new HashSet<>();
        poems.add(new IPoem() {
            @Override
            public List<String> getLines() {
                return Arrays.asList(
                    "Я вас любил: любовь еще, быть может,",
                    "В душе моей угасла не совсем;",
                    "Но пусть она вас больше не тревожит;",
                    "Я не хочу печалить вас ничем.",
                    "Я вас любил безмолвно, безнадежно,",
                    "То робостью, то ревностью томим;",
                    "Я вас любил так искренно, так нежно,",
                    "Как дай вам бог любимой быть другим."
                );
            }

            @Override
            public String getAuthor() {
                return "Пушкин";
            }
        });
        poems.add(new IPoem() {
            @Override
            public List<String> getLines() {
                return Arrays.asList(
                    "Ветер хрипит на мосту меж столбами,",
                    "Чёрная нить под снегами гудёт.",
                    "Чудо ползёт под моими санями,",
                    "Чудо мне сверху поёт и поёт...",
                    "Всё мне, певучее, тяжко и трудно,",
                    "Песни твои, и снега, и костры...",
                    "Чудо, я сплю, я устал непробудно.",
                    "Чудо, ложись в снеговые бугры!"
                );
            }

            @Override
            public String getAuthor() {
                return "Блок";
            }
        });

        String[] expected = {
            "В душе моей угасла не совсем;",
            "Я не хочу печалить вас ничем.",
            "То робостью, то ревностью томим;",
            "Я вас любил безмолвно, безнадежно,",
            "Я вас любил: любовь еще, быть может,",
            "Но пусть она вас больше не тревожит;",
            "Я вас любил так искренно, так нежно,",
            "Как дай вам бог любимой быть другим."
        };
        assertArrayEquals(expected, new Task20().sortPoems(poems, "Пушкин").toArray());

        String[] expected2 = {
            "Чудо ползёт под моими санями,",
            "Чёрная нить под снегами гудёт.",
            "Чудо мне сверху поёт и поёт...",
            "Чудо, ложись в снеговые бугры!",
            "Песни твои, и снега, и костры...",
            "Всё мне, певучее, тяжко и трудно,",
            "Чудо, я сплю, я устал непробудно.",
            "Ветер хрипит на мосту меж столбами,"
        };
        assertArrayEquals(expected2, new Task20().sortPoems(poems, "Блок").toArray());
    }
}