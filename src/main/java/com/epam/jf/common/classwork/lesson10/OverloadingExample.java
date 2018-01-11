package com.epam.jf.common.classwork.lesson10;

@SuppressWarnings({"unused", "WeakerAccess"})
public class OverloadingExample {

    public static void method(int...args) {}
    public static void method(int a, int b) {}
    public static void method(String...args) {}


    public static int getArgCount(Integer...args) {
        if (args.length == 0){
            System.out.print("No arg");}
        for (int i : args){
            System.out.print("arg:" + i + "  ");}
        return args.length;
    }

    public static void getArgCount(Integer[]...args) {
        if (args.length == 0){
            System.out.print("No arg2");}
        for (Integer[] mas : args){
            for(int x : mas){
                System.out.print("arg2:" + x + "  ");
            }
        }
    }

    public static void printArgCount(Object... args) { // 1
        System.out.println("Object args: " + args.length);
    }

    public static void printArgCount(Integer[]...args) { // 2
        System.out.println("Integer[] args: " + args.length);
    }

    public static void printArgCount(int...args) { // 3
        System.out.print("int args: " + +args.length);
    }

    public static void printValues(long a, Long b) {}
    public static void printValues(short...values) {}
    public static void printValues(Short a, short b) {}
    public static void printValues(Object...values) {}


    public static void main(String args[]) {
        short a = 10;
        short b = 30;
        printValues(a, b);
    }
}
