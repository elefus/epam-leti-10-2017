package com.epam.jf.guba.homework.task17;


import com.epam.jf.guba.homework.GenericList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Реализация динамически расширяемого списка на основе массива.
 *
 * @param <E> Тип элементов, хранящихся в списке.
 */
public class GenericArrayList<E> extends AbstractGenericList<E> {

    private Object[] values;
    private int size;
    private static final int DEFFAULT_SIZE = 10;


    public GenericArrayList() {
        values = new Object[DEFFAULT_SIZE];
    }

    public GenericArrayList(int capacity) {
        if (capacity > 0) {
            values = new Object[capacity];
        } else if (capacity == 0) {
            values = new Object[0];
        } else {
            throw new IllegalArgumentException("Argument is less than zero");
        }
    }

    public GenericArrayList(GenericArrayList<? extends E> list) {
        values = list.toArray();
        size = values.length;
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
    public boolean contains(Object element) {
        return indexOf(element) >= 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(values, size);
    }

    @Override
    public void add(E element) {
        add(size, element);
    }

    @Override
    public void add(int index, E element) {
        checkBoarders(index);
        expandIfNeed(1);
        if (index != size) {
            shiftRight(1);
        }
        values[index] = element;
        size++;
    }

    @Override
    public boolean remove(Object element) {
        if(element == null){
            for(int i = 0; i < size; i++){
                if(values[i] == null){
                    remove(i);
                    return true;
                }
            }
        }else {
            for(int i = 0; i < size; i++){
                if(element.equals(values[i])){
                    remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public E remove(int index) {
        checkBoarders(index);
        E old = (E) values[index];
        shiftLeft(index, 1);
        return old;
    }

    @Override
    public boolean removeAll(GenericList<? extends E> list) {
        int oldSize = size;
        for(int i = 0; i < list.size(); i++){
            remove(list.get(i));
        }
        return size < oldSize;
    }

    @Override
    public boolean containsAll(GenericList<? extends E> collection) {
        if (collection.size() > size) {
            return false;
        }
        for (int i = 0; i < collection.size(); i++) {
            if (!contains(collection.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(GenericList<? extends E> elements) {
        return addAll(size, elements);
    }

    @Override
    public boolean addAll(int index, GenericList<? extends E> elements) {
        checkBoarders(index);
        if (elements.isEmpty()) {
            return false;
        }
        int otherSize = elements.size();
        expandIfNeed(otherSize);
        if (index != size) {
            shiftRight(otherSize);
        }
        for (int i = 0; i < otherSize; i++) {
            values[index + i] = elements.get(i);
        }
        size += otherSize;
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            values[i] = null;
        }
        size = 0;
    }

    @Override
    public E get(int index) {
        checkBoarders(index);
        return (E) values[index];
    }

    @Override
    public E set(int index, E element) {
        checkBoarders(index);
        E old = (E) values[index];
        values[index] = element;
        return old;
    }

    @Override
    public int indexOf(Object element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (values[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(values[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object element) {
        if (element == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (values[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (element.equals(values[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public GenericList<E> sublist(int fromIndex, int toIndex) {
        checkBoarders(fromIndex);
        checkBoarders(toIndex);
        Object[] sub = Arrays.copyOfRange(values, fromIndex, toIndex);
        GenericArrayList<E> newList = new GenericArrayList<>();
        for (Object obj : sub) {
            newList.add((E) obj);
        }
        return newList;
    }

    @Override
    public void sort(Comparator<? super E> list) {
        Arrays.sort((E[]) values, 0, size, list);
    }


    private class Itr implements Iterator<E> {

        int cursor;

        int lastRet = -1;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public E next() {
            int i = cursor;
            if (i >= size) {
                throw new NoSuchElementException();
            }
            cursor = i + 1;
            return (E) GenericArrayList.this.values[lastRet = i];
        }

        @Override
        public void remove() {
            if (lastRet < 0) {
                throw new IllegalStateException();
            }
            try {
                GenericArrayList.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
            } catch (IndexOutOfBoundsException ex) {
                throw new IllegalStateException();
            }
        }



    }
    private void expandIfNeed(int addition) {
        if (values.length < size + addition) {
            Object[] newVal = new Object[values.length + (values.length >> 1)];
            System.arraycopy(values, 0, newVal, 0, size);
            values = newVal;
        }
    }

    private void checkBoarders(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        }
    }

    private void shiftRight(int positions) {
        System.arraycopy(values, positions, values, positions + 1, size - positions);
    }

    private void shiftLeft(int position, int amount) {
        int absAmount = size - position - amount;
        System.arraycopy(values, position+amount, values, position ,absAmount);
        for(int i = 0; i < amount; i++){
            values[size - i - 1] = null;
            size--;
        }
    }
}
