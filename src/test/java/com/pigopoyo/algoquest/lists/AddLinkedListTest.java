package com.pigopoyo.algoquest.lists;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * Created by Gopiraj Dorairaj on 7/7/2017.
 */
public class AddLinkedListTest {
    LinkedList<Integer> first = null;
    LinkedList<Integer> second = null;
    @Before
    public void setUp() throws Exception {
        first = new LinkedList<>();
        second = new LinkedList<>();
    }

    @After
    public void tearDown() throws Exception {
        first = null;
        second = null;
    }

    @Test
    public void addTwoListsInput1() throws Exception {
        first.add(2);
        first.add(4);
        first.add(3);
        second.add(5);
        second.add(6);
        second.add(4);
        LinkedList<Integer> addedList = new AddLinkedList().addTwoLists(first, second);
        Assert.assertArrayEquals("Invalid output for the addition of two numbers in input 1",
                new Integer[]{7,0,8}, addedList.stream().toArray(Integer[]::new));
    }

    @Test
    public void addTwoListsInput2() throws Exception {
        first.add(2);
        first.add(4);
        first.add(3);
        second.add(5);
        second.add(9);
        second.add(9);
        LinkedList<Integer> addedList = new AddLinkedList().addTwoLists(first, second);
        Assert.assertArrayEquals("Invalid output for the addition of two numbers  in input 2",
                new Integer[]{7, 3, 3, 1}, addedList.stream().toArray(Integer[]::new));
    }

}