package com.epam.jf.volkov.homework.task17;

import com.epam.jf.volkov.homework.task16.GenericList;

/**
 * Реализация динамически расширяемого списка на основе массива.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public class GenericArrayList<E> extends AbstractGenericList<E> {

    protected Object[] values;
    private int pointer;

    GenericArrayList (int capacity) {
        values = new Object[capacity];
        pointer = 0;
    }

    GenericArrayList (GenericArrayList list) {
        values = new Object[list.values.length];
        pointer = list.size();
        System.arraycopy(list.values, 0, values, 0, pointer);
    }

    GenericArrayList () {
        values = new Object[10];
        pointer = 0;
    }

    public boolean add(E value) {
        grow();
        int pointerBackup = pointer;
        try {
            values[pointer] = value/*.clone()*/;
            pointer++;
            return true;
        } catch (Exception ex) {
            pointer = pointerBackup;
            return false;
        }
    }

    public boolean add(E value, int index) {
        if (isCorrectIndex(index)) {
            Object[] valuesBackup = new Object[values.length];
            System.arraycopy(values, 0, valuesBackup, 0, pointer);
            int pointerBackup = pointer;
            try {
                if (isWritable()) {
                    System.arraycopy(values, index, values, index + 1, pointer - index);
                    values[index] = value;
                    pointer++;
                    return true;
                } else {
                    grow();
                    return add(value, index);
                }
            } catch (Exception ex) {
                values = valuesBackup;
                pointer = pointerBackup;
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean addAll(GenericList<? extends E> list) {
        int pointerBackup = pointer;
        for (int i = 0; i < list.size(); i++) {
            if (!add(list.get(i))) {
                pointer = pointerBackup;
                return false;
            }
        }
        return true;
    }

    public E get(int index) {
        return (E) values[index]/*.clone()*/; //...
    }

    public boolean contains(E value) {
        for (int i = 0; i < pointer; i++) {
            if (values[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsAll(GenericList<? extends E> list) {
        for (int i = 0; i < list.size(); i++) {
            if (!contains(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public E remove(int index)  {
        if (isCorrectIndex(index)) {
            Object[] valuesBackup = new Object[values.length];
            System.arraycopy(values, 0, valuesBackup, 0, pointer);
            int pointerBackup = pointer;
            try {
                E temp = (E) values[index];
                System.arraycopy(values, index + 1, values, index, pointer - index);
                pointer--;
                return temp;
            } catch (Exception ex) {
                values = valuesBackup;
                pointer = pointerBackup;
                throw ex;
            }
        } else {
            throw new IllegalArgumentException("Bad index");
        }
    }

    public boolean removeB(int index) {  //Решил добавить также реализации с return bool
        if (isCorrectIndex(index)) {
            Object[] valuesBackup = new Object[values.length];
            System.arraycopy(values, 0, valuesBackup, 0, pointer);
            int pointerBackup = pointer;
            try {
                System.arraycopy(values, index + 1, values, index, pointer - index);
                pointer--;
                return true;
            } catch (Exception ex) {
                values = valuesBackup;
                pointer = pointerBackup;
                return false;
            }
        } else {
            return false;
        }
    }

    public E remove(E value) {
        try {
            return remove(indexOf(value));
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Value not found");
        }
    }

    public boolean removeB(Object value) {
        return removeB(indexOf((E) value));
    }

    public boolean removeAll(GenericList<? extends E> list) {
        Object[] valuesBackup = new Object[values.length];
        System.arraycopy(values, 0, valuesBackup, 0, pointer);
        int pointerBackup = pointer;
        for (int i = 0; i < list.size(); i++) {
            if (!removeB(list.get(i))) {
                values = valuesBackup;
                pointer = pointerBackup;
                return false;
            }
        }
        return true;
    }

    public E set(E value, int index) {
        if (isCorrectIndex(index)) {
            E temp = (E) values[index];
            values[index] = value;
            return temp;
        } else {
            throw new IllegalArgumentException("Bad index");
        }
    }

    public void clear() {
        pointer = 0;
    }

    public int size() {
        return pointer;
    }

    public boolean isEmpty() {
        return pointer == 0;
    }

    public int indexOf(E value) /*throws IllegalArgumentException*/ {
        for (int i = 0; i < pointer; i++) {
            if (values[i].equals(value)) {
                return i;
            }
        }
        //throw new IllegalArgumentException("No such value");
        return -1;
    }

    public int lastIndexOf(E value) {
        for (int i = pointer - 1; i >= 0; i--) {
            if (values[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public GenericArrayList<E> subList(int from, int to) {
        if (isCorrectIndex(from) && isCorrectIndex(to)) {
            GenericArrayList<E> subList = new GenericArrayList<E>(to - from);
            System.arraycopy(values, from, subList.values, 0, to - from);
            subList.pointer = to - from;
            return subList;
        } else {
            throw new IllegalArgumentException("Bad index");
        }
    }

    public Object[] toArray() {
        Object[] newArray = new Object[pointer];
        System.arraycopy(values, 0, newArray, 0, pointer);
        return newArray;
    }

    //Далее - утилитарные методы для красивого кода. Я разработчик (т.е. личинка разработчика), я так вижу!

    private boolean isCorrectIndex(int index) {
        return (index < pointer && index >= 0);
    }

    private boolean grow() {
        return grow(1);
    }

    private boolean grow(int addedSpace) {
        Object[] valuesBackup = values;
        try {
            Object[] newValues = new Object[values.length + addedSpace + 1];
            System.arraycopy(values, 0, newValues, 0, pointer);
            values = newValues;
            return true;
        } catch (Exception ex) {
            values = valuesBackup;
            return false;
        }
    }

    public int getAvailableSpace() {
        return values.length - pointer;
    }

    public boolean isWritable() {
        return pointer < values.length;
    }

    public boolean isWritable(int amount) {
        return isWritable() && (getAvailableSpace() >= amount);
    }

    public static boolean isWritable(GenericArrayList list, int amount) { //Почему бы и да
        return list.isWritable(amount);
    }
}
