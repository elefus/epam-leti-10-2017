package com.epam.jf.ilyassov.homework;

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
        ensureCappacity(size+1);
        this.values[size]=value;
        size++;
        return true;
    }

    @Override
    public boolean add(Object value, int index) {
        ensureCappacity(size+1);
        System.arraycopy(values,index,values,index+1,size-index);
        this.values[index]=value;
        size++;
        return true;
    }

    @Override
    public Object get(int index) {
        return this.values[index];
    }

    @Override
    public boolean contains(Object value) {
        for (int i = 0; i < this.size(); i++) {
            if(this.values[i].equals(value))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(AbstractObjectArrayList list) {
        if(this.size()!=list.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if(!contains(list.values[i]))
                return false;
        }
        return true;
    }

    @Override
    public Object remove(int index) {
        Object temp=get(index);
        System.arraycopy(values,index+1,values,index,size()-index);
        size--;
        return temp;
    }

    @Override
    public Object remove(Object value) {
        for(int i=0;i<size();++i){
            if(values[i].equals(value))
            {
                return remove(i);
            }
        }
        return "object is not fined";
    }

    @Override
    public boolean removeAll(AbstractObjectArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            remove(list.values[i]);
        }
        return true;
    }

    @Override
    public Object set(Object value, int index) {
        this.values[index]=value;
        return this.get(index);
    }

    @Override
    public boolean addAll(AbstractObjectArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            add(list.values[i]);
        }
        return true;
    }

    @Override
    public void clear() {
        values=new Object[10];
        size=10;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public int indexOf(Object value) {
        for (int i = 0; i < this.size(); i++) {
            if(this.values[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        int lastIndexof=-1;
        for (int i = 0; i < this.size(); i++) {
            if(this.values[i].equals(value))
            {
                lastIndexof = i;
            }
        }
        return lastIndexof;
    }

    @Override
    public AbstractObjectArrayList subList(int fromInclusive, int toInclusive) {
        AbstractObjectArrayList list = new ObjectArrayList(toInclusive-fromInclusive+1);
        list.size=toInclusive-fromInclusive+1;
        System.arraycopy(values,fromInclusive,list.values,0,list.size());

        return list;
    }

    @Override
    public void trimToSize() {
        Object[] objects= new Object[size];
        System.arraycopy(values,0,objects,0,size);
        values=objects;
    }


}
