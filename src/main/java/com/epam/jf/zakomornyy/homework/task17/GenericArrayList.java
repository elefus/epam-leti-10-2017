package com.epam.jf.zakomornyy.homework.task17;

import com.epam.jf.zakomornyy.homework.task16.GenericList;

import java.util.Arrays;

/**
 * Реализация динамически расширяемого списка на основе массива.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public class GenericArrayList<E> extends AbstractGenericList<E> {

    private Object[] values;

    public GenericArrayList() {
    }

    public GenericArrayList(int capacity) {
        values = new Object[capacity];
    }


    @Override
    public Object[] toArray() {
        return Arrays.copyOf(values, size);
    }

    @Override
    public boolean add(E e) {
        Object[] buffArray = new Object[this.size() + 1];
        System.arraycopy(this.values, 0, buffArray, 0, this.size());
        buffArray[this.size()] = e;
        this.values = buffArray;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for(int i = 0; i < this.size(); i++) {
            if(this.get(i).equals(o)) {
                this.remove(i);
                return true;

            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        return (E) values[index];
    }

    @Override
    public E set(int index, E element) {
        if(index < size()) {
            E prevElement = get(index);
            values[index] = element;
            return prevElement;
        }
        return null;
    }

    @Override
    public void add(int index, E element) {
        Object[] buffArray = new Object[this.size() + 1];
        System.arraycopy(this.values, 0, buffArray, 0, index);
        System.arraycopy(this.values, index, buffArray, index + 1, buffArray.length - index - 1);
        buffArray[index] = element;
        this.values = buffArray;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E remove(int index) {
        if(index < size()) {
            Object o = this.values[index];
            Object[] buffArray = new Object[this.size() - 1];
            System.arraycopy(this.values, 0, buffArray, 0, index);
            System.arraycopy(this.values, index + 1, buffArray, index, buffArray.length - index);
            this.values = buffArray;
            return (E) o;
        }
        return null;
    }

    @Override
    public int indexOf(Object o) {
        for(int i = 0; i < size(); i++) {
            if(o.equals(this.values[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for(int i = size() - 1; i >= 0; i++) {
            if(o.equals(this.values[i])) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public GenericList<E> subList(int fromIndex, int toIndex) {
        GenericArrayList genericArrayList = new GenericArrayList(toIndex - fromIndex + 1);
        System.arraycopy(this.values, fromIndex,
                genericArrayList.values, 0,
                genericArrayList.size());
        return genericArrayList;
    }

}
