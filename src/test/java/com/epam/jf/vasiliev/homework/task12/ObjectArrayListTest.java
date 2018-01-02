package com.epam.jf.vasiliev.homework.task12;

import com.epam.jf.common.homework.task12.AbstractObjectArrayList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObjectArrayListTest {

    @Test
    void testAddValueWithoutIncreasingCapacity() {
        ObjectArrayList ref = new ObjectArrayList();
        ref.add(new Double(25.13));
        ref.add(new Double(13.0));
        ref.add(new Double(0));

        assertEquals(25.13,ref.get(0));
        assertEquals(13.0,ref.get(1));
        assertEquals(0.0,ref.get(2));
    }

    @Test
    void testAddValueWithIncreasingCapacity() {
        ObjectArrayList ref = new ObjectArrayList(5);
        ref.add(new Long(12345));
        ref.add(new Long(12345));
        ref.add(new Long(12345));
        ref.add(new Long(12345));
        ref.add(new Long(12345));

        assertEquals(5,ref.size());

        int oldSize = ref.getCapacity();
        ref.add(new Long(9090));
        assertTrue(oldSize < ref.getCapacity());
        assertEquals(9090L,ref.get(5));
    }

    @Test
    void testCopyConstructor() {
        ObjectArrayList first = new ObjectArrayList();
        first.add(new Integer(10));
        first.add(new Integer(10));
        first.add(new Integer(10));

        ObjectArrayList second = new ObjectArrayList(first);
        for (int i = 0; i < second.size(); i++) {
            assertEquals(first.get(i),second.get(i));
        }
    }

    @Test
    void testCopyCostructorOnIndependency() {
        ObjectArrayList first = new ObjectArrayList();
        first.add(new Integer(10));
        first.add(new Integer(10));
        first.add(new Integer(10));

        ObjectArrayList second = new ObjectArrayList(first);
        second.set(new Integer(3),0);

        assertNotEquals(first.get(0),second.get(0));
    }

    @Test
    void testAddByIndexOnIncreasingCapacity() {
        ObjectArrayList ref = new ObjectArrayList(3);
        ref.add(new String("hi"));
        ref.add(new String("world"));
        ref.add(new String("!"));

        int oldCapacity = ref.getCapacity();
        ref.add(new String("new string"));

        assertTrue(oldCapacity < ref.getCapacity());
        assertEquals("new string", ref.get(3));
    }

    @Test
    void testConstructorOnNegativeIndex() {
        assertThrows(IllegalArgumentException.class, () -> new ObjectArrayList(-2));
    }

    @Test
    void testGetOnIlligalIndex() {
        ObjectArrayList ref = new ObjectArrayList();
        ref.add(new Double(2.5656));

        assertThrows(IndexOutOfBoundsException.class,() -> ref.get(2));
        assertThrows(IndexOutOfBoundsException.class,() -> ref.get(-100));
    }

    @Test
    void testGetOnUsualCases() {
        ObjectArrayList ref = new ObjectArrayList();
        ref.add(new Integer(10));
        ref.add(new Integer(11));
        ref.add(new Integer(23123));
        ref.add(new Integer(-99));
        ref.add(new Integer(Integer.MAX_VALUE));

        assertEquals(10,ref.get(0));
        assertEquals(-99, ref.get(3));
        assertEquals(Integer.MAX_VALUE, ref.get(4));
    }

    @Test
    void testContains() {
        ObjectArrayList ref = new ObjectArrayList();
        ref.add(new Double(25.13));
        ref.add(new Double(13.0));
        ref.add(new Double(0));

        assertTrue(ref.contains(new Double(25.13)));
        assertTrue(ref.contains(new Double(0)));
        assertFalse(ref.contains(new Double(Double.MAX_VALUE)));
        assertFalse(ref.contains(new Double(70)));
    }

    @Test
    void testContainsAllEqualArrays() {
        ObjectArrayList first = new ObjectArrayList(5);
        first.add(new Long(20));
        first.add(new Long(-9089));
        first.add(new Long(0));
        first.add(new Long(7328648));

        ObjectArrayList second = new ObjectArrayList(first);

        assertTrue(second.containsAll(first));
        assertTrue(first.containsAll(second));
    }

    @Test
    void testContainsAllOnDifferentArrays() {
        ObjectArrayList first = new ObjectArrayList(5);
        first.add(new Long(20));
        first.add(new Long(-9089));
        first.add(new Long(0));
        first.add(new Long(7328648));

        ObjectArrayList second = new ObjectArrayList(first);
        second.add(new Long(42));
        second.add(new Long(42));
        second.add(new Long(42));

        assertTrue(second.containsAll(first));
        assertFalse(first.containsAll(second));
    }

    @Test
    void testRemoveUsualCase() {
        ObjectArrayList ref = new ObjectArrayList();
        ref.add(new Integer(66));
        ref.add(new Integer(55));
        ref.add(new Integer(-342));

        Integer toDel = new Integer(99);
        ref.add(toDel);

        assertSame(toDel,ref.remove(3));
    }

    @Test
    void testRemoveLastElement() {
        ObjectArrayList ref = new ObjectArrayList();
        ref.add(new Integer(66));
        ref.add(new Integer(55));
        ref.add(new Integer(-342));
        ref.add(new Integer(33));

        ref.remove(3);
        assertFalse(ref.contains(33));
    }

    @Test
    void testRemoveOnIllegalIndex() {
        ObjectArrayList ref = new ObjectArrayList();
        ref.add(new Integer(66));
        ref.add(new Integer(55));
        ref.add(new Integer(-342));

        assertThrows(IndexOutOfBoundsException.class, () -> ref.remove(-2));
    }

    @Test
    void testRemoveAllCaseWithRemoving() {
        ObjectArrayList ref = new ObjectArrayList();
        ref.add(new Integer(100));
        ref.add(new Integer(1));
        ref.add(new Integer(2));
        ref.add(new Integer(4));
        ref.add(new Integer(9));
        ref.add(new Integer(5));

        ObjectArrayList toDel = new ObjectArrayList();
        toDel.add(new Integer(1));
        toDel.add(new Integer(2));
        toDel.add(new Integer(3));
        toDel.add(new Integer(4));
        toDel.add(new Integer(5));

        assertTrue(ref.removeAll(toDel));

        for (int i = 0; i < toDel.size(); i++) {
            assertFalse(ref.contains(toDel.get(i)));
        }
    }

    @Test
    void testRemoveAllCaseWithoutRemoving() {
        ObjectArrayList ref = new ObjectArrayList();
        ref.add(new Integer(100));
        ref.add(new Integer(1));
        ref.add(new Integer(2));
        ref.add(new Integer(4));
        ref.add(new Integer(9));
        ref.add(new Integer(5));

        ObjectArrayList toDel = new ObjectArrayList();
        toDel.add(new Integer(10));
        toDel.add(new Integer(-2));
        toDel.add(new Integer(-5));
        assertFalse(ref.removeAll(toDel));
    }

    @Test
    void testSetOnIllegalIndex() {
        ObjectArrayList ref = new ObjectArrayList();
        ref.add(new Integer(100));

        assertThrows(IndexOutOfBoundsException.class,() -> ref.set(new Integer(0), -1));
    }

    @Test
    void testSetUsualCase() {
        ObjectArrayList ref = new ObjectArrayList();
        ref.add(new Integer(100));
        Integer toSet = new Integer(1);
        ref.set(toSet,0);

        assertSame(toSet,ref.get(0));
    }

    @Test
    void testAddAllWithIncreasingCapacity() {
        ObjectArrayList ref = new ObjectArrayList(1);
        ObjectArrayList toAdd = new ObjectArrayList();
        toAdd.add(new Long(1));
        toAdd.add(new Long(2));
        toAdd.add(new Long(-4));
        toAdd.add(new Long(66));
        toAdd.add(new Long(42));
        toAdd.add(new Long(324));

        ref.addAll(toAdd);

        for (int i = 0; i < ref.size(); i++) {
            assertEquals(toAdd.get(i),ref.get(i));
        }
    }

    @Test
    void testIndexOf() {
        ObjectArrayList ref = new ObjectArrayList();
        ref.add(new Integer(100));
        ref.add(new Integer(0));
        ref.add(new Integer(100));
        ref.add(new Integer(0));

        assertEquals(1,ref.indexOf(new Integer(0)));
        assertEquals(-1, ref.indexOf(42));
    }

    @Test
    void testLastIndexOf() {
        ObjectArrayList ref = new ObjectArrayList();
        ref.add(new Integer(125));
        ref.add(new Integer(0));
        ref.add(new Integer(10));
        ref.add(new Integer(0));

        assertEquals(3,ref.lastIndexOf(new Integer(0)));
        assertEquals(-1, ref.lastIndexOf(42));
    }

    @Test
    void testTrimToSizeOnZeroSize() {
        ObjectArrayList ref = new ObjectArrayList();
        ref.trimToSize();

        assertEquals(0,ref.getCapacity());
    }

    @Test
    void testTrimToSizeAfterDeleting() {
        ObjectArrayList ref = new ObjectArrayList(5);
        ref.add(new Integer(125));
        ref.add(new Integer(0));
        ref.add(new Integer(10));
        ref.add(new Integer(0));
        ref.add(new Integer(0));
        ref.add(new Integer(0));

        ref.remove(5);
        ref.trimToSize();

        assertEquals(ref.size(),ref.getCapacity());
    }

    @Test
    void testSubListAdd() {
        ObjectArrayList ref = new ObjectArrayList();
        ref.add(new Integer(100));
        ref.add(new Integer(1));
        ref.add(new Integer(2));
        ref.add(new Integer(4));
        ref.add(new Integer(9));
        ref.add(new Integer(5));

        AbstractObjectArrayList subList = ref.subList(1,5);
        subList.add(10);

        assertEquals(10,subList.get(subList.size() - 1));
        assertEquals(10, ref.get(5));
    }

    @Test
    void testSubListAddByIndex() {
        ObjectArrayList ref = new ObjectArrayList();
        ref.add(new Integer(100));
        ref.add(new Integer(1));
        ref.add(new Integer(2));
        ref.add(new Integer(4));
        ref.add(new Integer(9));
        ref.add(new Integer(5));

        AbstractObjectArrayList subList = ref.subList(1,5);
        subList.add(13, subList.size() - 1);
        subList.add(10, 0);

        assertEquals(10,subList.get(0));
        assertEquals(13,subList.get(subList.size() - 2));

        assertEquals(10, ref.get(1));
        assertEquals(13, ref.get(5));
    }

    @Test
    void testSubListContains() {
        ObjectArrayList ref = new ObjectArrayList();
        ref.add(new Integer(100));
        ref.add(new Integer(1));
        ref.add(new Integer(2));
        ref.add(new Integer(4));
        ref.add(new Integer(9));
        ref.add(new Integer(5));

        AbstractObjectArrayList subList = ref.subList(0,5);

        assertFalse(subList.contains(42));
        ref.add(42,0);

        assertTrue(subList.contains(42));
    }

    @Test
    void testSubListContainsAllTrue() {
        ObjectArrayList ref = new ObjectArrayList();
        ref.add(new Integer(100));
        ref.add(new Integer(1));
        ref.add(new Integer(2));
        ref.add(new Integer(4));
        ref.add(new Integer(9));
        ref.add(new Integer(5));

        AbstractObjectArrayList subList = ref.subList(0,3);

        ObjectArrayList toFind = new ObjectArrayList();
        toFind.add(new Integer(100));
        toFind.add(new Integer(1));
        toFind.add(new Integer(2));

        assertTrue(subList.containsAll(toFind));
    }

    @Test
    void testSubListContainsAllFalse() {
        ObjectArrayList ref = new ObjectArrayList();
        ref.add(new Integer(100));
        ref.add(new Integer(1));
        ref.add(new Integer(2));
        ref.add(new Integer(4));
        ref.add(new Integer(9));
        ref.add(new Integer(5));

        AbstractObjectArrayList subList = ref.subList(0,3);

        ObjectArrayList toFind = new ObjectArrayList();
        toFind.add(new Integer(100));
        toFind.add(new Integer(1));
        toFind.add(new Integer(4));

        assertFalse(subList.containsAll(toFind));
    }

    @Test
    void testSubListRemoveByIndex() {
        ObjectArrayList ref = new ObjectArrayList();
        ref.add(new Integer(100));
        ref.add(new Integer(1));
        ref.add(new Integer(2));
        ref.add(new Integer(4));
        ref.add(new Integer(9));
        ref.add(new Integer(5));

        AbstractObjectArrayList subList = ref.subList(2,6);
        subList.remove(3);
        subList.remove(0);

        assertFalse(subList.contains(2));
        assertFalse(subList.contains(5));

        assertFalse(ref.contains(2));
        assertFalse(ref.contains(5));
    }

    @Test
    void testSubListRemoveByValueTryToRemoveElExistingOnlyInParent() {
        ObjectArrayList ref = new ObjectArrayList();
        ref.add(new Integer(100));
        ref.add(new Integer(1));
        ref.add(new Integer(2));
        ref.add(new Integer(4));
        ref.add(new Integer(9));
        ref.add(new Integer(5));

        AbstractObjectArrayList subList = ref.subList(3,5);
        subList.remove(new Integer(100));

        assertTrue(ref.contains(100));
    }

    @Test
    void testSubListRemoveByValueTryToRemoveElExistingBothInParentAndSublist() {
        ObjectArrayList ref = new ObjectArrayList();
        ref.add(new Integer(100));
        ref.add(new Integer(1));
        ref.add(new Integer(2));
        ref.add(new Integer(4));
        ref.add(new Integer(100));
        ref.add(new Integer(5));

        AbstractObjectArrayList subList = ref.subList(3,5);
        subList.remove(new Integer(100));

        assertFalse(subList.contains(100));
        assertEquals(100,ref.get(0));
    }

   @Test
   void testSubListRemoveByValueUsualCase() {
       ObjectArrayList ref = new ObjectArrayList();
       ref.add(new Integer(100));
       ref.add(new Integer(1));
       ref.add(new Integer(2));
       ref.add(new Integer(4));
       ref.add(new Integer(100));
       ref.add(new Integer(5));

       AbstractObjectArrayList subList = ref.subList(3,5);
       subList.remove(new Integer(4));

       assertFalse(subList.contains(4));
       assertFalse(ref.contains(4));
   }

   @Test
    void testSubListIndexOfLowBound() {
       ObjectArrayList ref = new ObjectArrayList();
       ref.add(new Integer(100));
       ref.add(new Integer(1));
       ref.add(new Integer(2));
       ref.add(new Integer(4));
       ref.add(new Integer(100));
       ref.add(new Integer(5));

       AbstractObjectArrayList subList = ref.subList(3,5);

       assertEquals(0,subList.indexOf(4));
   }

   @Test
    void testSubListIndexOfHighBound() {
       ObjectArrayList ref = new ObjectArrayList();
       ref.add(new Integer(100));
       ref.add(new Integer(1));
       ref.add(new Integer(2));
       ref.add(new Integer(4));
       ref.add(new Integer(100));
       ref.add(new Integer(100));
       ref.add(new Integer(5));

       AbstractObjectArrayList subList = ref.subList(3,5);

       assertEquals(1,subList.indexOf(100));
   }

   @Test
    void testSubListLastIndexOf() {
       ObjectArrayList ref = new ObjectArrayList();
       ref.add(new Integer(100));
       ref.add(new Integer(1));
       ref.add(new Integer(2));
       ref.add(new Integer(4));
       ref.add(new Integer(100));
       ref.add(new Integer(100));
       ref.add(new Integer(5));

       AbstractObjectArrayList subList = ref.subList(3,6);

       assertEquals(2,subList.lastIndexOf(100));
   }

    @Test
    void testSubListLastIndexOfNotFound() {
        ObjectArrayList ref = new ObjectArrayList();
        ref.add(new Integer(100));
        ref.add(new Integer(1));
        ref.add(new Integer(2));
        ref.add(new Integer(4));
        ref.add(new Integer(100));
        ref.add(new Integer(100));
        ref.add(new Integer(5));

        AbstractObjectArrayList subList = ref.subList(3,6);
        assertEquals(ObjectArrayList.NOT_FOUND, subList.lastIndexOf(42));
    }

    @Test
    void testSubListSet() {
        ObjectArrayList ref = new ObjectArrayList();
        ref.add(new Integer(100));
        ref.add(new Integer(1));
        ref.add(new Integer(2));
        ref.add(new Integer(4));
        ref.add(new Integer(100));
        ref.add(new Integer(100));
        ref.add(new Integer(5));

        AbstractObjectArrayList subList = ref.subList(1,6);
        subList.set(42,0);

        assertEquals(42, ref.get(1));
        assertEquals(42,subList.get(0));
    }

    @Test
    void testSubListSetInvalidIndex() {
        ObjectArrayList ref = new ObjectArrayList();
        ref.add(new Integer(100));
        ref.add(new Integer(1));
        ref.add(new Integer(2));
        ref.add(new Integer(4));
        ref.add(new Integer(100));
        ref.add(new Integer(100));
        ref.add(new Integer(5));

        AbstractObjectArrayList subList = ref.subList(1,6);
        assertThrows(IndexOutOfBoundsException.class, () -> subList.set(42, 5));
    }


    @Test
    void testSubListAddAll() {
        ObjectArrayList ref = new ObjectArrayList();
        ref.add(new Integer(100));
        ref.add(new Integer(1));
        ref.add(new Integer(2));

        AbstractObjectArrayList subList = ref.subList(0,2);

        ObjectArrayList toAdd = new ObjectArrayList();
        toAdd.add(new Integer(13));
        toAdd.add(new Integer(13));
        toAdd.add(new Integer(2));
        toAdd.add(new Integer(3));

        subList.addAll(toAdd);

        assertEquals(7,ref.size());
        assertEquals(6, subList.size());

        assertEquals(3,ref.get(5));
        assertEquals(3,subList.get(5));
    }

    @Test
    void testSubListClear() {
        ObjectArrayList ref = new ObjectArrayList();
        ref.add(new Integer(100));
        ref.add(new Integer(1));
        ref.add(new Integer(2));
        ref.add(new Integer(4));
        ref.add(new Integer(100));
        ref.add(new Integer(10));
        ref.add(new Integer(5));

        AbstractObjectArrayList subList = ref.subList(1,6);
        subList.clear();

        assertEquals(2,ref.size());
    }

    @Test
    void testSubListClearDeletingAllFromParent() {
        ObjectArrayList ref = new ObjectArrayList();
        ref.add(new Integer(100));
        ref.add(new Integer(1));
        ref.add(new Integer(2));
        ref.add(new Integer(4));
        ref.add(new Integer(100));
        ref.add(new Integer(10));
        ref.add(new Integer(5));

        AbstractObjectArrayList subList = ref.subList(0,7);
        subList.clear();

        assertTrue(ref.isEmpty());
    }

    @Test
    void testSubListRemoveAllWithRemovingPartOfSubList() {
        ObjectArrayList ref = new ObjectArrayList();
        ref.add(new Integer(100));
        ref.add(new Integer(1));
        ref.add(new Integer(2));
        ref.add(new Integer(4));
        ref.add(new Integer(100));
        ref.add(new Integer(10));
        ref.add(new Integer(5));

        AbstractObjectArrayList subList = ref.subList(0,4);

        ObjectArrayList toDel = new ObjectArrayList();
        toDel.add(4);
        toDel.add(1);

        subList.removeAll(toDel);

        assertEquals(2,ref.get(1));
        assertEquals(100,subList.get(0));
    }

    @Test
    void testSubListRemoveAllWithRemovingAllOfSubList() {
        ObjectArrayList ref = new ObjectArrayList();
        ref.add(new Integer(11));
        ref.add(new Integer(1));
        ref.add(new Integer(2));
        ref.add(new Integer(4));
        ref.add(new Integer(100));
        ref.add(new Integer(10));
        ref.add(new Integer(5));

        AbstractObjectArrayList subList = ref.subList(0,4);

        ObjectArrayList toDel = new ObjectArrayList();
        toDel.add(4);
        toDel.add(1);
        toDel.add(11);
        toDel.add(2);

        subList.removeAll(toDel);

        assertTrue(subList.isEmpty());
        assertEquals(100, ref.get(0));
        assertEquals(3,ref.size());
    }

    @Test
    void testDelFromSubListInSublist() {
        ObjectArrayList ref = new ObjectArrayList();
        ref.add(new Integer(11));
        ref.add(new Integer(1));
        ref.add(new Integer(2));
        ref.add(new Integer(4));
        ref.add(new Integer(100));
        ref.add(new Integer(10));
        ref.add(new Integer(5));

        AbstractObjectArrayList subList = ref.subList(1,5);
        AbstractObjectArrayList subSubList = subList.subList(0,3);

        subSubList.remove(new Integer(2));

        assertEquals(4,ref.get(2));
    }

    @Test
    void testSubListCreateEmptySubList() {
        ObjectArrayList ref = new ObjectArrayList();
        ref.add(new Integer(11));
        ref.add(new Integer(1));
        ref.add(new Integer(2));
        ref.add(new Integer(4));
        ref.add(new Integer(100));
        ref.add(new Integer(10));
        ref.add(new Integer(5));

        AbstractObjectArrayList subList = ref.subList(1,1);

        assertTrue(subList.isEmpty());
    }








}















