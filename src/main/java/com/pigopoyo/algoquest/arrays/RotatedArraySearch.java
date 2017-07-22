package com.pigopoyo.algoquest.arrays;

public class RotatedArraySearch<T extends Comparable<T>> {

    public int search(T[] array, T target) {
        if (array == null || target == null ) {
            return -1;
        }

        for (int i = 0 , j = array.length-1; i<=j;) {
            int mid = i + (j-i)/2;
            if (target.compareTo(array[mid]) == 0) {
                return mid;
            }
            if (array[i].compareTo(array[mid]) <= 0) {
                if (array[i].compareTo(target) <= 0 && target.compareTo(array[mid]) < 0) {
                    j = mid - 1;
                }
                else {
                    i = mid + 1;
                }
            }
            else {
                if (array[mid].compareTo(target) < 0 && target.compareTo(array[j]) <= 0) {
                    i = mid + 1;
                }
                else {
                    j = mid - 1;
                }
            }

        }
        return -1;
    }
}
