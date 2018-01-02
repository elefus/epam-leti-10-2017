package com.epam.jf.common.classwork.lesson13;

import java.lang.annotation.Annotation;
import java.util.Arrays;

/**
 * abc
 * @see SingleFieldAnnotation
 */
@MyAnnotation(author = "me", version = "1.0", values = {1, 2, 3})
@SingleFieldAnnotation
public class AnnotationExample {

    @SingleFieldAnnotation
    private final int value = 10;

    @MyAnnotation(author = "me", version = "1.0")
    @SingleFieldAnnotation("123")
    public static void main(String[] args) {

    }

    @SuppressWarnings({"unused", "abc"})
    private @SingleFieldAnnotation int method() {
        return 0;
    }

    @Override
    @SingleFieldAnnotation
    public String toString() {
        return super.toString();
    }
}

class B extends AnnotationExample {

    public static void main(String[] args) {
        for (Annotation annotation : AnnotationExample.class.getAnnotations()) {
            System.out.println(annotation);
        }

        MyAnnotation annotation = AnnotationExample.class.getAnnotation(MyAnnotation.class);
        System.out.println(Arrays.toString(annotation.values()));
    }
}