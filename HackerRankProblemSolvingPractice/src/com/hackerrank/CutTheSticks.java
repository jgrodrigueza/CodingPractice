//https://www.hackerrank.com/challenges/cut-the-sticks/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class CutTheSticks {

    // Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] arr) {
        List<Integer> res = new ArrayList<Integer>();
        List<Integer> ints = new ArrayList<Integer>();
        int sticks = 0;
        int size = arr.length;
        res.add(arr.length); //First output is always the initial array.
        ints.addAll(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        Collections.sort(ints);
        while (ints.size() > 0) {
            int cutSize = ints.get(0); //As it is sorted, position 0 has the shortest stick.
            for (int pos = 0; pos < ints.size(); pos++) {
                ints.set(pos, ints.get(pos) - cutSize);
                if (ints.get(pos) == 0) {
                    ints.remove(pos); //If the item is 0 after cutting, remove from list.
                    pos--;
                }
            }
            if (ints.size() > 0) {
                res.add(ints.size());
            }
        }
        int[] ret = new int[res.size()];
        for (int pos = 0; pos < res.size(); pos++) {
            ret[pos] = res.get(pos);
        }
        return ret;
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

        int[] result = cutTheSticks(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
