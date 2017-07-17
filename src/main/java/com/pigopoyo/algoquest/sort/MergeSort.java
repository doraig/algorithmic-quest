package com.pigopoyo.algoquest.sort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.function.Supplier;

/**
 * Created by zenmaster on 7/16/2017.
 */
public class MergeSort<T extends  Comparable<T>> {

    Supplier<T[]> supplier;

    public void mergeSort(T[] array) throws InstantiationException, IllegalAccessException {

        mergeSort(array, getArray(array), 0, array.length-1);
    }

    private  T[] getArray(T[] array) throws IllegalAccessException, InstantiationException {
        return (T[]) Array.newInstance(array[0].getClass(), array.length);
    }

    private void mergeSort(T[] array, T[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return;
        }
        int mid =  (leftStart + rightEnd)/2;
        mergeSort(array,temp, leftStart, mid);
        mergeSort(array,temp, mid+1, rightEnd);
        merge(array, temp, leftStart,rightEnd);

    }

    private void merge(T[] array,T[] temp, int leftStart, int rightEnd) {

        int leftEnd = (leftStart + rightEnd)/2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {

            if (array[left].compareTo(array[right]) <= 0) {
                temp[index] = array[left];
                left++;
            }
            else {
                temp[index] = array[right];
                right++;
            }
            index++;
        }

        System.arraycopy(array,left,temp,index,leftEnd - left + 1);
        System.arraycopy(array,right,temp,index,rightEnd - right + 1);
        System.arraycopy(temp,leftStart,array,leftStart,size);

    }
}
