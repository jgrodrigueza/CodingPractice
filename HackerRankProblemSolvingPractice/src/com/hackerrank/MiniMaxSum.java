//https://www.hackerrank.com/challenges/mini-max-sum/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MiniMaxSum {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        Arrays.sort(arr);
        long sumMin = 0;
        long sumMax = 0;
        for (int pos = 0; pos <= 3; pos++){
            sumMin = sumMin + arr[pos];
        }
        for (int pos = arr.length - 4; pos <= arr.length - 1; pos++) {
            sumMax = sumMax + arr[pos];
        }
        System.out.println(sumMin + " " + sumMax);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}

