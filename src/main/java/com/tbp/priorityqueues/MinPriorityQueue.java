package com.tbp.priorityqueues;


import com.tbp.priorityqueues.support.ArraySupport;


import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MinPriorityQueue<Key> implements PriorityQueue<Key> {
    private Key[] priorityQueue; // store items at indices 1 to itemsLoaded
    private int itemsLoaded;                       // number of items on priority queue
    private Comparator<Key> comparator;  // optional comparator

    // array support operations
    private ArraySupport<Key> arraySupport;



    public MinPriorityQueue(int initCapacity) {
        this.priorityQueue = (Key[]) new Object[initCapacity + 1];
        this.itemsLoaded = 0;
        this.arraySupport = new ArraySupport<Key>();
    }

    public MinPriorityQueue() {
        this(1);
    }

    public MinPriorityQueue(int initCapacity, Comparator<Key> comparator) {
        this.comparator = comparator;
        this.priorityQueue = (Key[]) new Object[initCapacity + 1];
        this.itemsLoaded = 0;
        this.arraySupport = new ArraySupport<Key>();
    }


    public MinPriorityQueue(Comparator<Key> comparator) {
        this(1, comparator);
    }

    @Override
    public boolean isEmpty() {
        return itemsLoaded == 0;
    }

    @Override
    public int size() {
        return itemsLoaded;
    }

    @Override
    public void insert(Key element) {
        // double size of array if necessary
        if (itemsLoaded == priorityQueue.length - 1) {
            priorityQueue = arraySupport.resize(2 * priorityQueue.length, itemsLoaded, priorityQueue);
        }
        // add x, and percolate it up to maintain heap invariant
        itemsLoaded = itemsLoaded + 1;
        priorityQueue[itemsLoaded] = element;
        swim(itemsLoaded);

    }

    @Override
    public Key pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue underflow");
        }
        return priorityQueue[1];
    }

    @Override
    public Key delete() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue underflow");
        }
        arraySupport.exch(1, itemsLoaded, priorityQueue);
        Key min = priorityQueue[itemsLoaded--];
        sink(1);
        priorityQueue[itemsLoaded +1] = null;         // avoid loitering and help with garbage collection
        if ((itemsLoaded > 0) && (itemsLoaded == (priorityQueue.length - 1) / 4)){
            priorityQueue = arraySupport.resize(priorityQueue.length / 2, itemsLoaded, priorityQueue);
        }
        return min;
    }

    @Override
    public Iterator<Key> iterator() {
        return new HeapIterator();
    }

    private void swim(int k) {
        while (k > 1 && arraySupport.greater(k / 2, k, priorityQueue, comparator)) {
            arraySupport.exch(k, k / 2, priorityQueue);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= itemsLoaded) {
            int j = 2*k;
            if (j < itemsLoaded && arraySupport.greater(j, j + 1, priorityQueue, comparator)) {
                j++;
            }
            if (!arraySupport.greater(k, j, priorityQueue, comparator)){
                break;
            }
            arraySupport.exch(k, j, priorityQueue);
            k = j;
        }
    }

    private class HeapIterator implements Iterator<Key> {
        // create a new priorityQueue
        private MinPriorityQueue<Key> copy;

        // add all items to copy of heap
        // takes linear time since already in heap order so no keys move
        public HeapIterator() {
            if (comparator == null) {
                copy = new MinPriorityQueue<Key>(size());
            }
            else {
                copy = new MinPriorityQueue<Key>(size(), comparator);
            }
            for (int i = 1; i <= itemsLoaded; i++){
                copy.insert(priorityQueue[i]);
            }
        }

        public boolean hasNext()  {
            return !copy.isEmpty();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Key next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return copy.delete();
        }
    }





}
