package com.tbp.unionfind.support;


public class ArrayValidator {


    /**
     * Validade if the array conrains an index
     * @param index
     * @param array
     */
    public static void validate(int index, int[] array) {
        int N = array.length;
        if (index < 0 || index >= N) {
            throw new IndexOutOfBoundsException("index " + index + " is not between 0 and " + N);
        }
    }

}
