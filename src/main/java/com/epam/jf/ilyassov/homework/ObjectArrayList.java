package com.epam.jf.ilyassov.homework;

public class ObjectArrayList extends AbstractObjectArrayList {

    public static void main(String[] args) {
        ObjectArrayList objectArrayList = new ObjectArrayList(25);
        for (int i = 0; i < objectArrayList.size(); i++) {
            objectArrayList.values[i]=i;
        }

        for (int i = 0; i < objectArrayList.size(); i++) {
            System.out.print(objectArrayList.values[i] + " ");
        }
        System.out.println();
        AbstractObjectArrayList list = objectArrayList.subList(2,10);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.values[i] + " ");
        }

//        System.out.println();
//        System.out.println(objectArrayList.lastIndexOf("zero"));
//        System.out.println(objectArrayList.lastIndexOf(11));
//        System.out.println(objectArrayList.lastIndexOf(5.4));
//        System.out.println(objectArrayList.contains("zero"));
//        System.out.println(objectArrayList.contains("3"));
//        System.out.println(objectArrayList.contains(25));
//        System.out.println(objectArrayList.contains(100));
//        System.out.println(objectArrayList.contains(5.4));


//        System.out.println(objectArrayList.get(objectArrayList.size() - 1));
//        for (int i = 0; i < objectArrayList.size(); i++) {
//            System.out.print(objectArrayList.values[i] + " ");
//        }
//        ObjectArrayList objectArrayList2= new ObjectArrayList(objectArrayList);
//        for (int i = 0; i < objectArrayList2.size(); i++) {
//            System.out.println(objectArrayList2.values[i]);
//        }
//        objectArrayList.values[0]="er";
//        System.out.println(objectArrayList.containsAll(objectArrayList2));



    }

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
        ObjectArrayList objectArrayList = new ObjectArrayList(this.size()+1);
        System.arraycopy(values,0,objectArrayList.values,0,values.length);
        objectArrayList.values[this.size()]=value;
        values=objectArrayList.values;
        return true;
    }

    @Override
    public boolean add(Object value, int index) {
        ObjectArrayList objectArrayList = new ObjectArrayList(this.size()+1);
        System.arraycopy(values,0,objectArrayList.values,0,index);
        objectArrayList.values[index]=value;
        System.arraycopy(values,index,objectArrayList.values,index+1,this.size()-index);
        values=objectArrayList.values;
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
        if(this.size()!=list.size())
            return false;
        for (int i = 0; i < list.size(); i++) {
            if(!contains(list.values[i]))
                return false;
        }
        return true;
    }

    @Override
    public Object remove(int index) {
        ObjectArrayList objectArrayList = new ObjectArrayList(this.size()-1);
        System.arraycopy(values,0,objectArrayList.values,0,index);
        System.arraycopy(values,index+1,objectArrayList.values,index,size()-index-1);
        values=objectArrayList.values;
        return this;
    }

    @Override
    public Object remove(Object value) {
        return null;
    }

    @Override
    public boolean removeAll(AbstractObjectArrayList list) {
        Object[] objects=new Object[0];
        values=objects;
        return true;
    }

    @Override
    public Object set(Object value, int index) {
        this.values[index]=value;
        return this.get(index);
    }

    @Override
    public boolean addAll(AbstractObjectArrayList list) {
        ObjectArrayList objectArrayList = new ObjectArrayList(this.size()+list.size());
        System.arraycopy(values,0,objectArrayList,0,this.size());
        System.arraycopy(list.values,0,objectArrayList,this.size(),objectArrayList.size());
        return true;
    }

    @Override
    public void clear() {

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
        for (int i = 0; i < this.size(); i++) {
            if(this.values[i].equals(value))
            {
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
        System.arraycopy(values,fromInclusive,list.values,0,list.size());
        return list;
    }

    @Override
    public void trimToSize() {

    }


}
