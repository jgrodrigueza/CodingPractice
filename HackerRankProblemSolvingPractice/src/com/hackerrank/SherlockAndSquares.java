//https://www.hackerrank.com/challenges/sherlock-and-squares/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SherlockAndSquares {

    // Complete the squares function below.
    static int squares(int a, int b) {
        boolean inRange = true;
        int sqrs = 0;
        int num = a;
        double root = 0;
        int intRoot = 0;
        for (num = a; num <= b; num++) {
            root = Math.sqrt(Double.valueOf(num));
            intRoot = (int) root;
            if (intRoot == root) {
                break; //Find the first exact square root and break;
            }
            if (num == b) {
                inRange = false; //If the upper limit is reached and no exact root was found, set to false to prevent further validation.
            }
        }
        while (inRange == true) {
            if (intRoot * intRoot <= b) {
                sqrs++;
            } else {
                inRange = false;
                break; //If the result of the operation is higher than the upper limit, exit the loop.
            }
            intRoot++;
        }
        return sqrs;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] ab = scanner.nextLine().split(" ");

            int a = Integer.parseInt(ab[0]);

            int b = Integer.parseInt(ab[1]);

            int result = squares(a, b);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
