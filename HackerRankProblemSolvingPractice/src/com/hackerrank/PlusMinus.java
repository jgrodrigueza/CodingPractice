//https://www.hackerrank.com/challenges/plus-minus/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class PlusMinus {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        DecimalFormat decFormat = new DecimalFormat("0.000000");
        double negCount = 0;
        double zerCount = 0;
        double posCount = 0;
        for (int pos = 0; pos < arr.length; pos++) {
            if (arr[pos] < 0) {
                negCount++;
            } else if (arr[pos] == 0) {
                zerCount++;
            } else if (arr[pos] > 0) {
                posCount++;
            }
        }
        System.out.println(decFormat.format(posCount / arr.length));
        System.out.println(decFormat.format(negCount / arr.length));
        System.out.println(decFormat.format(zerCount / arr.length));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
