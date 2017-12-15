package com.epam.jf.common.classwork.lesson15;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleExample {

    public static void main(String[] args) {
        System.out.println(Locale.getDefault());
        ResourceBundle prop = ResourceBundle.getBundle("prop");
        System.out.println(prop.getString("key1"));

        System.out.println(ResourceBundle.getBundle("prop", Locale.US).getString("key1"));
        System.out.println(ResourceBundle.getBundle("prop", Locale.ENGLISH).getString("key1"));
        System.out.println(ResourceBundle.getBundle("prop", Locale.FRANCE).getString("key1"));

        System.out.println(ResourceBundle.getBundle("prop", new Locale("ru", "BLR")).getString("key1"));
        System.out.println(ResourceBundle.getBundle("prop", new Locale("ru", "RU", "unix")).getString("key1"));
    }
}
