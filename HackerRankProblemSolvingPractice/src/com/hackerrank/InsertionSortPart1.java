//https://www.hackerrank.com/challenges/insertionsort1/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class InsertionSortPart1 {

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - 1) {
                System.out.print(arr[i] + " ");
            } else {
                System.out.print(arr[i]);
            }
        }
        System.out.println("");
    }

    // Complete the insertionSort1 function below.
    static void insertionSort1(int n, int[] arr) {
        int num = arr[arr.length - 1]; //Store the value we need.
        for (int pos = arr.length - 1; pos >= 0; pos--) {
            if (pos == 0) {
                arr[pos] = num;
                print(arr);
                break;
            }
            if (arr[pos - 1] >= num) {
                arr[pos] = arr[pos - 1];
                print(arr);
            } else {
                arr[pos] = num;
                print(arr);
                break;
            }
        }
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

        insertionSort1(n, arr);

        scanner.close();
    }
}
