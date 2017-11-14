package com.epam.jf.ilyassov.homework;
public class IntArrayList extends AbstractIntArrayList {
    public IntArrayList() {
    }

    public IntArrayList(int capacity) {
        super(capacity);
    }

    public IntArrayList(AbstractIntArrayList list) {
        super(list);
    }

    @Override
    public boolean add(int value) {
        int NewArray[]=new int[values.length+1];
        NewArray[values.length]=value;
        for (int i = 0; i < values.length; i++) {
            NewArray[i]=values[i];
        }
        values=NewArray;
        return true;
    }

    @Override
    public boolean add(int value, int index) {
        int NewArray[]=new int[values.length+1];
        NewArray[index-1]=value;
        for (int i = 0; i < index-1; i++) {
            NewArray[i]=values[i];
        }
        for (int i = index-1; i < values.length; i++) {
            NewArray[i+1]=values[i];
        }
        values=NewArray;
        return true;
    }

    @Override
    public int get(int index) {
        return values[index-1];
    }

    @Override
    public boolean contains(int value) {
        for (int i:values){
            if (i==value)
                return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(AbstractIntArrayList list) {
        if(this.size()!=list.size())
            return false;
        for (int i : list.values) {
            if(contains(i)==false){
                return false;
            }

        }
        return true;
    }

    @Override
    public int remove(int index) {
        int[] NewArray = new int[values.length-1];
        int temp=this.get(index);
        for (int i = 0; i < index - 1; i++) {
            NewArray[i]=values[i];
        }
        for (int i = index; i <values.length ; i++) {
            NewArray[i-1]=values[i];
        }
        values=NewArray;
        return temp;
    }

    @Override
    public int set(int value, int index) {
        int temp=values[index];
        values[index]=value;
        return temp;
    }

    @Override
    public boolean addAll(AbstractIntArrayList list) {
        for (int i : list.values) {
            this.add(i);
        }
        return true;
    }

    @Override
    public void clear() {
        values=new int[0];
    }

    @Override
    public int size() {
        return this.values.length;
    }

    @Override
    public boolean isEmpty() {
        return values.length == 0;
    }

    @Override
    public int indexOf(int value) {
        for (int i = 0; i <values.length ; i++) {
            if(value==values[i])
            {
                return i;
            }
        }
        return -11;
    }

    @Override
    public int lastIndexOf(int value) {
        int result=-11;
        for (int i = 0; i <values.length ; i++) {
            if(value==values[i])
            {
                result=i;
            }
        }
        return result;
    }

    @Override
    public AbstractIntArrayList subList(int fromInclusive, int toInclusive) {
        IntArrayList intArrayList = new IntArrayList(toInclusive-fromInclusive+1);
        int j=fromInclusive;
        for (int i = 0; i <intArrayList.values.length; i++) {
            intArrayList.values[i]=this.values[j];
            j++;
        }
        return intArrayList;
    }
}
