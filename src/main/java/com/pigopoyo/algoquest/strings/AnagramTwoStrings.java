package com.pigopoyo.algoquest.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gopiraj Dorairaj on 7/4/2017.
 */
public class AnagramTwoStrings {

   /**
     * Finds the starting indexs of  the anagrams contained in the parent string.
     * @param pHaystack
     * @param qNeedle
     * @return
     */
    public List<Integer> findAnagramIndices(String pHaystack, String qNeedle) {

        int[] hash = new int[256];
        qNeedle.chars().forEach(value -> hash[value]++);
        int count = qNeedle.length();
        List<Integer> integers =  new ArrayList<>();
        for (int left = 0,right = 0; right < pHaystack.length();) {

            if (hash[pHaystack.charAt(right++)]-->=1) {
                count--;
            }
            if (count == 0) {
                integers.add(left);
            }
            if ( right - left == qNeedle.length() && hash[pHaystack.charAt(left++)]++ >=0 ) {
                count++;
            }

        }

        return integers;
    }


}
