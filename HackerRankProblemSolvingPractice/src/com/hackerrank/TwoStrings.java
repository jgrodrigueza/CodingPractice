//https://www.hackerrank.com/challenges/two-strings/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class TwoStrings {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        String result = "NO";
        for(char c : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
            int c1 = s1.indexOf(c);
            int c2 = s2.indexOf(c);
            result = (s1.indexOf(c) >= 0 && s2.indexOf(c) >= 0) ? "YES" : "NO";
            if (result.equals("YES")) {
                break;
            }
        }
        return result;
   }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
