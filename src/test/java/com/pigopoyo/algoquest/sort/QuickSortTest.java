package com.pigopoyo.algoquest.sort;


import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zenmaster on 7/16/2017.
 */
public class QuickSortTest {
    @Test
    public void quickSortInteger() throws Exception {
        QuickSort<Integer> integerQuickSort = new QuickSort<>();
        Integer[] array = new Integer[] {4, 5, 2, 6, 1, 3, 10, 2};
        integerQuickSort.quickSort(array);
        Assert.assertArrayEquals(new Integer[] {1,2,2,3,4,5,6,10},array);
    }

    @Test
    public void quickSortString() throws Exception {
        QuickSort<String> integerQuickSort = new QuickSort<>();
        String[] array = new String[] {"e", "f", "g", "a", "b", "d", "c", "h"};
        integerQuickSort.quickSort(array);
        Assert.assertArrayEquals(new String[] {"a", "b", "c", "d", "e", "f", "g", "h"},array);
    }

}