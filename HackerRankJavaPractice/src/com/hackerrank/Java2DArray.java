//https://www.hackerrank.com/challenges/java-2d-array/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Java2DArray {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];
        int largestSum = Integer.MIN_VALUE; //As the sum may be negative, we assign the smallest possible value for comparison.
        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
                if (i > 1 && j > 1) {
                    int sum =
                          arr[i][j]
                        + arr[i][j-1]
                        + arr[i][j-2]
                        + arr[i-1][j-1]
                        + arr[i-2][j]
                        + arr[i-2][j-1]
                        + arr[i-2][j-2];
                    if (sum > largestSum) {
                        largestSum = sum;
                    }
                }
            }
        }
        scanner.close();
        System.out.println(largestSum);
    }
}
