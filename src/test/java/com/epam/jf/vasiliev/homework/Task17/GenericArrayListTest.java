package com.epam.jf.vasiliev.homework.Task17;

import com.epam.jf.common.homework.task12.AbstractObjectArrayList;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;
import sun.rmi.server.InactiveGroupException;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenericArrayListTest {

    @Test
    void testAddValueWithoutIncreasingCapacity() {
        GenericArrayList<Double> ref = new GenericArrayList<>();
        ref.add(25.13);
        ref.add(13.0);
        ref.add(0d);


        assertEquals(new Double(25.13),ref.get(0));
        assertEquals(new Double(13.0),ref.get(1));
        assertEquals(new Double(0.0),ref.get(2));
    }

    @Test
    void testAddValueWithIncreasingCapacity() {
        GenericArrayList<Long> ref = new GenericArrayList<>(5);
        ref.add(12345L);
        ref.add(12345L);
        ref.add(12345L);
        ref.add(12345L);
        ref.add(12345L);

        assertEquals(5,ref.size());

        int oldSize = ref.getCapacity();
        ref.add(9090L);
        assertTrue(oldSize < ref.getCapacity());
        assertEquals(new Long(9090L),ref.get(5));
    }

    @Test
    void testCopyConstructor() {
        GenericArrayList<Integer> first = new GenericArrayList<>();
        first.add(10);
        first.add(10);
        first.add(10);

        GenericArrayList<Integer> second = new GenericArrayList<>(first);
        for (int i = 0; i < second.size(); i++) {
            assertEquals(first.get(i),second.get(i));
        }
    }

    @Test
    void testCopyCostructorOnIndependency() {
        GenericArrayList<Integer> first = new GenericArrayList<>();
        first.add(10);
        first.add(10);
        first.add(10);

        GenericArrayList<Integer> second = new GenericArrayList<>(first);
        second.set(3,0);

        assertNotEquals(first.get(0),second.get(0));
    }

    @Test
    void testAddByIndexOnIncreasingCapacity() {
        GenericArrayList<String> ref = new GenericArrayList<>(3);
        ref.add("hi");
        ref.add("world");
        ref.add("!");

        int oldCapacity = ref.getCapacity();
        ref.add("new string");

        assertTrue(oldCapacity < ref.getCapacity());
        assertEquals("new string", ref.get(3));
    }

    @Test
    void testConstructorOnNegativeIndex() {
        assertThrows(IllegalArgumentException.class, () -> new GenericArrayList<Integer>(-2));
    }

    @Test
    void testGetOnIlligalIndex() {
        GenericArrayList<Double> ref = new GenericArrayList<>();
        ref.add(2.5656);

        assertThrows(IndexOutOfBoundsException.class,() -> ref.get(2));
        assertThrows(IndexOutOfBoundsException.class,() -> ref.get(-100));
    }

    @Test
    void testGetOnUsualCases() {
        GenericArrayList<Integer> ref = new GenericArrayList<>();
        ref.add(10);
        ref.add(11);
        ref.add(23123);
        ref.add(-99);
        ref.add(Integer.MAX_VALUE);

        assertEquals(new Integer(10),ref.get(0));
        assertEquals(new Integer(-99), ref.get(3));
        assertEquals(new Integer(Integer.MAX_VALUE), ref.get(4));
    }

    @Test
    void testContains() {
        GenericArrayList<Double> ref = new GenericArrayList<>();
        ref.add(25.13);
        ref.add(13.0);
        ref.add(0d);

        assertTrue(ref.contains(25.13));
        assertTrue(ref.contains(0d));
        assertFalse(ref.contains(Double.MAX_VALUE));
        assertFalse(ref.contains(70d));
    }

    @Test
    void testContainsAllEqualArrays() {
        GenericArrayList<Long> first = new GenericArrayList<Long>(5);
        first.add(20L);
        first.add((long) -9089);
        first.add(0L);
        first.add(7328648L);

        GenericArrayList<Long> second = new GenericArrayList<>(first);

        assertTrue(second.containsAll(first));
        assertTrue(first.containsAll(second));
    }

    @Test
    void testContainsAllOnDifferentArrays() {
        GenericArrayList<Long> first = new GenericArrayList<>(5);
        first.add(20L);
        first.add(-9089L);
        first.add(0L);
        first.add(7328648L);

        GenericArrayList<Long> second = new GenericArrayList<>(first);
        second.add(42L);
        second.add(42L);
        second.add(42L);

        assertTrue(second.containsAll(first));
        assertFalse(first.containsAll(second));
    }

    @Test
    void testRemoveUsualCase() {
        GenericArrayList<Integer> ref = new GenericArrayList<>();
        ref.add(66);
        ref.add(55);
        ref.add(-342);

        Integer toDel = 99;
        ref.add(toDel);

        assertSame(toDel,ref.remove(3));
    }

    @Test
    void testRemoveLastElement() {
        GenericArrayList<Integer> ref = new GenericArrayList<>();
        ref.add(66);
        ref.add(55);
        ref.add(-342);
        ref.add(33);

        ref.remove(3);
        assertFalse(ref.contains(33));
    }

    @Test
    void testRemoveOnIllegalIndex() {
        GenericArrayList<Integer> ref = new GenericArrayList<>();
        ref.add(66);
        ref.add(55);
        ref.add(-342);

        assertThrows(IndexOutOfBoundsException.class, () -> ref.remove(-2));
    }

    @Test
    void testRemoveAllCaseWithRemoving() {
        GenericArrayList<Integer> ref = new GenericArrayList<>();
        ref.add(100);
        ref.add(1);
        ref.add(2);
        ref.add(4);
        ref.add(9);
        ref.add(5);

        GenericArrayList<Integer> toDel = new GenericArrayList<>();
        toDel.add(1);
        toDel.add(2);
        toDel.add(3);
        toDel.add(4);
        toDel.add(5);

        assertTrue(ref.removeAll(toDel));

        for (int i = 0; i < toDel.size(); i++) {
            assertFalse(ref.contains(toDel.get(i)));
        }
    }

    @Test
    void testRemoveAllCaseWithoutRemoving() {
        GenericArrayList<Integer> ref = new GenericArrayList<>();
        ref.add(100);
        ref.add(1);
        ref.add(2);
        ref.add(4);
        ref.add(9);
        ref.add(5);

        GenericArrayList<Integer> toDel = new GenericArrayList<>();
        toDel.add(10);
        toDel.add(-2);
        toDel.add(-5);
        assertFalse(ref.removeAll(toDel));
    }

    @Test
    void testSetOnIllegalIndex() {
        GenericArrayList<Integer> ref = new GenericArrayList<>();
        ref.add(100);

        assertThrows(IndexOutOfBoundsException.class,() -> ref.set(0, -1));
    }

    @Test
    void testSetUsualCase() {
        GenericArrayList<Integer> ref = new GenericArrayList<>();
        ref.add(100);
        Integer toSet = 1;
        ref.set(toSet,0);

        assertSame(toSet,ref.get(0));
    }

    @Test
    void testAddAllWithIncreasingCapacity() {
        GenericArrayList<Long> ref = new GenericArrayList<>(1);
        GenericArrayList<Long> toAdd = new GenericArrayList<>();
        toAdd.add(1L);
        toAdd.add(2L);
        toAdd.add(-4L);
        toAdd.add(66L);
        toAdd.add(42L);
        toAdd.add(324L);

        ref.addAll(toAdd);

        for (int i = 0; i < ref.size(); i++) {
            assertEquals(toAdd.get(i),ref.get(i));
        }
    }

    @Test
    void testIndexOf() {
        GenericArrayList<Integer> ref = new GenericArrayList<>();
        ref.add(100);
        ref.add(0);
        ref.add(100);
        ref.add(0);

        assertEquals(1,ref.indexOf(0));
        assertEquals(-1, ref.indexOf(42));
    }

    @Test
    void testLastIndexOf() {
        GenericArrayList<Integer> ref = new GenericArrayList<>();
        ref.add(125);
        ref.add(0);
        ref.add(10);
        ref.add(0);

        assertEquals(3,ref.lastIndexOf(0));
        assertEquals(-1, ref.lastIndexOf(42));
    }

    @Test
    void testTrimToSizeOnZeroSize() {
        GenericArrayList<Integer> ref = new GenericArrayList<>();
        ref.trimToSize();

        assertEquals(0,ref.getCapacity());
    }

    @Test
    void testTrimToSizeAfterDeleting() {
        GenericArrayList<Integer> ref = new GenericArrayList<>(5);
        ref.add(125);
        ref.add(0);
        ref.add(10);
        ref.add(0);
        ref.add(0);
        ref.add(0);

        ref.remove(5);
        ref.trimToSize();

        assertEquals(ref.size(),ref.getCapacity());
    }

    @Test
    void testSubListAdd() {
        GenericArrayList<Integer> ref = new GenericArrayList<>();
        ref.add(100);
        ref.add(1);
        ref.add(2);
        ref.add(4);
        ref.add(9);
        ref.add(5);

        GenericList<Integer> subList = ref.subList(1,5);
        subList.add(10);

        assertEquals(new Integer(10),subList.get(subList.size() - 1));
        assertEquals(new Integer(10), ref.get(5));
    }

    @Test
    void testSubListAddByIndex() {
        GenericArrayList<Integer> ref = new GenericArrayList<>();
        ref.add(100);
        ref.add(1);
        ref.add(2);
        ref.add(4);
        ref.add(9);
        ref.add(5);

        GenericList subList = ref.subList(1,5);
        subList.add(13, subList.size() - 1);
        subList.add(10, 0);

        assertEquals(10,subList.get(0));
        assertEquals(13,subList.get(subList.size() - 2));

        assertEquals(new Integer(10), ref.get(1));
        assertEquals(new Integer(13), ref.get(5));
    }

    @Test
    void testSubListContains() {
        GenericArrayList<Integer> ref = new GenericArrayList<>();
        ref.add(100);
        ref.add(1);
        ref.add(2);
        ref.add(4);
        ref.add(9);
        ref.add(5);

        GenericList<Integer> subList = ref.subList(0,5);

        assertFalse(subList.contains(42));
        ref.add(42,0);

        assertTrue(subList.contains(42));
    }

    @Test
    void testSubListContainsAllTrue() {
        GenericArrayList<Integer> ref = new GenericArrayList<>();
        ref.add(100);
        ref.add(1);
        ref.add(2);
        ref.add(4);
        ref.add(9);
        ref.add(5);

        GenericList<Integer> subList = ref.subList(0,3);

        GenericArrayList<Integer> toFind = new GenericArrayList<>();
        toFind.add(100);
        toFind.add(1);
        toFind.add(2);

        assertTrue(subList.containsAll(toFind));
    }

    @Test
    void testSubListContainsAllFalse() {
        GenericArrayList<Integer> ref = new GenericArrayList<>();
        ref.add(100);
        ref.add(1);
        ref.add(2);
        ref.add(4);
        ref.add(9);
        ref.add(5);

        GenericList<Integer> subList = ref.subList(0,3);

        GenericArrayList<Integer> toFind = new GenericArrayList<>();
        toFind.add(100);
        toFind.add(1);
        toFind.add(4);

        assertFalse(subList.containsAll(toFind));
    }

    @Test
    void testSubListRemoveByIndex() {
        GenericArrayList<Integer> ref = new GenericArrayList<>();
        ref.add(100);
        ref.add(1);
        ref.add(2);
        ref.add(4);
        ref.add(9);
        ref.add(5);

        GenericList<Integer> subList = ref.subList(2,6);
        subList.remove(3);
        subList.remove(0);

        assertFalse(subList.contains(2));
        assertFalse(subList.contains(5));

        assertFalse(ref.contains(2));
        assertFalse(ref.contains(5));
    }

    @Test
    void testSubListRemoveByValueTryToRemoveElExistingOnlyInParent() {
        GenericArrayList<Integer> ref = new GenericArrayList<>();
        ref.add(100);
        ref.add(1);
        ref.add(2);
        ref.add(4);
        ref.add(9);
        ref.add(5);

        GenericList<Integer> subList = ref.subList(3,5);
        subList.remove(new Integer(100));

        assertTrue(ref.contains(100));
    }

    @Test
    void testSubListRemoveByValueTryToRemoveElExistingBothInParentAndSublist() {
        GenericArrayList<Integer> ref = new GenericArrayList<>();
        ref.add(100);
        ref.add(1);
        ref.add(2);
        ref.add(4);
        ref.add(100);
        ref.add(5);

        GenericList<Integer> subList = ref.subList(3,5);
        subList.remove(new Integer(100));

        assertFalse(subList.contains(100));
        assertEquals(new Integer(100),ref.get(0));
    }

    @Test
    void testSubListRemoveByValueUsualCase() {
        GenericArrayList<Integer> ref = new GenericArrayList<>();
        ref.add(100);
        ref.add(1);
        ref.add(2);
        ref.add(4);
        ref.add(100);
        ref.add(5);

        GenericList<Integer> subList = ref.subList(3,5);
        subList.remove(new Integer(4));

        assertFalse(subList.contains(4));
        assertFalse(ref.contains(4));
    }

    @Test
    void testSubListIndexOfLowBound() {
        GenericArrayList<Integer> ref = new GenericArrayList<>();
        ref.add(100);
        ref.add(1);
        ref.add(2);
        ref.add(4);
        ref.add(100);
        ref.add(5);

        GenericList<Integer> subList = ref.subList(3,5);

        assertEquals(0,subList.indexOf(4));
    }

    @Test
    void testSubListIndexOfHighBound() {
        GenericArrayList<Integer> ref = new GenericArrayList<>();
        ref.add(100);
        ref.add(1);
        ref.add(2);
        ref.add(4);
        ref.add(100);
        ref.add(100);
        ref.add(5);

        GenericList<Integer> subList = ref.subList(3,5);

        assertEquals(1,subList.indexOf(100));
    }

    @Test
    void testSubListLastIndexOf() {
        GenericArrayList<Integer> ref = new GenericArrayList<>();
        ref.add(100);
        ref.add(1);
        ref.add(2);
        ref.add(4);
        ref.add(100);
        ref.add(100);
        ref.add(5);

        GenericList<Integer> subList = ref.subList(3,6);

        assertEquals(2,subList.lastIndexOf(100));
    }

    @Test
    void testSubListLastIndexOfNotFound() {
        GenericArrayList<Integer> ref = new GenericArrayList<>();
        ref.add(100);
        ref.add(1);
        ref.add(2);
        ref.add(4);
        ref.add(100);
        ref.add(100);
        ref.add(5);

        GenericList<Integer> subList = ref.subList(3,6);
        assertEquals(GenericArrayList.NOT_FOUND, subList.lastIndexOf(42));
    }

    @Test
    void testSubListSet() {
        GenericArrayList<Integer> ref = new GenericArrayList<>();
        ref.add(100);
        ref.add(1);
        ref.add(2);
        ref.add(4);
        ref.add(100);
        ref.add(100);
        ref.add(5);

        GenericList<Integer> subList = ref.subList(1,6);
        subList.set(42,0);

        assertEquals(new Integer(42), ref.get(1));
        assertEquals(new Integer(42),subList.get(0));
    }

    @Test
    void testSubListSetInvalidIndex() {
        GenericArrayList<Integer> ref = new GenericArrayList<>();
        ref.add(100);
        ref.add(1);
        ref.add(2);
        ref.add(4);
        ref.add(100);
        ref.add(100);
        ref.add(5);

        GenericList<Integer> subList = ref.subList(1,6);
        assertThrows(IndexOutOfBoundsException.class, () -> subList.set(42, 5));
    }


    @Test
    void testSubListAddAll() {
        GenericArrayList<Integer> ref = new GenericArrayList<>();
        ref.add(100);
        ref.add(1);
        ref.add(2);

        GenericList<Integer> subList = ref.subList(0,2);

        GenericArrayList<Integer> toAdd = new GenericArrayList<>();
        toAdd.add(13);
        toAdd.add(13);
        toAdd.add(2);
        toAdd.add(3);

        subList.addAll(toAdd);

        assertEquals(7,ref.size());
        assertEquals(6, subList.size());

        assertEquals(new Integer(3),ref.get(5));
        assertEquals(new Integer(3),subList.get(5));
    }

    @Test
    void testSubListClear() {
        GenericArrayList<Integer> ref = new GenericArrayList<>();
        ref.add(100);
        ref.add(1);
        ref.add(2);
        ref.add(4);
        ref.add(100);
        ref.add(10);
        ref.add(5);

        GenericList<Integer> subList = ref.subList(1,6);
        subList.clear();

        assertEquals(2,ref.size());
    }

    @Test
    void testSubListClearDeletingAllFromParent() {
        GenericArrayList<Integer> ref = new GenericArrayList<>();
        ref.add(100);
        ref.add(1);
        ref.add(2);
        ref.add(4);
        ref.add(100);
        ref.add(10);
        ref.add(5);

        GenericList<Integer> subList = ref.subList(0,7);
        subList.clear();

        assertTrue(ref.isEmpty());
    }

    @Test
    void testSubListRemoveAllWithRemovingPartOfSubList() {
        GenericArrayList<Integer> ref = new GenericArrayList<>();
        ref.add(100);
        ref.add(1);
        ref.add(2);
        ref.add(4);
        ref.add(100);
        ref.add(10);
        ref.add(5);

        GenericList<Integer> subList = ref.subList(0,4);

        GenericArrayList<Integer> toDel = new GenericArrayList<>();
        toDel.add(4);
        toDel.add(1);

        subList.removeAll(toDel);

        assertEquals(new Integer(2),ref.get(1));
        assertEquals(new Integer(100),subList.get(0));
    }

    @Test
    void testSubListRemoveAllWithRemovingAllOfSubList() {
        GenericArrayList<Integer> ref = new GenericArrayList<>();
        ref.add(11);
        ref.add(1);
        ref.add(2);
        ref.add(4);
        ref.add(100);
        ref.add(10);
        ref.add(5);

        GenericList<Integer> subList = ref.subList(0,4);

        GenericArrayList<Integer> toDel = new GenericArrayList<>();
        toDel.add(4);
        toDel.add(1);
        toDel.add(11);
        toDel.add(2);

        subList.removeAll(toDel);

        assertTrue(subList.isEmpty());
        assertEquals(new Integer(100), ref.get(0));
        assertEquals(3,ref.size());
    }

    @Test
    void testDelFromSubListInSublist() {
        GenericArrayList<Integer> ref = new GenericArrayList<>();
        ref.add(11);
        ref.add(1);
        ref.add(2);
        ref.add(4);
        ref.add(100);
        ref.add(10);
        ref.add(5);

        GenericList<Integer> subList = ref.subList(1,5);
        GenericList<Integer> subSubList = subList.subList(0,3);

        subSubList.remove(new Integer(2));

        assertEquals(new Integer(4),ref.get(2));
    }

    @Test
    void testSubListCreateEmptySubList() {
        GenericArrayList<Integer> ref = new GenericArrayList<>();
        ref.add(11);
        ref.add(1);
        ref.add(2);
        ref.add(4);
        ref.add(100);
        ref.add(10);
        ref.add(5);

        GenericList<Integer> subList = ref.subList(1,1);

        assertTrue(subList.isEmpty());
    }

}