package com.epam.jf.ilyassov.homework;

import com.epam.jf.common.homework.Task20;

import java.util.List;


public class IPoemImpl implements Task20.IPoem {

    List<String> list;
    String author;

    public IPoemImpl(List<String> list, String author) {
        this.list = list;
        this.author = author;
    }

    @Override
    public List<String> getLines() {
        return list;
    }

    @Override
    public String getAuthor() {
        return author;
    }
}
