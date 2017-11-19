package main.java.com.epam.jf.kruglik.homework.task12;

public class ObjectArrayList extends AbstractObjectArrayList {
    public ObjectArrayList() {
        values = new Object[10];
        this.capacity = 10;
    }

    public ObjectArrayList(int capacity) {
        values = new Object[capacity];
        this.capacity = capacity;
    }

    public ObjectArrayList(AbstractObjectArrayList list) {
        values = new Object[list.size()];
        this.capacity = list.size() - 1;
        this.size = list.size();

        for (int i = 0; i < list.size(); i++) {
            values[i] = list.get(i);
        }
    }


    @Override
    public boolean add(Object value) {
        if (capacity <= size){
            increaseCapacity();
        }
        values[size] = value;
        ++size;
        return true;
    }

    @Override
    public boolean add(Object value, int index) {
        if (capacity <= size) increaseCapacity();
        System.arraycopy(values, index, values, index + 1, size - index);
        values[index] = value;
        ++size;
        return false;
    }

    @Override
    public Object get(int index) {
        return values[index];
    }

    @Override
    public boolean contains(Object value) {
        for(int i = 0;i<size;++i){
            if (values[i].equals(value))
                return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(AbstractObjectArrayList list) {
        boolean flag = false;
        for (int i = 0;i<list.size();++i){
            for (int j = 0;j<size;++j)
                if (list.get(i).equals(values[j])){
                    flag = true;
                    break;
                }
            if (!flag){
                return false;
            }
        }
        return true;
    }

    @Override
    public Object remove(int index) {
        Object returnValue = values[index];
        System.arraycopy(values, index + 1, values, index, size - index);
        --size;
        return returnValue;
    }

    @Override
    public Object remove(Object value) {
        Object result = null;
        for(int i = 0;i<size;++i) {
            if (values[i].equals(value)) {
                result = values[i];
                remove(i);
                break;
            }
        }
        return result;
    }

    @Override
    public boolean removeAll(AbstractObjectArrayList list) {
        boolean flag = false;
        for (int i = 0;i<list.size();++i){
            for (int j = 0;j<size;++j)
                if (list.get(i).equals(values[j])){
                    remove(list.get(i));
                    flag = true;
                    break;
                }
            if (!flag){
                return false;
            }
        }
        return true;
    }

    @Override
    public Object set(Object value, int index) {
        values[index] = value;
        return values[index];
    }

    @Override
    public boolean addAll(AbstractObjectArrayList list) {
        while (capacity <= size + list.size()){
            increaseCapacity();
        }
        for(int i = 0;i<list.size();++i)
            values[size+i] = list.get(i);
        size += list.size();
        return true;
    }

    @Override
    public void clear() {
        for (int i=0;i<size;++i)
            values[i] = null;
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
        for(int i = 0;i<size;++i){
            if (values[i].equals(value))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        for(int i = size - 1;i>=0;--i){
            if (values[i].equals(value))
                return i;
        }
        return -1;
    }

    @Override
    public AbstractObjectArrayList subList(int fromInclusive, int toInclusive) {
        AbstractObjectArrayList buffer = new ObjectArrayList((toInclusive - fromInclusive)+1);
        for (int i=fromInclusive;i<=toInclusive;++i)
            buffer.add(values[i]);
        return buffer;
    }

    @Override
    public void trimToSize() {
        capacity = size;
        Object[] buffer = new Object[capacity];
        for (int i = 0; i<size; ++i){
            buffer[i] = values[i];
        }
        values = buffer;
    }

    private void increaseCapacity(){
        capacity *= 2;
        Object[] buffer = new Object[capacity];
        for (int i = 0; i<size; ++i){
            buffer[i] = values[i];
        }
        values = buffer;
    }

    public static void main(String[] args) {
        ObjectArrayList list = new ObjectArrayList();
        System.out.println(list.isEmpty());
    }
}
