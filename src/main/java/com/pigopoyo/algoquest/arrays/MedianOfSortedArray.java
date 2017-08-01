package com.pigopoyo.algoquest.arrays;

/**
 * Created by zenmaster on 7/9/2017.
 */
public class MedianOfSortedArray {


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length+nums2.length;
        if(total%2==0){
            return ( findKth(total/2+1, nums1, nums2, 0, 0)
                     +findKth(total/2, nums1, nums2, 0, 0) )/2.0;
        }else{
            return findKth(total/2+1, nums1, nums2, 0, 0);
        }
    }

    public int findKth(int k, int[] nums1, int[] nums2, int start1, int start2){
        if(start1>=nums1.length)
            return nums2[start2+k-1];

        if(start2>=nums2.length)
            return nums1[start1+k-1];

        if(k==1)
            return Math.min(nums1[start1], nums2[start2]);

        int m1 = start1+k/2-1;
        int m2 = start2+k/2-1;

        int mid1 = m1<nums1.length?nums1[m1]:Integer.MAX_VALUE;
        int mid2 = m2<nums2.length?nums2[m2]:Integer.MAX_VALUE;

        if(mid1<mid2){
            return findKth(k-k/2, nums1, nums2, m1+1, start2);
        }else{
            return findKth(k-k/2, nums1, nums2, start1, m2+1);
        }
    }

    /**
     * Starting point for the JVM.
     */
    public static void main(String argument[]) {
        System.out.println(new MedianOfSortedArray().findMedianSortedArrays(new int[]{20,900},new int[] {5, 8, 10, 20}));
    }

}
