package com.epam.jf.common.classwork.lesson18;

import java.io.*;

public class ExternalizableExample {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOutput);
        out.writeObject(new C());


        System.out.println(byteOutput.size());
        System.out.println(new String(byteOutput.toByteArray(), "UTF-8"));

        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(byteOutput.toByteArray()));
        C ref = (C) in.readObject();
        System.out.println(ref);
    }

}

class C implements Externalizable {

    private final static long serialVersionUID = 1;

    private int field = 1;
    private double doubleField = 2.5;
    private B ref = new B();

    public C() {
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(field);
//        out.writeObject(ref);
        out.writeDouble(doubleField);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        field = in.readInt();
        ref = new B();
        doubleField = in.readDouble();
    }

    @Override
    public String toString() {
        return "C{" +
                "field=" + field +
                ", doubleField=" + doubleField +
//                ", ref=" + ref +
                '}';
    }
}
