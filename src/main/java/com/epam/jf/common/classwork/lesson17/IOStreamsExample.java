package com.epam.jf.common.classwork.lesson17;

import java.io.*;
import java.util.Arrays;

public class IOStreamsExample {

    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        out.write(1);
        out.write(2);
        out.write(3);
        out.write(4);
        out.write(5);
        out.write(1);
        byte[] bytes = out.toByteArray();
        System.out.println(Arrays.toString(bytes));

        PipedOutputStream outPiped = new PipedOutputStream();
        PipedInputStream in = new PipedInputStream(2);
        in.connect(outPiped);
        outPiped.write(1);
        outPiped.write(2);
//        outPiped.write(3);

        System.out.println(in.available());

        BufferedReader reader = null;
        for (String curr = reader.readLine(); curr != null; curr = reader.readLine()) {

        }


        pushBackReaderExample();

    }

    private static void pushBackReaderExample() throws IOException {
        String source = "if (a == 4) a = 0;\n";
        String result = "if (a .eq. 4) a <- 0;\n";
        char buf[] = new char[source.length()];
        source.getChars(0, source.length(), buf, 0);
        PushbackReader pushbackReader = new PushbackReader(new CharArrayReader(buf));

        int c;
        while ((c = pushbackReader.read()) != -1) {
            switch (c) {
                case '=':
                    if ((c = pushbackReader.read()) == '=')
                        System.out.print(".eq.");
                    else {
                        System.out.print("<-");
                        pushbackReader.unread(c);
                    }
                    break;

                default:
                    System.out.print((char) c);
                    break;
            }
        }
    }
}
