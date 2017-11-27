package com.epam.jf.volkov.homework.task12;

import com.epam.jf.common.homework.task12.AbstractObjectArrayList;

/**
 * Список, построенный на основе массива.
 * Позволяет хранить значения любых ссылочных типов.
 */
public class ObjectArrayList extends AbstractObjectArrayList {

    protected Object[] values;
    private int pointer;

    public ObjectArrayList() {
        values = new Object[10];
        pointer = 0;
    }

    public ObjectArrayList(int capacity) {
        values = new Object[capacity];
        pointer = 0;
    }

    public ObjectArrayList(ObjectArrayList list) {
        System.arraycopy(list.values, 0, values, 0, list.values.length);
        pointer = list.size();
    }

    public boolean add(Object value) {
        try {
            grow();
            values[pointer] = value; //Можно параметризацию и Cloneable добавить? У меня кровь из глаз течет.
            pointer++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean add(Object value, int index) {
        try {
            if (isCorrectIndex(index)) {
                grow();
                Object[] newValues = new Object[values.length + 1];
                System.arraycopy(values, 0, newValues, 0, index);
                newValues[index] = value; //См. выше
                System.arraycopy(values, index, newValues, index + 1, values.length - index);
                values = newValues;
                pointer++;
                return true;
            } else {
                return false;
            }
        } catch(Exception e) {
            return false;
        }
    }

    public Object get(int index) {
        if (isCorrectIndex(index)) {
            return values[index];
        } else {
            throw new IllegalArgumentException("Bad index");
        }
    }

    public boolean contains(Object value) {
        for (int i = 0; i < values.length; i++) {
            if (values[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsAll(AbstractObjectArrayList list) {
        for(int i = 0; i < list.size(); i++) {
            if (!contains(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public Object remove(int index) {
        if (isCorrectIndex(index)) {
            Object value = values[index];
            System.arraycopy(values, index + 1, values, index, pointer - index);
            pointer--;
            return true;
        } else {
            throw new RuntimeException("Incorrect index");
        }
    }

    public Object remove(Object value) {
        if (contains(value)) {
            return remove(indexOf(value));
        } else {
            throw new RuntimeException("No such Object");
        }
    }

    public boolean removeAll(AbstractObjectArrayList list) {
        if (containsAll(list)) {
            for (int i = 0; i < list.size(); i++) {
                remove(list.get(i));
            }
            return false;
        } else {
            return false;
        }
    }

    public Object set(Object value, int index) {
        if (isCorrectIndex(index)) {
            Object temp = values[index];
            values[index] = value;
            return temp;
        } else {
            throw new RuntimeException("Incorrect index");
        }
    }

    public boolean addAll(AbstractObjectArrayList list) {
        Object[] valuesBackup = new Object[values.length];
        int pointerBackup = pointer;
        System.arraycopy(values, 0, valuesBackup, 0 , pointer);
        try {
            for (int i = 0; i < list.size(); i++) {
                add(list.get(i));
            }
            return true;
        } catch (Exception e) {
            values = valuesBackup;
            pointer = pointerBackup;
            return false; //Лист может быть поврежден после использования этого метода, так что восстанавливаем из бэкапа
        }

    }

    public void clear() {
        values = new Object[pointer];
        pointer = 0;
    }

    public int size() {
        return pointer;
    }

    public boolean isEmpty() {
        return pointer == 0;
    }

    public int indexOf(Object value) {
        int index = -1;
        for (int i = 0; i < values.length; i++) {
            if (values[i].equals(value)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new RuntimeException("Object not found!");
        } else {
            return index;
        }

    }

    public int lastIndexOf(Object value) {
        int index = -1;
        for (int i = values.length - 1; i > -1; i--) {
            if (values[i].equals(value)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new RuntimeException("Object not found!");
        } else {
            return index;
        }

    }

    public AbstractObjectArrayList subList(int fromInclusive, int toInclusive) {
        return new ObjectArrayList(666);
    }

    public void trimToSize() {

    }

    private void grow() {
        if (pointer == values.length) {
            Object[] newValues = new Object[(values.length * 2) + 1];
            System.arraycopy(values, 0, newValues, 0, values.length);
            values = newValues;
        }
    }

    private boolean isCorrectIndex(int index) {
        return (index >= 0 && index < pointer);
    }
}
