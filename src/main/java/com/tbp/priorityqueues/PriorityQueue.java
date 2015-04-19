package com.tbp.priorityqueues;


public interface PriorityQueue<Key> extends Iterable<Key>  {

    /**
     * @return Returns true if the queue is empty
     */
    boolean isEmpty();

    /**
     * @return Returns the size of the priority queue
     */
    int size();

    /**
     * Inserts an element in the prioritu queue
     * @param element
     */
    void insert(Key element);

    /**
     * @return Returns the smallest or the largest element in the queue
     * depending on the implementation.
     */
    Key pop();

    /**
     * Removes and returns a largest or the smallest key on the priority queue
     * depending on the implementation.
     * @return largest or smallest key on the priority queue
     * @throws java.util.NoSuchElementException if priority queue is empty.
     */
    public Key delete();

}
