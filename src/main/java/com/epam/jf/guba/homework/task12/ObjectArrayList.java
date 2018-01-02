package com.epam.jf.guba.homework.task12;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ObjectArrayList extends AbstractObjectArrayList {

    public ObjectArrayList(){
        super();
    }

    public ObjectArrayList(int capacity){
        super(capacity);
    }

    public ObjectArrayList(AbstractObjectArrayList list){
        super(list);
    }

    @Override
    public boolean add(Object value) {
        int oldSize = size;
        if (!ensureCapacity(1)) {
            expandCapacity();
        }
        values[size] = value;
        size++;
        return size > oldSize;
    }

    @Override
    public boolean add(Object value, int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bound. Size = " + size + " Index = " + index);
        }
        int oldSize = size;
        if (!ensureCapacity(1)) {
            expandCapacity();
        }
        if (index == size) {
            values[index] = value;
        } else {
            shiftRight(index, 1);
            values[index] = value;
        }
        size++;
        return size > oldSize;
    }

    private void shiftRight(int from, int positionsAmount) {
        System.arraycopy(values, from, values, from + positionsAmount, size - from);
    }

    private void expandCapacity() {
        Object[] newVal = new Object[capacity + (capacity >> 1)];
        System.arraycopy(values, 0, newVal, 0, size);
        values = newVal;
    }

    private boolean ensureCapacity(int requestedSpace) {
        return capacity > size + requestedSpace;
    }

    @Override
    public Object get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bound. Size = " + size + " Index = " + index);
        }
        return values[index];
    }

    @Override
    public boolean contains(Object value) {
        for (Object obj : values) {
            if (obj.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(AbstractObjectArrayList list) {
        for (Object obj : list.values) {
            if (!contains(obj)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bound. Size = " + size + " Index = " + index);
        }
        Object oldVal = values[index];
        if (index != size - 1) {
            shiftLeft(index, 1);
        }
        size--;
        return oldVal;
    }

    private void shiftLeft(int from, int positionsAmount) {
        System.arraycopy(values, from + positionsAmount, values, from, size - (from + positionsAmount));
    }

    @Override
    public Object remove(Object value) {
        int index = indexOf(value);
        if (index == -1) {
            throw new NoSuchElementException();
        }
        Object oldVal = values[index];
        if (index != size - 1) {
            shiftLeft(index, 1);
        }
        size--;
        return oldVal;
    }

    @Override
    public boolean removeAll(AbstractObjectArrayList list) {
        int oldSize = size;
        for (Object obj : list.values) {
            remove(obj);
        }
        return size < oldSize;
    }

    @Override
    public Object set(Object value, int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bound. Size = " + size + " Index = " + index);
        }
        Object oldVal = values[index];
        values[index] = value;
        return oldVal;
    }

    @Override
    public boolean addAll(AbstractObjectArrayList list) {
        int oldSize = size;
        while (!ensureCapacity(list.size)) {
            expandCapacity();
        }
        System.arraycopy(list.values, 0, values, size, list.size);
        size += list.size;
        return size > oldSize;
    }

    @Override
    public void clear() {
        values = new Object[capacity];
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
    public int indexOf(Object value) {
        for(int i = 0; i < size; i++){
            if(values[i].equals(value)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        for(int i = size-1; i >= 0; i--){
            if(values[i].equals(value)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public AbstractObjectArrayList subList(int fromInclusive, int toInclusive) {
        ObjectArrayList subList = new ObjectArrayList(size);
        for(int i = fromInclusive; i <= toInclusive; i++){
            subList.add(values[i]);
        }
        return subList;
    }

    @Override
    public void trimToSize() {
        if(size < capacity){
            values = (size == 0) ? new Object[0] : Arrays.copyOf(values, size);
        }
    }
}
