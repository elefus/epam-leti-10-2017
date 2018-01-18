package com.epam.jf.common.classwork.lesson10.staticinit;

import java.util.HashMap;
import java.util.Map;

class Man {
    public Map<String, Integer> map = new HashMap<>();
    {
        map.put("", 1);
        map.put("", 1);
        map.put("", 1);
        map.put("", 1);
    }



    public static String form = "man";

    static {
        System.out.println("static block in Man.");
    }

    public String form1 = "man";

    {
        System.out.println("Non-static in Man 1");
    }

    public static void stMan() {
        System.out.println("static method in Man.");
    }

    public Man() {
        System.out.println("Constructor in Man");
    }

    {
        System.out.println("Non-static in Man 2");
    }
}

class Doctor extends Man {

    static {
        System.out.println("static block in Doctor");
    }

    {
        System.out.println("Non-static in Doctor 1");
    }

    public Doctor() {
        super();
        // init blocks
        System.out.println("Constructor in Doctor");
    }

    public static void stDoctor() {
        System.out.println("static method in Doctor.");
    }

    {
        System.out.println("Non-static in Doctor 2");
    }
}

class Launcher {
    public static void main(String[] args) {
//        Doctor.stMan();
//        Doctor doctor = new Doctor();
//        System.out.println(doctor.form);
        new Doctor();
    }
}
