package com.tbp.minspanningtree.support;


import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class BagTest {

    private Bag<Integer> bag;

    @Before
    public void doBefore() {
        bag = new Bag<Integer>();
    }

    @Test
    public void testEmpty() {
        assertTrue(bag.isEmpty());
        bag.add(1);
        assertFalse(bag.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(0, bag.size());
        bag.add(1);
        assertEquals(1, bag.size());
        bag.add(1);
        assertEquals(2, bag.size());
    }

    @Test
    public void testAdd() {
        bag.add(2);
        bag.add(1);
        bag.add(5);

        Integer[] array = new Integer[bag.size()];
        int index = 0;
        for(Iterator<Integer> it = bag.iterator(); it.hasNext();) {
            array[index] = it.next();
            index++;
        }
        assertEquals(5, array[0].intValue());
        assertEquals(1, array[1].intValue());
        assertEquals(2, array[2].intValue());

        bag.add(6);
        array = new Integer[bag.size()];
        index = 0;
        for(Iterator<Integer> it = bag.iterator(); it.hasNext();) {
            array[index] = it.next();
            index++;
        }
        assertEquals(6, array[0].intValue());
        assertEquals(5, array[1].intValue());
        assertEquals(1, array[2].intValue());
        assertEquals(2, array[3].intValue());
    }



}
