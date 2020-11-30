//https://www.hackerrank.com/challenges/missing-numbers/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MissingNumbers {

    // Complete the missingNumbers function below.
    static int[] missingNumbers(int[] arr, int[] brr) {
        List<Integer> missingL = new ArrayList<Integer>();
        Map<Integer, Integer> original = new HashMap<Integer, Integer>();
        Map<Integer, Integer> resulting = new HashMap<Integer, Integer>();
        for (int pos = 0; pos < brr.length; pos++) {
            if (original.containsKey(brr[pos])) {
                original.put(brr[pos], original.get(brr[pos]).intValue() + 1);
            } else {
                original.put(brr[pos], 1);
            }
        }
        for (int pos = 0; pos < arr.length; pos++) {
            if (resulting.containsKey(arr[pos])) {
                resulting.put(arr[pos], resulting.get(arr[pos]).intValue() + 1);
            } else {
                resulting.put(arr[pos], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : original.entrySet()) {
            if (resulting.get(entry.getKey()) == null) {
                missingL.add(entry.getKey());
            } else if (resulting.get(entry.getKey()) < entry.getValue()) {
                missingL.add(entry.getKey());
            }
        }
        Collections.sort(missingL);
        return missingL.stream().mapToInt(i->i).toArray();
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

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] brr = new int[m];

        String[] brrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int brrItem = Integer.parseInt(brrItems[i]);
            brr[i] = brrItem;
        }

        int[] result = missingNumbers(arr, brr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

