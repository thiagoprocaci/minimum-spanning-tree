package com.tbp.priorityqueues;


import com.tbp.priorityqueues.support.ArraySupport;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MinPriorityQueueTest {

    private PriorityQueue<Integer> priorityQueue;
    private ArraySupport<Integer> arraySupport;

    @Before
    public void doBefore() {
        priorityQueue = new MinPriorityQueue<Integer>();
        arraySupport = new ArraySupport<Integer>();
    }

    @Test
    public void testHeapSize() {
        Assert.assertTrue(priorityQueue.isEmpty());
        Assert.assertEquals(0, priorityQueue.size());

        priorityQueue.insert(2);

        Assert.assertFalse(priorityQueue.isEmpty());
        Assert.assertEquals(1, priorityQueue.size());

        priorityQueue.insert(2);
        Assert.assertFalse(priorityQueue.isEmpty());
        Assert.assertEquals(2, priorityQueue.size());
    }

   @Test
   public void testHeapException() {
       try {
           priorityQueue.pop();
           Assert.fail("this code should not be executed");
       } catch (NoSuchElementException e) {
           Assert.assertNotNull(e);
       }
       try {
           priorityQueue.delete();
           Assert.fail("this code should not be executed");
       } catch (NoSuchElementException e) {
           Assert.assertNotNull(e);
       }
   }

    @Test
    public void testHeap() {
        priorityQueue.insert(29);
        priorityQueue.insert(66);
        priorityQueue.insert(18);
        priorityQueue.insert(20);
        priorityQueue.insert(8);
        priorityQueue.insert(28);
        priorityQueue.insert(28);
        priorityQueue.insert(39);

        Integer[] priorityQueueArray = new Integer[priorityQueue.size() + 1];
        int index = 1;
        for(Iterator<Integer> it = priorityQueue.iterator(); it.hasNext(); ) {
            priorityQueueArray[index] = it.next();
            index++;
        }
        Assert.assertTrue(isMinHeap(1, priorityQueueArray));
        Assert.assertEquals(8, priorityQueue.pop().intValue());

        priorityQueue.delete();
        priorityQueueArray = new Integer[priorityQueue.size() + 1];
        index = 1;
        for(Iterator<Integer> it = priorityQueue.iterator(); it.hasNext(); ) {
            priorityQueueArray[index] = it.next();
            index++;
        }
        Assert.assertTrue(isMinHeap(1, priorityQueueArray));
        Assert.assertEquals(18, priorityQueue.pop().intValue());
    }


    private boolean isMinHeap(int k, Integer[] priorityQueueArray) {
        if (k > priorityQueue.size()){
            return true;
        }
        // calculo para encontrar os filhos de um item k no array
        int left = 2 * k;
        int right = (2 * k) + 1;
        if (left  <= priorityQueue.size() && arraySupport.greater(k, left, priorityQueueArray, null))  {
            return false;
        }
        if (right <= priorityQueue.size() && arraySupport.greater(k, right, priorityQueueArray, null)) {
            return false;
        }
        return isMinHeap(left, priorityQueueArray) && isMinHeap(right, priorityQueueArray);
    }


}
