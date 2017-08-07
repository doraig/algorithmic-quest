package com.pigopoyo.algoquest.arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zenmaster on 7/9/2017.
 */
public class MedianOfSortedArrayTest {
    int[] input1 = null;

    int[] input2 = null;

    @Before
    public void setUp() throws Exception {
        input1 = new int[]{1, 3};
        input2 = new int[]{2};

    }

    @After
    public void tearDown() throws Exception {
        input1 = input2 = null;
    }

    @Test
    public void getMedian() throws Exception {
        //Assert.assertEquals(2.0, new MedianOfSortedArray().getMedian(input1, input2),0);
    }

}