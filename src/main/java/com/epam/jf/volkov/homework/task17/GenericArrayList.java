package com.epam.jf.volkov.homework.task17;

import com.epam.jf.volkov.homework.task16.GenericList;

/**
 * Реализация динамически расширяемого списка на основе массива.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public class GenericArrayList<E> extends AbstractGenericList<E> {

    protected Object[] values;
    private int size;

    GenericArrayList() {
        values = new Object[10];
    }

    GenericArrayList(int length) {
        values = new Object[length];
    }

    GenericArrayList(GenericList<E> list) {
        addAll(list);
    }

    @Override
    public boolean add(E value, int index) {
        if (index == size || isCorrectIndex(index)) {
            Object[] valuesBackup = new Object[values.length];
            System.arraycopy(values, 0, valuesBackup, 0, size);
            int sizeBackup = size;
            try {
                if (isWritable()) {
                    System.arraycopy(values, index, values, index + 1, size - index);
                    values[index] = value;
                    size++;
                    return true;
                } else {
                    grow();
                    return add(value, index);
                }
            } catch (Exception ex) {
                values = valuesBackup;
                size = sizeBackup;
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public E get(int index) {
        return (E) values[index];
    }

    @Override
    public E remove(int index)  {
        if (isCorrectIndex(index)) {
            Object[] valuesBackup = new Object[values.length];
            System.arraycopy(values, 0, valuesBackup, 0, size);
            int sizeBackup = size;
            try {
                E temp = (E) values[index];
                System.arraycopy(values, index + 1, values, index, size - index);
                size--;
                return temp;
            } catch (Exception ex) {
                values = valuesBackup;
                size = sizeBackup;
                throw ex;
            }
        } else {
            throw new IllegalArgumentException("Bad index");
        }
    }

    @Override
    public E set(E value, int index) {
        if (isCorrectIndex(index)) {
            E temp = (E) values[index];
            values[index] = value;
            return temp;
        } else {
            throw new IllegalArgumentException("Bad index");
        }
    }

    @Override
    public int lastIndexOf(E value) {
        for (int i = size - 1; i >= 0; i--) {
            if (values[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public GenericList<E> subList(int from, int to) {
        if (isCorrectIndex(from) && isCorrectIndex(to)) {
            GenericArrayList<E> sub = new GenericArrayList<E>(to - from);
            System.arraycopy(values, from, sub.values, 0, to - from);
            sub.size = to - from;
            return sub;
        } else {
            throw new IllegalArgumentException("Bad index");
        }
    }

    ////////////////////////////////////////////////////////

    private boolean isCorrectIndex(int index) {
        return (index < size && index >= 0);
    }

    private boolean grow() {
        return grow(1);
    }

    private boolean grow(int addedSpace) {
        Object[] valuesBackup = values;
        try {
            Object[] newValues = new Object[values.length + addedSpace + 1];
            System.arraycopy(values, 0, newValues, 0, size);
            values = newValues;
            return true;
        } catch (Exception ex) {
            values = valuesBackup;
            return false;
        }
    }

    public int getAvailableSpace() {
        return values.length - size;
    }

    public boolean isWritable() {
        return size < values.length;
    }

    public boolean isWritable(int amount) {
        return isWritable() && (getAvailableSpace() >= amount);
    }

    public static boolean isWritable(GenericArrayList list, int amount) { //Почему бы и да
        return list.isWritable(amount);
    }
}
