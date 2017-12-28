package com.epam.jf.common.classwork.lesson18;

import java.io.*;

public class HackSerialization implements Serializable {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOutput);
        out.writeObject(new HackSerialization());


        System.out.println(byteOutput.size());
        System.out.println(new String(byteOutput.toByteArray(), "UTF-8"));

        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(byteOutput.toByteArray()));
        HackSerialization ref = (HackSerialization) in.readObject();
        System.out.println(ref);
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        System.out.println("writeObject");
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        System.out.println("readObject");
    }
}
