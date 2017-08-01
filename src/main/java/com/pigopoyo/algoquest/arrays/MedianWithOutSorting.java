package com.pigopoyo.algoquest.arrays;

public class MedianWithOutSorting {


        public static void main(String[] args){
            int[] a =  { 16, 10, 15, 8, 3, 35,84 ,14 };//{1,9,-4,7,6,11,3,2,10};
            int median;

            median = new MedianWithOutSorting().findMedian(a,0,a.length-1);
            if(a.length%2 != 0)
                System.out.print("the median is : "+a[median]);
            else
                System.out.print("the median is : "+(a[median] + a[median + 1])/2 );
        }
        public int findMedian(int[] a,int left,int right){
            int index = 0;
            int mid = (left+right)/2;
            index = partition(a,left,right);
            while( index != mid){
                if(index < mid)
                    index = partition(a,mid,right);
                else index = partition(a,left,mid);
            }
            return index;
        }
        public int partition(int[] a,int i,int j ){
            int pivot = (i+j)/2;
            int temp;
            while(i <= j){
                while(a[i] < a[pivot])
                    i++;
                while(a[j] > a[pivot])
                    j--;
                if(i <= j){
                    temp = a[i];
                    a[i]=a[j];
                    a[j] = temp;
                    i++;j--;
                }
            }
            return pivot;
        }

}
