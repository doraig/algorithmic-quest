package com.pigopoyo.algoquest.arrays;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.IntStream;

public class BridFrequency {


    static int migratoryBirds(int n, int[] ar) {

        int countarr[]  = new int[6];
       /* IntStream.range(0, countarr.length).forEach(i -> countarr[i]=0);
        Arrays.stream(ar).forEach(x -> countarr[x]++);
        Stack<Integer> integerStack = new Stack<>();
        IntStream.range(1, countarr.length).forEach(i ->  {
            if (integerStack.isEmpty()) {
                integerStack.push(countarr[i]);
            }
            else if (integerStack.peek().intValue() <  countarr[i]) {
               integerStack.push(countarr[i]);
               countarr[0] = i;
            }
        });*/
        return countarr[0];

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = migratoryBirds(n, ar);
        System.out.println(result);
    }
}
