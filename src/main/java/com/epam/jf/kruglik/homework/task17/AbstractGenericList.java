package com.epam.jf.kruglik.homework.task17;

/**
 * Базовая реализация интерфейса {@link GenericList}.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public abstract class AbstractGenericList<E> implements GenericList<E> {
    int size = 0;

    @Override
    public int size(){
        return this.size;
    }

    @Override
    public boolean isEmpty(){
        return size > 0;
    }
}
