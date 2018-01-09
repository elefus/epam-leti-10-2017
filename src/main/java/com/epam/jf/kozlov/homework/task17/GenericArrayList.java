package com.epam.jf.kozlov.homework.task17;

import com.epam.jf.kozlov.homework.task16.GenericList;

import java.util.Arrays;

/**
 * Реализация динамически расширяемого списка на основе массива.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public class GenericArrayList<E> extends AbstractGenericList<E> {

    private Object[] elementData;

    public GenericArrayList() {
        elementData = new Object[10];
    }

    public GenericArrayList(int size) {
        elementData = new Object[size];
    }

    public GenericArrayList(GenericList<? extends E> fromList) {
        this(fromList.size());
        for (int i = 0; i < fromList.size(); i++) {
            this.add(fromList.get(i));
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) elementData[index];
    }

    @Override
    @SuppressWarnings("unchecked")
    public E set(int index, E e) {
        if (index < 0 || index >= size) {
            return null;
        }
        Object oldObject = elementData[index];
        elementData[index] = e;
        return (E) oldObject;
    }

    @Override
    public boolean add(E e) {
        ensureCapacity(size + 1);
        elementData[size++] = e;
        return true;
    }

    @Override
    public boolean add(E e, int index) {
        if (index < 0 || index > size) {
            return false;
        }
        ensureCapacity(size + 1);
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = e;
        size++;
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Object olde = elementData[index];

        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null; // clear to let GC do its work
        return (E) olde;
    }

    @Override
    public E remove(E e) {
        return remove(indexOf(e));
    }

    @Override
    public boolean removeAll(E e) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(e)) {
                remove(i);
            }
        }
        return true;
    }

    @Override
    public boolean removeAll(GenericList<? extends E> fromList) {
        for (int i = 0; i < fromList.size(); i++) {
            int index = indexOf(fromList.get(i));
            if (index != -1) {
                remove(index);
            }
        }
        return true;
    }

    @Override
    public boolean addAll(GenericList<? extends E> fromList) {
        for (int i = 0; i < fromList.size(); i++) {
            add(fromList.get(i));
        }
        return true;
    }

    @Override
    public void clear() {
        size = 0;
        elementData = new Object[10];
    }

    @Override
    public int indexOf(E e) {
        if (e == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (e.equals(elementData[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E e) {
        if (e == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (e.equals(elementData[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public GenericArrayList<E> sublist(int fromIndex, int toIndex) {
        if (fromIndex < 0 || fromIndex >= size) {
            fromIndex = 0;
        }
        if (toIndex >= size || toIndex < 0) {
            toIndex = size - 1;
        }
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException();
        }
        GenericArrayList<E> list = new GenericArrayList<>(toIndex - fromIndex + 1);
        list.size = toIndex - fromIndex + 1;
        System.arraycopy(elementData, fromIndex,list.elementData,0,list.size());
        return list;
    }

    private void ensureCapacity(int minCapacity) {
        int newCapacity = elementData.length * 2;
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        if (elementData.length < minCapacity) {
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    public void trimToSize() {
        if (size < elementData.length) {
            elementData = Arrays.copyOf(elementData, size);
        }
    }
}
