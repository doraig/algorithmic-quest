package com.pigopoyo.algoquest.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gopiraj Dorairaj on 7/7/2017.
 * <p>Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class Array2Sum {

    /**
     * Method returns indices of the numbers in the array which  give the result.
     * @param input
     * @param result
     * @return
     */
    public int[] getSumIndices(int[] input, int result) {

        Map<Integer, Integer> intMap = new HashMap<>();
        if (input != null) {
            for (int i = 0; i < input.length; i++) {
                if (intMap.containsKey((result - input[i]))) {
                    return new int[]{intMap.get(result - input[i]), i};
                }
                intMap.put(input[i], i);
            }
        }
        return null;
    }

}
