package com.pigopoyo.algoquest.sort;

/**
 * Created by zenmaster on 7/16/2017.
 */
public class QuickSort<T extends Comparable<T>> {

    public void quickSort(T[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(T[] array, int left, int right) {

        if (left >= right) {
            return;
        }
        T pivot = array[(left+right)/2];
        int partition = partition(array, left, right, pivot);
        quickSort(array, left, partition - 1);
        quickSort(array, partition, right);

    }

    private int partition(T[] array, int left, int right, T pivot) {

        while (left <= right) {

            while (array[left].compareTo(pivot) < 0) {
                left++;
            }

            while (array[right].compareTo(pivot) > 0) {
                right--;
            }

            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;

    }

    private void swap(T[] array, int left, int right) {
        T temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }


}
