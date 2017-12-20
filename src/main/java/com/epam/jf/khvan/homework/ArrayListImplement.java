package task17;

import java.util.Objects;

public class ArrayListImplement<E> extends AbstractGenericClassImplement<E>{
    private E[] values;

    public ArrayListImplement() {
        values = (E[]) (new Object[10]);
    }

    public ArrayListImplement(int capacity) {
        if (capacity > 0) {
            values = (E[]) (new Object[capacity]);
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
    }

    public ArrayListImplement(GenericListImplementation<? extends E> list) {
        size = list.size();
        values = (E[]) new Object[size];
        for (int i = 0; i < size; i++) {
            values[i] =  list.get(i);
        }
    }

    @Override
    public boolean add(E value) {
        size++;
        checkCapacityOfArray(size);
        values[size - 1] = value;
        return true;
    }

    @Override
    public boolean add(E value, int index) {
        ++size;
        Object [] temp = values;
        if (index < 0 || index >= size){
            return false;}

        checkCapacityOfArray(size);

        System.arraycopy( temp, index , values,index + 1, size - index - 1);
        values[index] = value;

        return true;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return values[index];
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) != -1;
    }

    @Override
    public boolean containsAll(GenericListImplementation<? extends E> list) {
        for (int i = 0; i < list.size(); i++) {
            if ( this.contains( list.get(i))){
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public E remove(int index) {
        Object removedObj = values[index];
        System.arraycopy(values ,index + 1 , values, index,size - index - 1);
        values[size - 1] = null;
        size--;
        return (E) removedObj;

    }

    @Override
    public boolean remove(E value) {
        if (value == null) {
            for (int index = 0; index < size; index++)
                if (values[index] == null) {
                    remove(index);
                    return true;
                }
        } else {
            for (int index = 0; index < size; index++)
                if (value.equals(values[index])) {
                    remove(index);
                    return true;
                }
        }
        return false;
    }

    @Override
    public boolean removeAll(GenericListImplementation< ? extends E> list){
        for (int i = 0; i < list.size(); i++) {
            if ( indexOf(list.get(i)) != -1){
                remove(indexOf(list.get(i)));
            }
        }
        return true;
    }

    @Override
    public E set(E value, int index) {
        Object oldValue = values[index];
        values[index] = value;
        return (E) oldValue;
    }

    @Override
    public boolean addAll(GenericListImplementation<? extends E> list) {
        for (int i = 0; i < list.size(); i++) {
            values[size + i] = list.get(i);
        }
        size += list.size();
        return true;
    }



    @Override
    public void clear() {
        for (int i = 0; i < size ; i++) {
            values[i] = null;
        }
        size = 0;
    }


    @Override
    public int indexOf(E value) {
        if (value == null) {
            for (int i = 0; i < size; i++)
                if (values[i] == null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (Objects.equals(value, values[i]))
                    return i;
        }
        return -1;

    }

    public Object[] toArray() {
        Object[] object = new Object[size];
        for (int i = 0; i < size; i++) {
            object[i] = get(i);
        }
        return object;
    }

    @Override
    public int lastIndexOf(E value) {
        if (value == null) {
            for (int i = size-1; i >= 0; i--)
                if (values[i] == null)
                    return i;
        } else {
            for (int i = size-1; i >= 0; i--)
                if (Objects.equals(value, values[i]))
                    return i;
        }
        return -1;
    }

    public void trimToSize() {
        if ( size < values.length){
            values = (E[]) new Object[size];
            Object [] temp = values;
            System.arraycopy( temp, 0, values, 0, size);
        }
    }



    public ArrayListImplement<E> subList(int fromInclusive, int toInclusive) {
        subListRangeCheck(fromInclusive, toInclusive, size);
        return new Sublist(this,  fromInclusive, toInclusive);
    }


    static void subListRangeCheck(int fromIndex, int toIndex, int size) {
        if (fromIndex < 0)
            throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
        if (toIndex > size)
            throw new IndexOutOfBoundsException("toIndex = " + toIndex);
        if (fromIndex > toIndex)
            throw new IllegalArgumentException("fromIndex(" + fromIndex +
                    ") > toIndex(" + toIndex + ")");
    }

    private void checkCapacityOfArray(int size ) {
        if ( size >= values.length){
            Object [] temp = values;
            int capacity = size;
            while (capacity < values.length){
                capacity = (int) (values.length * 1.5 + 1);
            }
            values = (E[]) new Object[capacity];
            System.arraycopy( temp,0, values, 0, temp.length);

        }
    }

    private void checkIndex(int index){
        if ( index < 0 && index > size - 1 ){
            throw new IndexOutOfBoundsException();
        }
    }


    private class Sublist extends ArrayListImplement<E>{
        ArrayListImplement<E> parent;
         int size;
        int offset;
        int fromIndex;
        int toIndex;

        public Sublist (ArrayListImplement<E> parent, int fromIndex, int toIndex) {
            size =  toIndex - fromIndex;
            this.parent = parent;
            this.offset =  fromIndex;
            this.fromIndex = fromIndex;
            this.toIndex = toIndex;
        }

        @Override
        public int size() {
            return size;
        }

        @Override
        public boolean add(E value) {
            parent.add( value, offset + size);
            this.size++;
            return true;
        }

        @Override
        public boolean add(E value, int index) {
            parent.add( value, offset + index);
            this.size++;
            return true;
        }

        @Override
        public E get(int index) {
            if (index > size - 1){throw new ArrayIndexOutOfBoundsException();}
            return parent.values[offset + index];
        }

        @Override
        public boolean contains(E value) {
            for(int i = fromIndex; i < toIndex; i++){
                if ( Objects.equals(parent.values[i] ,value)){
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean containsAll(GenericListImplementation<? extends E> list) {
            boolean flag = true;
            for (int i = 0; i < list.size(); i++){
                if ( this.contains( list.get(i))){
                    flag = true;
                } else {
                    return false;
                }
            }
            return flag;
        }

        @Override
        public E remove(int index) {
            Object result = parent.remove(offset + index);
            size--;
            return (E) result;
        }


        @Override
        public boolean removeAll(GenericListImplementation<? extends E> list) {
            return false;
        }

        @Override
        public E set(E value, int index) {
            Object oldValue = parent.get(offset + index);
            parent.values[offset + index] = value;
            return (E) oldValue;
        }

        @Override
        public boolean addAll(GenericListImplementation<? extends E> list) {
            checkCapacityOfArray(list.size() + parent.size);
            for (int i = 0; i < list.size(); i++) {
                add(list.get(i));
            }
            size = size + list.size();
            parent.size = parent.size + list.size();
            return true;
        }





        @Override
        public void clear() {
            if( fromIndex < toIndex) {
                for (int i = fromIndex; i < toIndex ; i++) {
                    values[i] = null;
                }
                size = 0;
                System.arraycopy(parent.values, fromIndex, parent.values, toIndex, size - ( toIndex - fromIndex ) );
                parent.size = parent.size - (toIndex - fromIndex);
            }
        }

        @Override
        public int indexOf(E value) {
            for ( int i = fromIndex; i < toIndex; i++){
                if ( Objects.equals(parent.values[i] ,value)){
                    return i;
                }
            }
            return -1;
        }

        @Override
        public int lastIndexOf(E value) {
            for ( int i = toIndex - 1; i >= fromIndex; i--){
                if ( Objects.equals(parent.values[i] ,value)){
                    return i;
                }
            }
            return -1;
        }

        @Override
        public ArrayListImplement<E> subList(int fromInclusive, int toInclusive) {
            subListRangeCheck(fromInclusive, toInclusive, size);
            return new Sublist(this, fromInclusive, toInclusive);
        }

        @Override
        public Object[] toArray() {
            Object[] object = new Object[size];
            for (int i = 0; i < size; i++) {
                object[i] = get(i);
            }
            return object;
        }
    }
}

