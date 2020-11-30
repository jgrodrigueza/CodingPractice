//https://www.hackerrank.com/challenges/strange-advertising/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ViralAdvertising {

    // Complete the viralAdvertising function below.
    static int viralAdvertising(int n) {
        int recipients = 5;
        int liked = recipients / 2; //As type is intger, value will be truncated.
        int friends = 3;
        int cumulative = liked;
        for (int day = 2; day <= n; day++) { //Start at day 2, as day 1 values are the initializing values.
            recipients = liked * friends;
            liked = recipients / 2;
            cumulative+=liked;
        }
        return cumulative;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = viralAdvertising(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

