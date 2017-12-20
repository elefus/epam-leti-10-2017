package task17;

public abstract class AbstractGenericClassImplement<E> implements GenericListImplementation<E> {
    protected int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean add(E elem) {
        add( elem,size - 1);
        return true;
    }

    @Override
    public boolean containsAll(GenericListImplementation<? extends E> list) {
        for (int i = 0; i < list.size(); i++) {
            if (!contains(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean removeAll(GenericListImplementation<? extends E> list) {
        for (int i = 0; i < list.size(); i++) {
            remove(list.get(i));
        }
        return true;
    }


    @Override
    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (get(i).equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E element) {
        for (int i = size - 1; i >= 0; i--) {
            if (get(i).equals(element)) {
                return i;
            }
        }
        return -1;
    }

}

