package com.pigopoyo.algoquest.arrays;

public class RotatedArrayMin<T extends  Comparable<T>> {

    public T getMin(T[] array) {
        if (array == null || array.length ==0) {
            return null;
        }
        int i = 0;
        int j = array.length-1;
        int index = 0;
        while (i <=j) {
            while(array[i] == array[j] && i!=j) {
                i++;
            }
            System.out.println("Pass : "+index++);
            int mid = (i+j)/2;
            if (array[i].compareTo(array[j]) <=0) {
                return array[i];
            }
            if (array[mid].compareTo(array[i]) >= 0) {
                i = mid + 1;
            }
            else {
                j = mid;
            }

        }
        return null;
    }
}
