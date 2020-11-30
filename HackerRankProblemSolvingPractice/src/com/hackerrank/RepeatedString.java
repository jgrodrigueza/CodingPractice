//https://www.hackerrank.com/challenges/repeated-string/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long count = 0;
        if (s.equals("a")) {
            return n; //If s is one characters only, it will repeat n times.
        } else {
            if (s.contains("a")) { //If there are a's in the string, process, else return 0;
                for (int pos = 0; pos < s.length(); pos++) {
                    if (s.charAt(pos) == 'a') {
                        count++;
                    }
                }
                long times = (n / s.length()) + 1;
                int sPos = s.length() - 1;
                count = count * times;
                for (long pos = (s.length() * times); pos > n; pos--) { //Take the length of the infinite and remove the a's in position higher than n.
                    if (s.charAt(sPos) == 'a') {
                        count--;
                    }
                    sPos--;
                }
            } else { //Returns 0 if there are no a's in the string.
                return 0;
            }
        }
        return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
