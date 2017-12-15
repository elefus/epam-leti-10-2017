package main.java.com.epam.jf.kruglik.homework.task16;

import com.sun.tools.javah.Gen;

public interface GenericList<E> {
    public abstract boolean add(E value);

    public abstract boolean add(E value, int index);

    public abstract E get(int index);

    public abstract boolean contains(E value);

    public abstract boolean containsAll(GenericList<E> list);

    public abstract E remove(int index);

    public abstract E remove(E value);

    public abstract boolean removeAll(GenericList<E> list);

    public abstract E set(E value, int index);

    public abstract boolean addAll(GenericList<E> list);

    public abstract void clear();

    public abstract int size();

    public abstract boolean isEmpty();

    public abstract int indexOf(E value);

    public abstract int lastIndexOf(E value);

    public abstract GenericList<E> subList(int fromInclusive, int toInclusive);
}
