//https://www.hackerrank.com/challenges/minimum-distances/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class MinimumDistances {

    // Complete the minimumDistances function below.
    static int minimumDistances(int[] a) {
        List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
        int minDistance = list.size(); //Initialize in a number higher than the possible maximum distance.
        for (int pos = 0; pos < list.size() - 1; pos++) {
            List<Integer> list2 = list.subList(pos + 1, list.size());
            int num1 = list.get(pos);
            if (list2.contains(num1)) {
                int index2 = list2.indexOf(num1) + (pos + 1); //We sum the amount of items removed from the original list to get the item's position in the original list.
                minDistance = Math.min(Math.abs(minDistance), Math.abs(index2 - pos));
            }
        }
        return (minDistance < list.size()) ? minDistance : -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int result = minimumDistances(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
