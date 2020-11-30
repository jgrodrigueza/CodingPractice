//https://www.hackerrank.com/challenges/funny-string/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FunnyString {

    // Complete the funnyString function below.
    static String funnyString(String s) {
        String ret = "Funny";
        String r = new StringBuilder(s).reverse().toString();
        int[] sDiff = new int[s.length() - 1];
        int[] rDiff = new int[r.length() - 1];
        for (int pos = 1; pos < s.length(); pos++) {
            sDiff[pos - 1] = Math.abs((int) s.charAt(pos) - (int) s.charAt(pos - 1));
            rDiff[pos - 1] = Math.abs((int) r.charAt(pos) - (int) r.charAt(pos - 1));
            if (rDiff[pos - 1] != sDiff[pos - 1]) { //If at some point a value is different, the string is "Not funny" and we can exit the loop.
                ret = "Not Funny";
                break;
            }
        }
        return ret;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            String result = funnyString(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
