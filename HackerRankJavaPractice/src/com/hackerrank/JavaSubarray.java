//https://www.hackerrank.com/challenges/java-negative-subarray/problem
	
package com.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class JavaSubarray {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int negatives = 0;
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int num = 0; num < n; num++) {
            arr[num] = input.nextInt();
        }
        for (int pos = 0; pos < arr.length; pos++) {
            int sum = arr[pos];
            if (arr[pos] < 0) { //Single cells is also a subarray.
                negatives++;
            }
            for (int pos1 = pos + 1; pos1 < arr.length; pos1++) {
                sum = sum + arr[pos1];
                if (sum < 0) {
                    negatives++;
                }
            }
        }
        System.out.print(negatives);
    }
}
