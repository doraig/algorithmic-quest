package com.pigopoyo.algoquest.arrays;

public class QuickSelect {
        public static int selectIterative(int[] array, int n) {
            return iterative(array, 0, array.length - 1, n);
        }

        private static int iterative(int[] array, int left, int right, int n) {
            if(left == right) {
                return array[left];
            }

            for(;;) {
                int pivotIndex = randomPivot(left, right);
                pivotIndex = partition(array, left, right, pivotIndex);

                if(n == pivotIndex) {
                    return array[n];
                } else if(n < pivotIndex) {
                    right = pivotIndex - 1;
                } else {
                    left = pivotIndex + 1;
                }
            }
        }

        /**
         *	In quicksort, we recursively sort both branches, leading to best-case
         *	Ω(n log n) time. However, when doing selection, we already know which
         *	partition our desired element lies in, since the pivot is in its final
         *	sorted position, with all those preceding it in an unsorted order and
         *	all those following it in an unsorted order. Therefore, a single
         *	recursive call locates the desired element in the correct partition, and
         *	we build upon this for quickselect.
         */
        public static int selectRecursive(int[] array, int n) {
            return recursive(array, 0, array.length - 1, n);
        }

        // Returns the n-th smallest element of list within left..right inclusive
        // (i.e. left <= n <= right).
        // The size of the list is not changing with each recursion.
        // Thus, n does not need to be updated with each round.
        private static int recursive(int[] array, int left, int right, int n) {
            if (left == right) { // If the list contains only one element,
                return array[left]; // return that element
            }

            // select a pivotIndex between left and right
            int pivotIndex = randomPivot(left, right);
            pivotIndex = partition(array, left, right, pivotIndex);
            // The pivot is in its final sorted position
            if (n == pivotIndex) {
                return array[n];
            } else if (n < pivotIndex) {
                return recursive(array, left, pivotIndex - 1, n);
            } else {
                return recursive(array, pivotIndex + 1, right, n);
            }
        }

        /**
         *	In quicksort, there is a subprocedure called partition that can, in
         *	linear time, group a list (ranging from indices left to right) into two
         *	parts, those less than a certain element, and those greater than or
         *	equal to the element. Here is pseudocode that performs a partition about
         *	the element list[pivotIndex]
         */
        private static int partition(int[] array, int left, int right, int pivotIndex) {
            int pivotValue = array[pivotIndex];
            swap(array, pivotIndex, right); // move pivot to end
            int storeIndex = left;
            for(int i = left; i < right; i++) {
                if(array[i] < pivotValue) {
                    swap(array, storeIndex, i);
                    storeIndex++;
                }
            }
            swap(array, right, storeIndex); // Move pivot to its final place
            return storeIndex;
        }

        private static void swap(int[] array, int a, int b) {
            int tmp = array[a];
            array[a] = array[b];
            array[b] = tmp;
        }

        private static int randomPivot(int left, int right) {
            return left + (int) Math.floor(Math.random() * (right - left + 1));
        }

        public static void main(String[] args) {
            int[] array = { 16, 10, 15, 8, 3, 35,84 ,14,9 };// {9, 8, 7, 6, 5, 0, 1, 2, 3, 4};

            //for(int i = 0; i < array.length; i++) {
                System.out.println(selectIterative(array, array.length/2));
            //}

           /* for(int i = 0; i < array.length; i++) {
                System.out.println(selectRecursive(array, i));
            }*/
        }

}
