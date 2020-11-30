//https://www.hackerrank.com/challenges/strange-code/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class StrangeCounter {

    // Complete the strangeCounter function below.
    static long strangeCounter(long t) {
        long initial = 3;
        long iniVal = initial;
        long strTime = 1;
        long endTime = strTime + initial - 1;
        boolean reachedTime = false;
        while (reachedTime == false) {
            //System.out.println(strTime + " - " + iniVal + " / " + endTime);
            if (strTime <= t && t <= endTime) {
                long diff = t - strTime;
                iniVal-=diff;
                reachedTime = true;
                break;
            } else {
                strTime+=initial;
                initial*=2;
                endTime = strTime + initial - 1;
                iniVal = initial;
            }
        }
        return iniVal;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        long t = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = strangeCounter(t);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
