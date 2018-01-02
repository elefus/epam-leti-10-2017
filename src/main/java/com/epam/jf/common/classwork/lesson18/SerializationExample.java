package com.epam.jf.common.classwork.lesson18;

import java.io.*;

public class SerializationExample {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        OutputStream out = new FileOutputStream("aSerialized.tmp");
        ObjectOutputStream oout = new ObjectOutputStream(out);
        B refB = new B();
        A a1 = new A(refB);
        A a2 = new A(refB);

        oout.writeObject(a1);

        oout.reset();
        refB.setbValue(-41);
        oout.writeObject(a2);

//        byte[] bytes = out.toByteArray();
//        System.out.println(bytes.length);
//        System.out.println(new String(bytes, "UTF-8"));

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("aSerialized.tmp"));
        A desA1 = (A) ois.readObject();
        A desA2 = (A) ois.readObject();

        System.out.println(a1 == desA1);
        System.out.println(a2 == desA2);
        System.out.println(a1.getRefToB() == a2.getRefToB());
        System.out.println(a1.getRefToB() == desA1.getRefToB());
        System.out.println(desA1.getRefToB() == desA2.getRefToB());
        System.out.println(desA1.getRefToB().getBValue() == desA2.getRefToB().getBValue());
    }
}

class A implements Serializable {

    private static final long serialVersionUID = -3063807878767903021L;

    private static double doubleValue = 0.5;
    private String stringField = "abc";
    private int intValue2 = 42;
    private transient boolean booleanValue = true;
    private final B refToB;

    A(B refToB) {
        this.refToB = refToB;
    }

    public B getRefToB() {
        return refToB;
    }

    @Override
    public String toString() {
        return "A{" +
                "stringField='" + stringField + '\'' +
                ", intValue=" + intValue2 +
                ", booleanValue=" + booleanValue +
                ", refToB=" + refToB +
                '}';
    }
}

class B implements Serializable {
    private int bValue = 41;

    public void setbValue(int bValue) {
        this.bValue = bValue;
    }

    public int getBValue() {
        return bValue;
    }
}