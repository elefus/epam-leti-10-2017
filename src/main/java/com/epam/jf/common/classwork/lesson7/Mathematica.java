package com.epam.jf.common.classwork.lesson7;

@SuppressWarnings("all")
public class Mathematica {

    public Mathematica(Object obj){}
    public Mathematica(Num obj){}
    public Mathematica(Int obj){}
    public Mathematica(Num obj1, Int obj2){}
    public Mathematica(Int obj1, Int obj2) {}

    public static void method(double val1, Double val2) {
        Math.abs(4);
    }

    public static void method(Integer intVal1, int intVal2) {

    }

    public static void method(int...values) {

    }

    public static void main(String[] args) {

         method(1, 2);


        Num num = new Num();
        Mathematica m1 = new Mathematica(num);

        Int intValue = new Int();
        Mathematica mathematica = new Mathematica(intValue);

        Num numValue = intValue;
        Mathematica mathematica1 = new Mathematica(numValue);

        LongInt longInt = new LongInt();
        Mathematica mathematica2 = new Mathematica(longInt);

//        new Mathematica(num, (Int)num);
        Mathematica mathematica3 = new Mathematica(intValue, intValue);
        Mathematica mathematica4 = new Mathematica(num, longInt);
    }
}




class Num {}
class Int extends Num {}
class LongInt extends Int {}

