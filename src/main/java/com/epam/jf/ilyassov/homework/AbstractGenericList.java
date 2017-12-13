package com.epam.jf.ilyassov.homework;


public abstract class AbstractGenericList<E> implements GenericList<E> {

    protected int size=0;

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value)!=-1;
    }

    @Override
    public boolean containsAll(GenericList<? extends E> anotherList) {
        if(size()!=anotherList.size())
            return false;
        for (int i = 0; i < size(); i++) {
            if(!contains(anotherList.get(i)))
                return false;
        }
        return true;
    }


    @Override
    public E remove(E value) {
        for (int i = 0; i < size(); i++) {
            if(contains(value)){
                return remove(i);
            }
        }
        throw new IllegalArgumentException("Value is not found");
    }

    @Override
    public boolean removeAll(E value) {

        for (int i = 0; i < size(); i++) {
            if(contains(value)){
                remove(indexOf(value));

            }

        }
        return true;
    }

    @Override
    public boolean removeAll(GenericList<? extends E> anotherList) {
        for (int i = 0; i < anotherList.size(); i++) {
            remove(anotherList.get(i));
        }
        return true;
    }

    @Override
    public boolean addAll(GenericList<? extends E> anotherList) {
        for (int i = 0; i < anotherList.size(); i++) {
            add(anotherList.get(i));
        }
        return true;
    }



    @Override
    public int indexOf(E value) {
        for (int i = 0; i < size(); i++) {
            if(get(i).equals(value))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E value) {
        for (int i = size()-1; i >-1; i--) {
            if(get(i).equals(value))
                return i;
        }
        return -1;
    }


    protected void CheckIndex(int i)
    {
        if(i>=size()||i<0)
            throw new IndexOutOfBoundsException();

    }

}
