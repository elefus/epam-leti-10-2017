package com.epam.jf.vasiliev.homework.task7;

import java.util.ArrayList;

public class IntArrayList extends AbstractIntArrayList {

    private final int DEFAULT_CAPACITY = 10;

    private int size;

    IntArrayList() {
        values = new int[DEFAULT_CAPACITY];
    }

    IntArrayList(int capacity) {
        if(capacity < 0) {
            throw new IllegalArgumentException("Capacity is less than zero!");
        }
        values = new int[capacity];
    }

    IntArrayList(AbstractIntArrayList list) {
        values = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.add(list.get(i));
        }
    }

    @Override
    public boolean add(int value) {
        if(size + 1 > values.length) {
            increaseCapacity();
        }
        values[size++] = value;
        return true;
    }

    @Override
    public boolean add(int value, int index) {
        if(index < 0 || index > values.length + 1) {
            return false;
        }
        if(index > values.length) {
            increaseCapacity();
        }
        System.arraycopy(values,index,values,index + 1,size - index);
        size++;
        values[index] = value;
        return true;
    }

    @Override
    public int get(int index) {
        if(index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        return values[index];
    }

    @Override
    public boolean contains(int value) {
        for (int crt : values) {
            if(crt == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(AbstractIntArrayList list) {
        if(list.size() > values.length) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if(!this.contains(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int remove(int index) {
        if(index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        int delElem = values[index];
        System.arraycopy(values,index+1,values,index,size - index);
        size--;
        return delElem;
    }

    @Override
    public int set(int value, int index) {
        if(index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        int oldValue = values[index];
        values[index] = value;
        return  oldValue;
    }

    @Override
    public boolean addAll(AbstractIntArrayList list) {
        while (size + list.size() < values.length) {
            increaseCapacity();
        }
        for (int i = 0; i < list.size(); i++) {
            values[size++] = list.get(i);
        }
        return true;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if(values[i] == value) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(int value) {
        for (int i = size-1; i >= 0; i--) {
            if(values[i] == value) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public AbstractIntArrayList subList(int fromInclusive, int toInclusive) {
        if(fromInclusive < 0 || toInclusive > size) {
            throw new IndexOutOfBoundsException();
        }
        if(fromInclusive > toInclusive) {
            throw new IllegalArgumentException("first bound should be <= second!");
        }

        IntArrayList res = new IntArrayList(toInclusive - fromInclusive);
        for (int i = fromInclusive; i < toInclusive; i++) {
            res.add(values[i]);
        }
        return res;
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < size; i++) {
            res += values[i] + " ";
        }
        return res;
    }

    private void increaseCapacity() {
        int[] newArr = new int[values.length + (values.length >> 1)];
        System.arraycopy(values,0,newArr,0,size);
        values = newArr;
    }
}
