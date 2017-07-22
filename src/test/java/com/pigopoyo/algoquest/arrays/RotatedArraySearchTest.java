package com.pigopoyo.algoquest.arrays;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RotatedArraySearchTest {
    @Test
    public void search() throws Exception {
        Assert.assertEquals(2, new RotatedArraySearch<Integer>().search(new Integer[]{5,6,7,-2,-1,0,3},7));
    }

}