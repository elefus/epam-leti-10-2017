package com.epam.jf.volkov.homework.task7;

import com.epam.jf.common.homework.task7.AbstractIntArrayList;

public class IntArrayList extends AbstractIntArrayList {

  protected int[] values;
  private int pointer;

  public IntArrayList() {
    values = new int[10];
    pointer = 0;
  }

  public IntArrayList(int capacity) {
    values = new int[capacity];
    pointer = 0;
  }

  public IntArrayList(IntArrayList list) {
    values = list.values.clone();
    pointer = list.size();
  }

  public IntArrayList(int[] array) {
    values = array;
    pointer = array.length;
  }

  @Override
  public boolean add(int value) {
    grow();
    values[pointer] = value;
    pointer++;
    return true;
  }

  @Override
  public boolean add(int value, int index) {
    if (isWrongIndex(index)) {
      return false;
    } else {
      grow();
      System.arraycopy(values, index, values, index + 1, pointer - index);
      values[index] = value;
      return true;
    }
  }

  @Override
  public int get(int index) {
    if (isWrongIndex(index)) {
      throw new IllegalArgumentException();
    } else {
      return values[index];
    }
  }

  @Override
  public boolean contains(int value) {
    for (int index = 0; index < pointer; index++) {
      if (values[index] == value) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean containsAll(AbstractIntArrayList list) {
    for (int index = 0; index < list.size(); index++) {
      if (!(contains(list.get(index)))) {
        return false;
      }
    }
    return true;
  }

  @Override
  public int remove(int index) {
    if (isWrongIndex(index)) {
      throw new IllegalArgumentException();
    } else {
      int value = values[index];
      System.arraycopy(values, index + 1, values, index, pointer - index);
      pointer--;
      return value;
    }
  }

  @Override
  public int set(int value, int index) {
    if (isWrongIndex(index)) {
      throw new IllegalArgumentException();
    } else {
      int ret = values[index];
      values[index] = value;
      return ret;
    }
  }

  @Override
  public boolean addAll(AbstractIntArrayList list) {
    int pointerBackup = this.pointer;
    for (int index = 0; index < list.size(); index++) {
      if (!this.add(list.get(index))) {
        this.pointer = pointerBackup;
        return false;
      }
    }
    return true;
  }

  @Override
  public void clear() {
    values = new int[pointer];
    pointer = 0;
  }

  @Override
  public int size() {
    return pointer;
  }

  @Override
  public boolean isEmpty() {
    return (pointer == 0);
  }

  @Override
  public int indexOf(int value) {
    for (int index = 0; index < pointer; index++) {
      if (value == values[index]) {
        return index;
      }
    }
    return 0;
  }

  @Override
  public int lastIndexOf(int value) {
    for (int index = pointer - 1; index >= 0; index--) {
      if (value == values[index]) {
        return index;
      }
    }
    return 0;
  }

  @Override
  public IntArrayList subList(int fromInclusive, int toInclusive) {
    if (isWrongIndex(fromInclusive) || isWrongIndex(toInclusive)) {
      throw new IllegalArgumentException();
    } else {
      int[] subList = new int[toInclusive - fromInclusive + 1];
      System.arraycopy(values, fromInclusive, subList, 0, toInclusive - fromInclusive + 1);
      return new IntArrayList(subList);
    }
  }

  private void grow() {
    if (isFull()) {
      int[] newValues = new int[pointer * 2 + 10];
      System.arraycopy(values, 0, newValues, 0, values.length);
      values = newValues;
    }
  }

  private boolean isFull() {
    return pointer >= values.length - 1;
  }

  private boolean isWrongIndex(int index) {
    return (index >= pointer || index < 0);
  }
}
