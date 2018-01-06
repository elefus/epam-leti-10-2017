package com.epam.jf.guba.homework.task17;


import com.epam.jf.guba.homework.GenericList;

/**
 * Базовая реализация интерфейса {@link GenericList}.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public abstract class AbstractGenericList<E> implements GenericList<E> {

    protected final static int DEFAULT_SIZE = 10;
    protected int size;

}
