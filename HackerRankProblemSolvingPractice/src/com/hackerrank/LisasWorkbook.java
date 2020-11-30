//https://www.hackerrank.com/challenges/lisa-workbook/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LisasWorkbook {

    // Complete the workbook function below.
    static int workbook(int n, int k, int[] arr) {
        int genPages = 0;
        int special = 0;
        for (int chapter = 0; chapter < arr.length; chapter++) {
            int pages = (arr[chapter] % k != 0) ? (arr[chapter] / k) + 1 : arr[chapter] / k;
            int strProb = 1;
            for (int page = 1; page <= pages; page++) {
                genPages++;
                strProb = (page == 1) ? 1 : strProb + k;
                int endProb = (strProb + k - 1 <= arr[chapter] ? (strProb + k - 1) : arr[chapter]);
                special+=(strProb <= genPages && genPages <= endProb) ? 1 : 0;
            }
        }
        return special;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = workbook(n, k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
