package com.pigopoyo.algoquest.sort;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zenmaster on 7/16/2017.
 */
public class MergeSortTest {
    @Test
    public void mergeSort() throws Exception {
        MergeSort<Integer> integerQuickSort = new MergeSort<>();
        Integer[] array = new Integer[] {4, 5, 2, 6, 1, 3, 10, 2};
        integerQuickSort.mergeSort(array);
        Assert.assertArrayEquals(new Integer[] {1,2,2,3,4,5,6,10},array);
    }

}