package com.epam.jf.ilyassov.homework;


/**
 * Реализация динамически расширяемого списка на основе массива.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public class GenericArrayList<E> extends AbstractGenericList<E> {

    public Object array[];

    public GenericArrayList() {

        array=new Object[5];
        size=0;
    }

    public void ensureCapacity(int n){
        if(n>array.length){
            Object temp[]=new Object[2*array.length];
            System.arraycopy(array,0,temp,0,size());
            array=temp;

        }
    }


    public GenericArrayList(int Capacity) {
        array=new Object[Capacity];
    }

    public GenericArrayList(GenericArrayList<? extends E> anotherList) {
        this();
        for (int i = 0; i < anotherList.size(); i++) {
            add(anotherList.get(i));
        }
    }

    @Override
    public boolean add(E value) {
        ensureCapacity(size+1);
        array[size]=value;
        size++;
        return true;
    }

    @Override
    public boolean add(E value, int index) {
        CheckIndex(index);
        ensureCapacity(size()+1);
        size++;
        System.arraycopy(array,index+1,array,index,size()-index);
        array[index]=value;
        return true;
    }

    @Override
    public E get(int index) {
        CheckIndex(index);
        return (E)array[index];
    }

    @Override
    public E set(int index, E value) {
        CheckIndex(index);
        E temp=get(index);
        array[index]=value;
        return temp;
    }

    @Override
    public E remove(int index) {
        CheckIndex(index);
        E temp=get(index);
        System.arraycopy(array,index+1,array,index,size()-index-1);
        size--;
        return temp;
    }

    @Override
    public void clear() {
        size=0;
        array=new Object[5];
    }

    @Override
    public GenericList<E> sublist(int fromIndex, int toIndex) {
        CheckIndex(toIndex);
        CheckIndex(fromIndex);
        GenericList<E> genericList=new GenericArrayList<>(toIndex-fromIndex+1);
        for (int i = fromIndex; i < toIndex+1; i++) {
            genericList.add(get(i));
        }
        return genericList;
    }
}
