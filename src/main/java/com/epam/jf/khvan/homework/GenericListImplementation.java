package task17;

/**
 * Необходимо в своем пакете создать типизированный интерфейс GenericList.
 * В нем следует определить методы, общие для различных реализаций списков.
 * @param <E> Тип элементов, хранящихся в списке.
 */
public interface GenericListImplementation<E>{

     boolean add(E value);

     boolean add(int index, E value);

     E get(int index);

     boolean contains(E value);

     boolean containsAll(GenericListImplementation<? extends E> list);

     E remove(int index);

     boolean remove(E value);

     boolean removeAll(GenericListImplementation<? extends E> list);

     E set(E value, int index);

     boolean addAll(GenericListImplementation<? extends E> list);

     void clear();

     int size();

     boolean isEmpty();

     int indexOf(E value);

     int lastIndexOf(E value);

     GenericListImplementation<E> subList(int fromInclusive, int toExclusive);
}

