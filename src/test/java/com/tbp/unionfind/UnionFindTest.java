package com.tbp.unionfind;


import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UnionFindTest {

    private int n;
    private UnionFind quickFind;
    private UnionFind quickUnion;

    @Before
    public void doBefore() {
        n = 10;
        quickFind = new QuickFind(n);
        quickUnion = new QuickUnion(n);
    }

    @Test
    public void testIndexOutOfBoundsException() {
         try {
             quickFind.union(-1,1);
             fail("This code should never be executed");
         } catch (IndexOutOfBoundsException e) {
             assertNotNull(e);
         }
        try {
            quickUnion.union(1,-1);
            fail("This code should never be executed");
        } catch (IndexOutOfBoundsException e) {
            assertNotNull(e);
        }
        try {
            quickFind.find(10);
            fail("This code should never be executed");
        } catch (IndexOutOfBoundsException e) {
            assertNotNull(e);
        }
        try {
            quickUnion.find(-10);
            fail("This code should never be executed");
        } catch (IndexOutOfBoundsException e) {
            assertNotNull(e);
        }
        try {
            quickFind.connected(-1,1);
            fail("This code should never be executed");
        } catch (IndexOutOfBoundsException e) {
            assertNotNull(e);
        }
        try {
            quickUnion.connected(1,-1);
            fail("This code should never be executed");
        } catch (IndexOutOfBoundsException e) {
            assertNotNull(e);
        }
    }


    @Test
    public void testInitialization() {
        int i = 0;
        int j = 0;
        while (i < n) {
            assertEquals(i, quickFind.find(i));
            assertEquals(i, quickUnion.find(i));
            while(j < n) {
                if (i != j) {
                    assertFalse(quickFind.connected(i, j));
                    assertFalse(quickUnion.connected(i, j));
                } else {
                    assertTrue(quickFind.connected(i, j));
                    assertTrue(quickUnion.connected(i, j));
                }
                j++;
            }
            i++;
        }
    }

    @Test
    public void testUnionFind() {
        assertEquals(n, quickFind.count());
        assertEquals(n, quickUnion.count());

        // test 1
        assertFalse(quickFind.connected(1,2));
        assertFalse(quickUnion.connected(1,2));
        assertEquals(1, quickFind.find(1));
        assertEquals(1, quickUnion.find(1));
        assertEquals(2, quickFind.find(2));
        assertEquals(2, quickUnion.find(2));
        quickFind.union(1,2);
        quickUnion.union(1,2);
        assertEquals(n - 1, quickFind.count());
        assertEquals(n - 1, quickUnion.count());
        assertTrue(quickFind.connected(1, 2));
        assertTrue(quickUnion.connected(1, 2));
        assertEquals(2, quickFind.find(1));
        assertEquals(2, quickUnion.find(1));
        assertEquals(2, quickFind.find(2));
        assertEquals(2, quickUnion.find(2));


        // test 2
        assertEquals(2, quickFind.find(1));
        assertEquals(2, quickUnion.find(1));
        assertEquals(3, quickFind.find(3));
        assertEquals(3, quickUnion.find(3));
        assertFalse(quickFind.connected(1,3));
        assertFalse(quickUnion.connected(1,3));
        quickFind.union(1,3);
        quickUnion.union(1,3);
        assertEquals(n - 2, quickFind.count());
        assertEquals(n - 2, quickUnion.count());
        assertTrue(quickFind.connected(1,3));
        assertTrue(quickUnion.connected(1,3));
        assertEquals(3, quickFind.find(1));
        assertEquals(3, quickUnion.find(1));
        assertEquals(3, quickFind.find(3));
        assertEquals(3, quickUnion.find(3));

        // test 3
        quickFind.union(1,3);
        quickUnion.union(1,3);
        assertEquals(n - 2, quickFind.count());
        assertEquals(n - 2, quickUnion.count());

        // test 4
        assertEquals(8, quickFind.find(8));
        assertEquals(8, quickUnion.find(8));
        assertEquals(3, quickFind.find(3));
        assertEquals(3, quickUnion.find(3));
        assertFalse(quickFind.connected(8,3));
        assertFalse(quickUnion.connected(8,3));
        quickFind.union(8,3);
        quickUnion.union(8,3);
        assertEquals(n - 3, quickFind.count());
        assertEquals(n - 3, quickUnion.count());
        assertTrue(quickFind.connected(8,3));
        assertTrue(quickUnion.connected(8,3));
        assertEquals(3, quickFind.find(8));
        assertEquals(3, quickUnion.find(8));
        assertEquals(3, quickFind.find(3));
        assertEquals(3, quickUnion.find(3));
    }



}
