package com.epam.jf.kozlov.homework.task16;

/**
 * Необходимо в своем пакете создать типизированный интерфейс GenericList.
 * В нем следует определить методы, общие для различных реализаций списков.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public interface GenericList<E> {
    
    boolean isEmpty();
    
    int size();
    
    boolean contains(E e);
    
    boolean containsAll(GenericList<? extends E> anotherList);

    E get(int index);

    E set(int index,E e);

    boolean add(E e);

    boolean add(E e,int index);

    E remove(int index);
   
    E remove(E e);
   
    boolean removeAll(E e);
    
    boolean removeAll(GenericList<? extends E> anotherList);
    
    boolean addAll(GenericList<? extends E> anotherList);
    
    void clear();
    
    int indexOf(E e);
    
    int lastIndexOf(E e);
    
    GenericList<E> sublist(int fromIndex,int toIndex);
}