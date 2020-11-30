//https://www.hackerrank.com/challenges/closest-numbers/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ClosestNumbers {

    // Complete the closestNumbers function below.
    static int[] closestNumbers(int[] arr) {
        Arrays.sort(arr);
        List<Integer> diffs = new ArrayList<Integer>();
        List<String> pairs = new ArrayList<String>(); 
        List<Integer> result = new ArrayList<Integer>();
        for (int pos = 0; pos <= arr.length - 2; pos++) {
            int diff = Math.abs(arr[pos + 1] - arr[pos]);
            diffs.add(diff);
            pairs.add(arr[pos] + "," + arr[pos + 1] + "," + diff);
        }
        Collections.sort(diffs);
        for (String pair : pairs) {
            if (pair.split(",")[2].equals(String.valueOf(diffs.get(0)))) {
                result.add(Integer.parseInt(pair.split(",")[0]));
                result.add(Integer.parseInt(pair.split(",")[1]));
                //System.out.print(pair.split(",")[0] + " " + pair.split(",")[1]);
            }
        }
        return result.stream().mapToInt(i->i).toArray();    }

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

        int[] result = closestNumbers(arr);

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
