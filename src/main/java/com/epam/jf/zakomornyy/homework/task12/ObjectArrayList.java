package com.epam.jf.zakomornyy.homework.task12;


public class ObjectArrayList extends AbstractObjectArrayList {

    public ObjectArrayList() {
        super();
    }

    public ObjectArrayList(int capacity) {
        super(capacity);
    }

    public ObjectArrayList(AbstractObjectArrayList list) {
        super(list);
    }

    @Override
    public boolean add(Object value) {
        Object[] buffArray = new Object[this.size() + 1];
        System.arraycopy(this.values, 0, buffArray, 0, this.size());
        buffArray[this.size()] = value;
        this.values = buffArray;
        return true;

    }

    @Override
    public boolean add(Object value, int index) {
        Object[] buffArray = new Object[this.size() + 1];
        System.arraycopy(this.values, 0, buffArray, 0, index);
        System.arraycopy(this.values, index, buffArray, index + 1, buffArray.length - index - 1);
        buffArray[index] = value;
        this.values = buffArray;
        return true;
    }

    @Override
    public Object get(int index) {
        return values[index];
    }

    @Override
    public boolean contains(Object value) {
        for (Object val : this.values) {
            if(val != null) {
                if (val.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(AbstractObjectArrayList list) {
        int numOfCoincidences = 0;
        for (Object value: list.values) {
            if(value != null) {
                for (Object val : this.values) {
                    if (val != null) {
                        if (val.equals(value)) {
                            numOfCoincidences++;
                            break;
                        }
                    }
                }
            }
        }
        return numOfCoincidences == list.size();
    }

    @Override
    public Object remove(int index) {
        Object value = this.values[index];
        Object[] buffArray = new Object[this.size() - 1];
        System.arraycopy(this.values, 0, buffArray, 0, index);
        System.arraycopy(this.values, index + 1, buffArray, index, buffArray.length - index);
        this.values = buffArray;
        return value;
    }

    @Override
    public Object remove(Object value) {
        Object o = null;
        for(int i = 0; i < this.size(); i++) {
            if(this.get(i).equals(value)) {
                o = this.get(i);
                this.remove(i);
                i--;

            }
        }
        return o;
    }

    @Override
    public boolean removeAll(AbstractObjectArrayList list) {
        int size = this.size();
        for(Object o : list.values) {
            this.remove(o);
        }
        return this.size() < size;
    }

    @Override
    public Object set(Object value, int index) {
        Object o = this.values[index];
        this.values[index] = value;
        return o;

    }

    @Override
    public boolean addAll(AbstractObjectArrayList list) {
        Object[] buffArray = new Object[this.size() + list.size()];
        System.arraycopy(this.values, 0, buffArray, 0, this.size());
        System.arraycopy(list.values, 0, buffArray, this.size(), list.size());
        this.values = buffArray;
        return true;
    }

    @Override
    public void clear() {
        this.values = new Object[0];
    }

    @Override
    public int size() {
        return this.values.length;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public int indexOf(Object value) {
        for(int i = 0; i < this.size(); i++) {
            if(this.values[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        for(int i = this.size() - 1; i >= 0; i--) {
            if(this.values[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public AbstractObjectArrayList subList(int fromInclusive, int toInclusive) {
        ObjectArrayList objectArrayListrrayList = new ObjectArrayList(toInclusive - fromInclusive + 1);
        System.arraycopy(this.values, fromInclusive,
                objectArrayListrrayList.values, 0,
                objectArrayListrrayList.size());
        return objectArrayListrrayList;
    }

    @Override
    public void trimToSize() {
        for (int i = 0; i < this.size(); i++) {
            if(values[i] == null) {
                this.remove(i);
                i--;
            }
        }
    }
}
