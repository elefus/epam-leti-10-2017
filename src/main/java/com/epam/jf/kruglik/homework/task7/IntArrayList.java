package com.epam.jf.kruglik.homework.task7;

import java.util.ArrayList;

public class IntArrayList extends AbstractIntArrayList {

    public IntArrayList() {
        values = new int[10];
        this.capacity = 10;
    }

    public IntArrayList(int capacity) {
        values = new int[capacity];
        this.capacity = capacity;
    }

    public IntArrayList(AbstractIntArrayList list) {
        values = new int[list.size()];
        this.capacity = list.size();
        this.size = list.size();

        for (int i = 0; i < list.size(); i++) {
            values[i] = list.get(i);
        }
    }


    @Override
    public boolean add(int value) {
        if (capacity<=(size)){
            increaseCapacity();
        }
        values[size] = value;
        ++size;
        return true;
    }

    @Override
    public boolean add(int value, int index) {
        if (capacity<=size){
            increaseCapacity();
        }
        System.arraycopy(values, index, values, index + 1, size - index);
        values[index] = value;
        ++size;
        return false;
    }

    @Override
    public int get(int index) {
        return values[index];
    }

    @Override
    public boolean contains(int value) {
        for(int i = 0;i<size;++i){
            if (values[i] == value)
                return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(AbstractIntArrayList list) {
        boolean flag = false;
        for (int i = 0;i<list.size();++i){
            for (int j = 0;j<size;++j)
                if (list.get(i) == values[j]){
                    flag = true;
                    break;
                }
            if (!flag){
                return false;
            }
        }
        return true;
    }

    @Override
    public int remove(int index) {
        int returnValue = values[index];
        System.arraycopy(values, index + 1, values, index, size - index);
        --size;
        return returnValue;
    }

    @Override
    public int set(int value, int index) {
        values[index] = value;
        return values[index];
    }

    @Override
    public boolean addAll(AbstractIntArrayList list) {
        while (capacity <= size + list.size()){
            increaseCapacity();
        }
        for(int i = 0;i<list.size();++i)
            values[size+i] = list.get(i);
        size += list.size();
        return true;
    }

    @Override
    public void clear() {
        for (int i=0;i<size;++i)
            values[i] = 0;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size > 0;
    }

    @Override
    public int indexOf(int value) {
        for(int i = 0;i<size;++i){
            if (values[i] == value)
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(int value) {
        for(int i = size - 1;i>=0;--i){
            if (values[i] == value)
                return i;
        }
        return -1;
    }

    @Override
    public AbstractIntArrayList subList(int fromInclusive, int toInclusive) {
        AbstractIntArrayList buffer = new IntArrayList((toInclusive - fromInclusive)+1);
        for (int i=fromInclusive;i<=toInclusive;++i)
            buffer.add(values[i]);
        return buffer;
    }

    public int getCapacity(){
        return capacity;
    }

    private void increaseCapacity(){
        capacity *= 2;
        int[] buffer = new int[capacity];
        System.arraycopy(values, 0, buffer, 0, size);
        values = buffer;
    }
}