package com.epam.jf.kruglik.homework.task17;

import java.util.ArrayList;
import java.util.Arrays;

public class GenericArrayList<E>  extends  AbstractGenericList<E>{
    Object[] elementsData;
    int capacity;

    public GenericArrayList() {
        this.elementsData = new Object[10];
        this.capacity = 10;
    }

    public GenericArrayList(int capacity){
        this.elementsData = new Object[capacity];
        this.capacity = capacity;
    }

    public GenericArrayList(AbstractGenericList<? extends E> list){
        elementsData = new Object[list.size()];
        this.capacity = list.size() - 1;
        this.size = list.size();

        for (int i = 0; i < list.size(); i++) {
            elementsData[i] = list.get(i);
        }
    }

    @Override
    public void add(E element){
        ensureCapacity(this.size + 1);
        this.elementsData[this.size++] = element;
    }

    @Override
    public void add(int index, E value) {
        ensureCapacity(this.size + 1);
        System.arraycopy(this.elementsData, index, this.elementsData, index + 1, size - index);
        this.elementsData[index] = value;
        ++size;
    }

    public boolean addAll(GenericList<? extends E> values){
        for (int i = 0;i<values.size();++i){
            ensureCapacity(this.size + 1);
            add(values.get(i));
        }
        return true;
    }

    @Override
    public E get(int index) {
        rangeCheck(this.size);
        return (E)this.elementsData[index];
    }

    @Override
    public int indexOf(Object value) {
        for(int i = 0;i<size;++i){
            if (this.elementsData[i].equals(value))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        for(int i = this.size - 1;i>=0;--i){
            if (this.elementsData[i].equals(value))
                return i;
        }
        return -1;
    }

    public boolean contains(Object value) {
        return indexOf(value) >= 0;
    }

    @Override
    public E remove(int index) {
        E returnValue = (E) this.elementsData[index];
        System.arraycopy(this.elementsData, index + 1, this.elementsData, index, size - index);
        --size;
        return returnValue;
    }

    @Override
    public E remove(E value) {
        return remove(indexOf(value));
    }

    public boolean removeAll(GenericList<? extends E> values){
        for (int i = 0;i<values.size();++i){
            remove(values.get(i));
        }
        return true;
    }

    @Override
    public E set(int index, E value) {
        rangeCheck(index);
        this.elementsData[index] = value;
        return (E) this.elementsData[index];
    }

    @Override
    public void clear() {
        for (int i=0;i<this.size;++i)
            this.elementsData[i] = null;
        size = 0;
    }

    public AbstractGenericList<E> subList(int fromInclusive, int toInclusive) {
        AbstractGenericList<E> buffer = new GenericArrayList<E>((toInclusive - fromInclusive) + 1);
        for (int i=fromInclusive;i<=toInclusive;++i)
            buffer.add((E) this.elementsData[i]);
        return buffer;
    }

    public void trimToSize() {
        System.arraycopy(this.elementsData,0,this.elementsData,0,this.size);
        this.capacity = this.size;

    }

    public int getCapacity(){
        return capacity;
    }

    private void rangeCheck(int index){
        if (index < 0 || index>size){
            throw new IndexOutOfBoundsException();
        }
    }

    private void ensureCapacity(int size){
        if (size >= capacity){
            this.capacity <<= 1;
            increaseCapacity(this.capacity);
        }
    }

    private void increaseCapacity(int capacity){
        this.elementsData = Arrays.copyOf(this.elementsData,capacity);
    }
}
