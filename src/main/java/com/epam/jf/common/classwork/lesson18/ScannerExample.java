package com.epam.jf.common.classwork.lesson18;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ScannerExample {

    public static void main(String[] args) throws IOException {
        File file = new File("abc.txt");

        try (FileReader reader = new FileReader(file)) {
            Scanner scanner = new Scanner(reader);
            if (scanner.hasNextInt()) {
                char[] chars = new char[100];
                int read = reader.read(chars);
                System.out.println(read);

                scanner.findWithinHorizon("zxc", 2000);
            }
        }

        Scanner scanner = new Scanner(System.in);
        scanner.next();
        scanner.close();

        System.in.read();
    }
}
