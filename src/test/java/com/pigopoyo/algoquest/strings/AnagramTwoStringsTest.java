package com.pigopoyo.algoquest.strings;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Gopiraj Dorairaj on 7/7/2017.
 */
public class AnagramTwoStringsTest {
    private String hayStack;

    private String needle;

    @Before
    public void setUp() throws Exception {
        hayStack = "abccbdbca";
        needle = "abc";

    }

    @After
    public void tearDown() throws Exception {
        hayStack = null;
        needle = null;
    }

    @Test
    public void findAnagramIndices() throws Exception {
        Assert.assertArrayEquals("Anagram check errored!",new Integer[]{0,6},
                new AnagramTwoStrings().findAnagramIndices(hayStack, needle).stream().toArray(Integer[]::new));
    }

}