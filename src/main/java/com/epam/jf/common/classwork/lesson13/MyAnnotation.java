package com.epam.jf.common.classwork.lesson13;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String version();
    String author();
    int[] values() default {};
}
