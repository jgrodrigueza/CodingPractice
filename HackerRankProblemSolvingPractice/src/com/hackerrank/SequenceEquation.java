//https://www.hackerrank.com/challenges/permutation-equation/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class SequenceEquation {

    // Complete the permutationEquation function below.
    static int[] permutationEquation(int[] p) {
        int[] ret = new int[p.length];
        List<Integer> list = new ArrayList<Integer>();
        list.add(Integer.MIN_VALUE);
        list.addAll(Arrays.stream(p).boxed().collect(Collectors.toList()));
        List<Integer> ordered = new ArrayList<Integer>();
        ordered.add(Integer.MIN_VALUE);
        ordered.addAll(Arrays.stream(p).boxed().collect(Collectors.toList()));
        Collections.sort(ordered);
        int pos = Integer.MIN_VALUE;
        for (int num = 1; num < ordered.size(); num++) {
            pos = list.indexOf(num);
            ret[num - 1] = list.indexOf(pos);
        }
        return ret;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] p = new int[n];

        String[] pItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(pItems[i]);
            p[i] = pItem;
        }

        int[] result = permutationEquation(p);

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
