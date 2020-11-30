//https://www.hackerrank.com/challenges/save-the-prisoner/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SaveThePrisoner {

    // Complete the saveThePrisoner function below.
    static int saveThePrisoner(int n, int m, int s) {
        double prisoners = n;
        double sweets = m;
        double chair = s;
        double warn = 0;
        double jump = chair - 1; //The number of chairs that were skipped.
        double turns = Math.ceil((sweets + jump) / prisoners); //The "turn" number in which the last sweet will be handed.
        double lastSweetStart = prisoners * (turns - 1) + 1 - jump; //Number of sweet with which the last turn starts.
        warn = sweets - lastSweetStart + 1; //The prisoner that will be warned.
        return (int) warn;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nms = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nms[0]);

            int m = Integer.parseInt(nms[1]);

            int s = Integer.parseInt(nms[2]);

            int result = saveThePrisoner(n, m, s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
