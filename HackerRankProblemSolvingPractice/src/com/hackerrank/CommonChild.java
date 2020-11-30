//https://www.hackerrank.com/challenges/common-child/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CommonChild {

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
        int[][] wordMatrix = new int[s1.length()+1][s2.length()+1];
        for (int pos1 = 0; pos1 < s1.length(); pos1++) {
            for (int pos2 = 0; pos2 < s2.length(); pos2++) {
                if (s1.charAt(pos1) == s2.charAt(pos2)) {
                    wordMatrix[pos1 + 1][pos2 + 1] = wordMatrix[pos1][pos2] + 1;
                } else {
                    wordMatrix[pos1+1][pos2 + 1] = Math.max(wordMatrix[pos1 + 1][pos2], wordMatrix[pos1][pos2 + 1]);
                }
            }
        }
        return wordMatrix[s1.length()][s2.length()];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
