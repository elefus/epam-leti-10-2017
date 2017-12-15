package com.epam.jf.Guyo.homework;

public class IntArrayList extends AbstractIntArrayList {

    public IntArrayList(){
        super();
    }

    public IntArrayList(int capacity){
        super(capacity);
    }

    public IntArrayList(AbstractIntArrayList list){
        super(list);
    }

    @Override
    public  boolean add(int value){
        int[] newValues = new int[this.size() + 1];
        System.arraycopy(values, 0, newValues, 0, this.size());
        values = newValues;
        values[newValues.length-1] = value;
        return true;
    }

    @Override
    public  boolean add(int value, int index){
        int[] newValues = new int[this.size() + 1];
        System.arraycopy(values,0, newValues, 0, index);
        System.arraycopy(values, index, newValues, index+1, this.size() - index);
        newValues[index] = value;
        values = newValues;
        return true;
    }

    @Override
    public  int get(int index){
        return values[index];
    }

    @Override
    public  boolean contains(int value){
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i) == value){
                return true;
            }
        }
        return false;
    }

    @Override
    public  boolean containsAll(AbstractIntArrayList list){
        int count = 0;
        if (this.size() < list.size()){
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < this.size(); j++) {
                if (list.values[i] == this.values[j]){
                    count++;
                }
            }
        }
        return count == list.size();
    }

    @Override
    public  int remove(int index){
        int tempValue = values[index];
        int[] newValues = new int[this.size() - 1];
        System.arraycopy(values,0, newValues, 0, index);
        System.arraycopy(values, index + 1, newValues, index, this.size() - index - 1);
        values = newValues;
        return tempValue;
    }

    @Override
    public  int set(int value, int index){
        int tempValue = values[index];
        values[index] = value;
        return tempValue;
    }

    @Override
    public  boolean addAll(AbstractIntArrayList list){
        int[] newValues = new int[this.size() + list.size()];
        System.arraycopy(values,0, newValues, 0, this.size());
        for (int i = 0; i < list.size(); i++) {
            newValues[this.size()+ i] = list.get(i);
        }
        values = newValues;
        return true;
    }

    @Override
    public  void clear(){
        values = new int[0];
    }

    @Override
    public  int size(){
        return values.length;
    }

    @Override
    public  boolean isEmpty(){
        return this.size() == 0;
    }

    @Override
    public  int indexOf(int value){
        for (int i = 0; i < this.size(); i++) {
            if (value == this.get(i)) {
                return i;
            }

        }
        return -1;
    }

    @Override
    public  int lastIndexOf(int value){
        for (int i = this.size() - 1; i >= 0 ; i--) {
            if (value == this.get(i)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public  AbstractIntArrayList subList(int fromInclusive, int toInclusive){
        AbstractIntArrayList newList = new IntArrayList(toInclusive - fromInclusive + 1);
        System.arraycopy(this.values, fromInclusive, newList.values, 0, newList.size());
        return newList;
    }
}
