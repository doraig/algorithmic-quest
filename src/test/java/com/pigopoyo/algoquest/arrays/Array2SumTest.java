package com.pigopoyo.algoquest.arrays;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Gopiraj Dorairaj on 7/7/2017.
 */
public class Array2SumTest {


    @Test
    public void getSumIndices() throws Exception {

        int[] input = {2, 11, 7, 15};
        int result = 9;

        Assert.assertArrayEquals("Invalid sum indices for input 1",
                new int[]{0,2},new Array2Sum().getSumIndices(input,result));

    }


    @Test
    public void getSumIndicesInput2() throws Exception {

        int[] input = {2, 7, 11, 15};
        int result = 18;

        Assert.assertArrayEquals("Invalid sum indices for input 2",
                new int[]{1,2},new Array2Sum().getSumIndices(input,result));

    }

    @Test
    public void getSumIndicesInput3() throws Exception {

        int[] input = {11, 7, 2, 15};
        int result = 26;

        Assert.assertArrayEquals("Invalid sum indices for input 2",
                new int[]{0,3},new Array2Sum().getSumIndices(input,result));

    }

    @Test
    public void getSumIndicesNullInput() throws Exception {

        int[] input = null;
        int result = 26;

        Assert.assertNull("Invalid sum indices for null input",new Array2Sum().getSumIndices(input,result));

    }

    @Test
    public void getSumIndicesMissingResult() throws Exception {

        int[] input = {11, 7, 2, 15};;
        int result = 0;

        Assert.assertNull("Invalid sum indices for missing result",
                new Array2Sum().getSumIndices(input,result));
    }
}