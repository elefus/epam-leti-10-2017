package com.epam.jf.common.lesson27;

import java.io.FileInputStream;
import java.io.InputStream;

public class StAXExample {

    public static void main(String[] args) throws Exception {
        StAXParser parser = new StAXParser();

        // создание входного потока данных из xml-файла
        InputStream input = new FileInputStream("students.xml");

        // разбор файла с выводом результата на консоль
        parser.parse(input);
    }
}

