package com.epam.jf.common.classwork.lesson9;

import org.jetbrains.annotations.NotNull;

import javax.xml.ws.WebEndpoint;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class CloneExample {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException {
        ChildClass childClass = new ChildClass();
        ChildClass clone = childClass.clone();
        System.out.println(clone);
        System.out.println(childClass == clone);

        System.out.println(childClass.getDoubles() == clone.getDoubles());
        childClass.getDoubles()[0] = -100;
        System.out.println(clone.getDoubles()[0]);


        System.out.println(childClass.getArr() == clone.getArr());

        Field doubles = ChildClass.class.getDeclaredField("doubles");
        doubles.setAccessible(true);
        double[] arr = (double[]) doubles.get(clone);
        System.out.println(arr == clone.getDoubles());

        Method getDoubles = ChildClass.class.getDeclaredMethod("getDoubles");
        Annotation[] declaredAnnotations = getDoubles.getDeclaredAnnotations();
        for (Annotation declaredAnnotation : declaredAnnotations) {
            System.out.println(declaredAnnotation);
        }
    }

}



class BaseClass {

    public static int numberObjects;

    private int[] arr = {1, 2, 3, 4};

    public BaseClass() {
        ++numberObjects;
    }

    public int[] getArr() {
        return arr;
    }

    @Override
    public BaseClass clone() {
        try {
            BaseClass clone = (BaseClass) super.clone();
            clone.arr = Arrays.copyOf(arr, arr.length);
            return clone;
        } catch (CloneNotSupportedException ex) {
            throw new Error(ex);
        }
    }

    @Override
    public String toString() {
        return "BaseClass{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }
}


class ChildClass extends BaseClass implements Cloneable {

    private final double[] doubles = {1, 2, 3, 4.5};

    @WebEndpoint
    public double[] getDoubles() {
        return doubles;
    }

    @Override
    public ChildClass clone() {
        ChildClass clone = (ChildClass) super.clone();
        try {
            Class<ChildClass> childClassClass = ChildClass.class;
            Field doublesField = childClassClass.getDeclaredField("doubles");
            doublesField.setAccessible(true);
            doublesField.set(this, Arrays.copyOf(doubles, doubles.length));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return clone;
    }

    @Override
    public String toString() {
        return "ChildClass{" +
                "doubles=" + Arrays.toString(doubles) +
                '}' + super.toString();
    }
}