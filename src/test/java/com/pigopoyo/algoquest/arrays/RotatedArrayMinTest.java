package com.pigopoyo.algoquest.arrays;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RotatedArrayMinTest {
    @Test
    public void getMin() throws Exception {

        Assert.assertEquals(-3, new RotatedArrayMin<Integer>().getMin(new Integer[]{5,6,7,8,9,10,11,12,13,14,15,16,17,-3,-2,-1,0,1,2,3,4,5}).intValue());

    }

}