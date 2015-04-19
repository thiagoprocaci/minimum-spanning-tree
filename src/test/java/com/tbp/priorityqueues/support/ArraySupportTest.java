package com.tbp.priorityqueues.support;


import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class ArraySupportTest {

    private ArraySupport<Integer> arraySupport;
    private Integer[] array;

    @Before
    public void doBefore() {
        arraySupport = new ArraySupport<Integer>();
        int n = 10;
        array = new Integer[n];
        for(int i = 0; i < n; i++) {
            array[i] = i;
        }
    }

    @Test
    public void testExch() {
        assertEquals(0, array[0].intValue());
        assertEquals(1, array[1].intValue());
        arraySupport.exch(0,1,array);
        assertEquals(1, array[0].intValue());
        assertEquals(0, array[1].intValue());
    }

    @Test
    public void testResize() {
        int n = array.length;
        int capacityLoaded = n - 1;
        assertEquals(10, array.length);
        array = arraySupport.resize(2 * n, capacityLoaded, array);
        assertEquals(20, array.length);
    }

    @Test
    public void testGreater() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        for(int i = 0; i < array.length; i = i + 2) {
            assertFalse(arraySupport.greater(i, i + 1, array, null));
            assertTrue(arraySupport.greater(i + 1, i, array, null));

            assertFalse(arraySupport.greater(i, i + 1, array, comparator));
            assertTrue(arraySupport.greater(i + 1, i, array, comparator));
        }

    }


}
