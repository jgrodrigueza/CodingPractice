//https://www.hackerrank.com/challenges/java-1d-array-introduction/problem

package com.hackerrank;

import java.util.*;

public class Java1DArray {

    public static void main(String[] args) {
	   
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        for (int num = 0; num < n; num++) {
            a[num] = scan.nextInt();
        }
        scan.close();

        // Prints each sequential element in array a
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}