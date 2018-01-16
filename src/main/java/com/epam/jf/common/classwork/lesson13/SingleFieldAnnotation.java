package com.epam.jf.common.classwork.lesson13;

import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
public @interface SingleFieldAnnotation {
    String value() default "42";
}
