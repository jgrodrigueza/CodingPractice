//https://www.hackerrank.com/challenges/equality-in-a-array/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class EqualizeTheArray {

    // Complete the equalizeArray function below.
    static int equalizeArray(int[] arr) {
        int maxNum = 0;
        int maxPos = Integer.MIN_VALUE;
        int minNum = 0;
        int[] indexes = new int[101];
        for (int pos : arr) {
            indexes[pos]++;
            if (indexes[pos] > maxNum) {
                maxNum = indexes[pos];
                maxPos = pos;
            }
        }
        for (int min = 0; min < indexes.length; min++) {
            if (min != maxPos) {
                minNum+=indexes[min];
            }
        }
        return minNum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = equalizeArray(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
