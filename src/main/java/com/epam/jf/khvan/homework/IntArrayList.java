public class IntArrayList extends AbstractIntArrayList {
     private int size = 0;
     private int[] values;

    public IntArrayList() {
        super();
    }

    public IntArrayList(int capacity) {
        super(capacity);
    }

    public IntArrayList(AbstractIntArrayList list){
        super(list);
        size = list.size();
    }

    @Override
    public boolean add(int value) {
        size++;
        checkArraySize(size);
        values[size - 1] = value;
        return true;
    }

    @Override
    public boolean add(int value, int index) {
         int [] temp = values;
         size++;
         checkArraySize(size);
         if (index > 0) {
             values[index] = value;
             System.arraycopy(temp, index, values,index + 1,size - index);
         }
         if (index == 0){
             values[index] = value;
             System.arraycopy(temp, 0, values,1, size);
         }
        return true;
    }


    @Override
    public int get(int index) {
        return values[index];
    }

    @Override
    public boolean contains(int value) {
        for (int value1 : values) {
            if (value1 == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(AbstractIntArrayList list) {
        boolean flag = true;
        for (int i = 0; i < list.size(); i++) {
            if ( this.contains( list.get(i))){
                flag = true;
            } else {
                flag = false;
                return flag;
            }
        }
        return flag;
    }

    @Override
    public int remove(int index) {
        int [] store = values;
        int removedInt = values[index];
        System.arraycopy(store ,index + 1 , values, index,size - index - 1);
        size--;
        return removedInt;
    }

    @Override
    public int set(int value, int index) {
        int previousInt = values[index];
        values[index] = value;
        return previousInt;
    }

    @Override
    public boolean addAll(AbstractIntArrayList list) {
        size = size + list.size();
        checkArraySize(size + list.size());
        System.arraycopy( list.values,0, values, size, list.size());
        return true;
    }

    @Override
    public void clear() {
        values = new int[10];
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
    public int indexOf(int value) {
        for (int i = 0; i < values.length ; i++) {
            if( values[i] == value){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(int value) {
        for (int i = size - 1; i >= 0 ; i--) {
            if (values[i] == value){
                return i;
            }
        }
        return -1;
    }

    private void checkArraySize(int size){
        if (size >= values.length){
            int capacity = size;
            while (capacity < values.length){
            capacity = (int) (capacity * 1.5) + 1;
            }
            int [] store = values;
            values = new int[capacity];
            System.arraycopy(store,0, values,0, size);
        }
    }

    public IntArrayList subList(int fromIndex, int toIndex) {
        subListRangeCheck(fromIndex, toIndex, size);
        return new Sublist(this, 0, fromIndex, toIndex);
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


    private class Sublist extends IntArrayList{
        IntArrayList parent;
        int size;
        int offset;
        int fromIndex;
        int toIndex;

        public Sublist (IntArrayList parent, int fromIndex, int toIndex, int offset) {
            super();
            size = toIndex - fromIndex;
            this.parent = parent;
            this.offset = offset + fromIndex;
            this.fromIndex = fromIndex;
            this.toIndex = toIndex;
        }

        @Override
        public boolean add(int value) {
            parent.add(offset+size,value);
            this.size++;
            return true;
        }

        @Override
        public boolean add(int value, int index) {
            parent.add(offset + index, value);
            this.size++;
            return true;
        }

        @Override
        public int get(int index) {
            return parent.values[offset + index];
        }

        @Override
        public boolean contains(int value) {
            for(int i = fromIndex; i < toIndex; i++){
                if ( parent.values[i] == value){
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean containsAll(AbstractIntArrayList list) {
            for (int i = 0; i < list.size(); i++){
                if ( this.contains( list.get(i))){
                    continue;
                } else {
                    return false;
                }
            }
            return true;
        }

        @Override
        public int remove(int index) {
            int result = parent.remove(offset + index);
            size--;
            return result;
        }

        @Override
        public int set(int value, int index) {
            int oldValue = parent.get(offset + index);
            parent.values[offset + index] = value;
            return oldValue;
        }

        @Override
        public boolean addAll(AbstractIntArrayList list) {
            size = size + list.size();
            parent.size = parent.size + list.size();
            parent.checkArraySize(parent.size);
            System.arraycopy( parent.values , toIndex + 1, parent.values, toIndex + list.size() + 1, parent.size - toIndex - 1 );
            System.arraycopy( list.values,0, parent.values, toIndex, list.size());
            return true;
        }

        @Override
        public void clear() {
            if( fromIndex < toIndex) {
                System.arraycopy( parent.values, fromIndex, parent.values, toIndex, size - ( toIndex - fromIndex ) );
                parent.size = parent.size - (toIndex - fromIndex);
            }
        }

        @Override
        public int size() {
            return this.size;
        }

        @Override
        public boolean isEmpty() {
            return this.size == 0;
        }

        @Override
        public int indexOf(int value) {
           for ( int i = fromIndex; i < toIndex; i++){
               if ( parent.values[i] == value){
                   return i;
               }
           }
           return -1;
        }

        @Override
        public int lastIndexOf(int value) {
            for ( int i = toIndex - 1; i >= fromIndex; i--){
                if ( parent.values[i] == value){
                    return i;
                }
            }
            return -1;
        }
    }
}

