package com.tbp.minspanningtree.support;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;


public class QueueTest {

    private Queue<Integer> queue;

    @Before
    public void doBefore() {
        queue = new Queue<Integer>();
    }

    @Test
    public void testInitialization() {
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
        try {
            queue.peek();
            fail("This code should not be executed");
        } catch (NoSuchElementException e) {
            assertNotNull(e);
        }
    }

    @Test
    public void testQueue() {
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(2, queue.size());
        assertFalse(queue.isEmpty());

        Integer[] array = new Integer[queue.size()];
        int index = 0;
        for(Iterator<Integer> it = queue.iterator(); it.hasNext();) {
            array[index] = it.next();
            index++;
        }
        assertEquals(1, array[0].intValue());
        assertEquals(2, array[1].intValue());

        assertEquals(1, queue.peek().intValue());
        assertEquals(1, queue.peek().intValue());
        assertEquals(1, queue.dequeue().intValue());
        assertEquals(2, queue.peek().intValue());
        assertEquals(1, queue.size());
        assertEquals(2, queue.dequeue().intValue());
        assertEquals(0, queue.size());


    }

}
