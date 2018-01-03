package com.epam.jf.burachenko.homework.task17;

import com.epam.jf.burachenko.homework.task16.GenericList;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Базовая реализация интерфейса {@link GenericList}.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public abstract class AbstractGenericList<E> implements GenericList<E> {
    protected int size;

    public AbstractGenericList() {}

    public AbstractGenericList(GenericList<? extends E> c) {
        addAll(c);
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
    public boolean remove(@NotNull E value) {
        for(int index = indexOf(value); index != -1; index = indexOf(value)) {
            remove(index);
        }
        return true;
    }

    @Override
    public boolean addAll(@NotNull GenericList<? extends E> list) {
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }
        return true;
    }

    @Override
    public boolean removeAll(@NotNull GenericList<? extends E> list) {
        for (int i = 0; i < list.size(); i++) {
            remove(list.get(i));
        }
        return true;
    }

    @Override
    public boolean contains(@NotNull E value) {
        return indexOf(value) != -1;
    }

    @Override
    public boolean containsAll(@NotNull GenericList<? extends E> list) {
        for (int i = 0; i < list.size(); i++) {
            if(!contains(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void sort(@NotNull Comparator<? super E> c) {
        Object[] array = toArray();
        Arrays.sort((E[]) array, c);
        for (int i = 0; i < size; i++) {
            set((E) array[i], i);
        }
    }
}
