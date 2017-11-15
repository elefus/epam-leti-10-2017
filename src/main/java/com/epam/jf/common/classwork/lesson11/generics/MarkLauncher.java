package com.epam.jf.common.classwork.lesson11.generics;

public class MarkLauncher {

    public static void main(String[] args) {
        // Mark<String> ms = new Mark<String>(“7”);
        //ошибка компиляции
        Mark<Double> doubleMark = new Mark<>(71.4D);//71.5d
        System.out.println(doubleMark.sameAny(doubleMark));
        System.out.println(doubleMark.same(doubleMark));

        Mark<Integer> integerMark = new Mark<>(71);
        System.out.println(doubleMark.sameAny(integerMark));
//        System.out.println(doubleMark.same(integerMark));
        // md.same (mi); //ошибка компиляции

        System.out.println(doubleMark.roundMark());

        Mark rawMark = new Mark(10);
        rawMark.same(doubleMark);
        rawMark.sameAny(rawMark);
        rawMark.sameAny(doubleMark);
    }
}
