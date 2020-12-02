//https://www.hackerrank.com/challenges/maximum-subarray-sum/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MaximumSubarraySum {

    // Complete the maximumSum function below.
    static long maximumSum(long[] a, long m) {
        long result = 0;
        TreeSet<Long> prefixTable = new TreeSet<Long>();
        long currentVal = 0;
        for(int pos = 0; pos < a.length; pos++){
            currentVal = (currentVal + a[pos] % m) % m;
            result = Math.max(result, currentVal);
            Long higher = prefixTable.higher(currentVal);
            if (higher != null) {
                result = Math.max(result , (currentVal -higher+m)%m);
            }
            prefixTable.add(currentVal);
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            long m = Long.parseLong(nm[1]);

            long[] a = new long[n];

            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                long aItem = Long.parseLong(aItems[i]);
                a[i] = aItem;
            }

            long result = maximumSum(a, m);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
