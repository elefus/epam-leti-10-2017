package com.epam.jf.burachenko.homework.task7;

import com.sun.istack.internal.NotNull;

class IntArrayList extends AbstractIntArrayList {
    public IntArrayList() {
        super();
    }

    public IntArrayList(int capacity) {
        super(capacity);
    }

    public IntArrayList(AbstractIntArrayList list) {
        super(list);
    }

    @Override
    public boolean add(int value) {
        try{
            int[] newValues = new int[size()+1];
            for(int i = 0; i < size(); i++) {
                newValues[i] = values[i];
            }
            newValues[newValues.length-1] = value;
            values = newValues;
            return true;
        }
        catch (Throwable t) {
            t.getMessage();
            return false;
        }
    }

    @Override
    public boolean add(int value, int index) {
        try {
            add(value);
            values[size()-1] = values[index];
            values[index] = value;
            return true;
        }
        catch (Throwable e){
            e.getStackTrace();
            return false;
        }
    }

    @Override
    public int get(int index) {
        if(index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        return values[index];
    }

    @Override
    public boolean contains(int value) {
        for(int digit: values) {
            if(digit == value){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(AbstractIntArrayList list) {
        if(size() < list.size()) {
            return false;
        }
        for(int digit: list.values) {
            if(!contains(digit)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int remove(int index) {
        if(index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        int copy = values[index];
        int[] newValues = new int[size()-1];
        for(int i = 0; i < index; i++) {
            newValues[i] = values[i];
        }
        for(int i = index+1; i < newValues.length; i++) {
            newValues[i] = values[i];
        }
        return copy;
    }

    @Override
    public int set(int value, int index) {
        if(index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        int copy = values[index];
        values[index] = value;
        return copy;
    }

    @Override
    public boolean addAll(@NotNull AbstractIntArrayList list) {
        try {
            int[] newValues = new int[size()+list.size()];
            for(int i = 0; i < values.length; i++) {
                newValues[i] = values[i];
            }
            for(int i = values.length; i < newValues.length; i++) {
                newValues[i] = list.values[i];
            }
            return true;
        }
        catch (Throwable t) {
            t.getMessage();
            return false;
        }
    }

    @Override
    public void clear() {
        values = null;
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int indexOf(int value) {
        for(int i = 0; i < size(); i++) {
            if(values[i] == value) {
                return i;
            }
        }
        throw new Error("Значение не найдено");
    }

    @Override
    public int lastIndexOf(int value) {
        for(int i = size()-1; i >= 0; i--) {
            if(values[i] == value) {
                return i;
            }
        }
        throw new Error("Значение не найдено");
    }

    @Override
    public AbstractIntArrayList subList(int fromInclusive, int toInclusive) {
        if(fromInclusive < 0 || fromInclusive >= size() || toInclusive < 0 || toInclusive >= size()) {
            throw new IndexOutOfBoundsException();
        }

        if(toInclusive < fromInclusive) {
            int temp = fromInclusive;
            fromInclusive = toInclusive;
            toInclusive = temp;
        }

        AbstractIntArrayList newList = new IntArrayList(toInclusive - fromInclusive + 1);
        for(int i = fromInclusive; i <= toInclusive; i++) {
            newList.values[i] = values[i];
        }
        return newList;
    }

    public void show() {
        /*if(size() == 0) {
            System.out.println("Массив пуст");
            return;
        }*/
        System.out.print("{ ");
        for (int digit: values) {
            System.out.print(digit + " ");
        }
        System.out.println("}");
    }

    public static void main(String[] args) {
        IntArrayList Array = new IntArrayList();
        Array.show();
        Array.add(5, 11);
        Array.show();
        System.out.println("Size = " + Array.size());
    }
}
