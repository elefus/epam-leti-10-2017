package com.epam.jf.common.lesson28;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JSoupExample {

    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.parse(new File("students.xml"), "UTF-8");
//        System.out.println(doc.root());
        Elements children = doc.children();
        Element root = children.get(0).child(1).child(0);
        System.out.println(root.child(1).child(0));
    }
}
