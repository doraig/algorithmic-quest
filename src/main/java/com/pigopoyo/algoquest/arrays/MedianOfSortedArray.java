package com.pigopoyo.algoquest.arrays;

/**
 * Created by zenmaster on 7/9/2017.
 */
public class MedianOfSortedArray {


    public double getMedian(int[] input1, int[] input2) {

        if (input1 == null && input2 == null) {
            return 0.0;
        }
        if (input1 == null) {
            if (input2.length % 2 == 0) {
                int val = input2.length/2;
                return (input2[val] + input2[val - 1])/2;
            }
        }
        else if (input2 == null) {
            if (input1.length % 2 == 0) {
                int val = input1.length/2;
                return (input1[val] + input1[val - 1])/2;
            }
        }





        return 0.0;
    }

}
