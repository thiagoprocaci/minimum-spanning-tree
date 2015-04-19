package com.tbp.priorityqueues.support;


import java.lang.reflect.Array;
import java.util.Comparator;

public class ArraySupport<Key> {

    public void exch(int i, int j, Key[] array) {
        Key swap = array[i];
        array[i] = array[j];
        array[j] = swap;
    }

    /**
     *
     * @param i index i
     * @param j index j
     * @param array
     * @param comparator
     * @return Returns true if element on index j is greater than element on index j.
     */
    public boolean greater(int i, int j,  Key[] array, Comparator<Key> comparator) {
        if (comparator == null) {
            return ((Comparable<Key>) array[i]).compareTo(array[j]) > 0;
        } else {
            return comparator.compare(array[i], array[j]) > 0;
        }
    }

    public Key[] resize(int newCapacity, int capacityLoaded, Key[] array) {
        Key[] temp = (Key[]) Array.newInstance(array.getClass().getComponentType(), newCapacity);

        // capacityLoaded is just used to optimaze out code
        // null elements on the array does not matter
        for (int i = 1; i <= capacityLoaded; i++) {
            temp[i] = array[i];
        }
        return temp;
    }
}
