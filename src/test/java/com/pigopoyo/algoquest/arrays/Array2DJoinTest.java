package com.pigopoyo.algoquest.arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Gopiraj Dorairaj on 7/7/2017.
 */
public class Array2DJoinTest {

    private String menus[][];

    private String preferences[][];
    @Before
    public void setUp() throws Exception {
        menus = new String[][]{{"Indian", "Masala"},{"Indian","Curry"}, {"Italian","Pasta"}};
        preferences = new String[][]{{"Indian","John"}, {"*","Sam"}, {"Italian","Peter"}};

    }

    @After
    public void tearDown() throws Exception {
        menus = null;
        preferences = null;
    }

    @Test
    public void joinArrayData() throws Exception {
        String[][] mergedData = new Array2DJoin().joinArrayData(menus,preferences);
        Assert.assertEquals("Row count is invalid!",6, mergedData.length);
        //Get the rows.
        String[] row1 = mergedData[0];
        String[] row2 = mergedData[1];
        String[] row3 = mergedData[2];
        String[] row4 = mergedData[3];
        String[] row5 = mergedData[4];
        String[] row6 = mergedData[5];
        Assert.assertArrayEquals("Array join errored at row 1!",
                new String[]{"John","Curry"},row1);
        Assert.assertArrayEquals("Array join errored at row 2!",
                new String[]{"John","Masala"},row2);
        Assert.assertArrayEquals("Array join errored at row 3!",
                new String[]{"Sam","Pasta"},row3);
        Assert.assertArrayEquals("Array join errored at row 4!",
                new String[]{"Sam","Curry"},row4);
        Assert.assertArrayEquals("Array join errored at row 5!",
                new String[]{"Sam","Masala"},row5);
        Assert.assertArrayEquals("Array join errored at row 6!",
                new String[]{"Peter","Pasta"},row6);
        Assert.assertArrayEquals("Array join errored all rows!", new String[][]{
                {"John","Curry"},
                {"John","Masala"},
                {"Sam","Pasta"},
                {"Sam","Curry"},
                {"Sam","Masala"},
                {"Peter","Pasta"},
                }, mergedData);
    }

}