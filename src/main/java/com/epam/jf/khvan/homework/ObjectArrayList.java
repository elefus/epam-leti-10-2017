package com.epam.jf.khvan.homework;

import java.util.Objects;

public class ObjectArrayList extends AbstractObjectArrayList {

    public ObjectArrayList() {
        super();
    }

    public ObjectArrayList(int capacity) {
        super(capacity);
    }

    public ObjectArrayList(ObjectArrayList list) {
        super(list);
        size = list.size;
    }

    @Override
    public boolean add(Object value) {
        size++;
        checkCapacityOfArray(size);
        values[size - 1] = value;
        return true;
    }

    @Override
    public boolean add(Object value, int index) {
        if (index < 0 || index >= size){
            return false;}
        size++;
        checkCapacityOfArray(size);
        Object [] temp = values;
        values[index] = value;
        System.arraycopy( temp, index , values,index + 1, size - index - 1);
        return true;
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        return values[index];
    }

    @Override
    public boolean contains(Object value) {
        for (Object value1 : values) {
            if (Objects.equals(value1 ,value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(AbstractObjectArrayList list) {
        boolean flag = true;
        for (int i = 0; i < list.size(); i++) {
            if ( this.contains( list.get(i))){
                flag = true;
            } else {
                return false;
            }
        }
        return flag;
    }

    @Override
    public Object remove(int index) {
        Object [] temp = values;
        Object removedObj = values[index];
        System.arraycopy(temp ,index + 1 , values, index,size - index - 1);
        values[size] = null;
        size--;
        return removedObj;
    }

    @Override
    public Object remove(Object value) {
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
    public boolean removeAll(AbstractObjectArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            if ( indexOf(list.values[i]) != -1){
               remove(indexOf(list.values[i]));
            }
        }
        return true;
    }

    @Override
    public Object set(Object value, int index) {
        Object oldValue = values[index];
        values[index] = value;
        return oldValue;
    }

    @Override
    public boolean addAll(AbstractObjectArrayList list) {
        checkCapacityOfArray(list.size() + size);
        System.arraycopy( list.values,0, values, size, list.size());
        size = size + list.size();
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
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int indexOf(Object value) {
        if (value == null) {
            for (int i = 0; i < size; i++)
                if (values[i] == null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (value.equals(values[i]))
                    return i;
        }
        return -1;

    }

    @Override
    public int lastIndexOf(Object value) {
        if (value == null) {
            for (int i = size-1; i >= 0; i--)
                if (values[i] == null)
                    return i;
        } else {
            for (int i = size-1; i >= 0; i--)
                if (value.equals(values[i]))
                    return i;
        }
        return -1;
    }

    @Override
    public AbstractObjectArrayList subList(int fromInclusive, int toInclusive) {
        subListRangeCheck(fromInclusive, toInclusive, size);
        return new Sublist(this, 0, fromInclusive, toInclusive);
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

    public void trimToSize() {
         if ( size < values.length){
             Object [] temp = values;
             values = new Object[size];
             System.arraycopy( temp, 0, values, 0, size);
         }
    }

    private void checkCapacityOfArray(int size ) {
        if ( size > values.length){
            Object [] temp = values;
            int capacity = size;
            while (capacity < values.length){
                capacity = (int) (values.length * 1.5 + 1);
            }
            values = new Object[capacity];
            System.arraycopy(temp,0, values, 0, size);
        }
    }

    private void checkIndex(int index){
        if ( index < 0 || index > size - 1 ){
            throw new IndexOutOfBoundsException();
        }
    }

    private class Sublist extends AbstractObjectArrayList{
        AbstractObjectArrayList parent;
        int size;
        int offset;
        int fromIndex;
        int toIndex;

        public Sublist (AbstractObjectArrayList parent, int fromIndex, int toIndex, int offset) {
            super();
            size = toIndex - fromIndex;
            this.parent = parent;
            this.offset = offset + fromIndex;
            this.fromIndex = fromIndex;
            this.toIndex = toIndex;
        }

        @Override
        public boolean add(Object value) {
            parent.add( value, offset + size);
            this.size++;
            return true;
        }

        @Override
        public boolean add(Object value, int index) {
            parent.add( value, offset + index);
            this.size++;
            return true;
        }

        @Override
        public Object get(int index) {
            return parent.values[offset + index];
        }

        @Override
        public boolean contains(Object value) {
            for(int i = fromIndex; i < toIndex; i++){
                if ( Objects.equals(parent.values[i] ,value)){
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean containsAll(AbstractObjectArrayList list) {
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
        public Object remove(int index) {
            Object result = parent.remove(offset + index);
            size--;
            return result;
        }

        @Override
        public Object remove(Object value) {
            return null;
        }

        @Override
        public boolean removeAll(AbstractObjectArrayList list) {
            return false;
        }

        @Override
        public Object set(Object value, int index) {
            Object oldValue = parent.get(offset + index);
            parent.values[offset + index] = value;
            return oldValue;
        }

        @Override
        public boolean addAll(AbstractObjectArrayList list) {
            checkCapacityOfArray(list.size() + parent.size);
            System.arraycopy( parent.values , toIndex + 1, parent.values, toIndex + list.size() + 1, parent.size - toIndex - 1 );
            System.arraycopy( list.values,0, parent.values, toIndex, list.size());
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
        public int size() {
            return size;
        }

        @Override
        public boolean isEmpty() {
            return size == 0;
        }

        @Override
        public int indexOf(Object value) {
            for ( int i = fromIndex; i < toIndex; i++){
                if ( Objects.equals(parent.values[i] ,value)){
                    return i;
                }
            }
            return -1;
        }

        @Override
        public int lastIndexOf(Object value) {
            for ( int i = toIndex - 1; i >= fromIndex; i--){
                if ( Objects.equals(parent.values[i] ,value)){
                    return i;
                }
            }
            return -1;
        }

        @Override
        public AbstractObjectArrayList subList(int fromInclusive, int toInclusive) {
            subListRangeCheck(fromInclusive, toInclusive, size);
            return new Sublist(this, 0, fromInclusive, toInclusive);
        }
    }
}

