//https://www.hackerrank.com/challenges/staircase/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Staircase {

    // Complete the staircase function below.
    static void staircase(int n) {
        int lastStep = n - 1;
        int maxSize = n - 1;
        String floor = "";
        for (int floorNum = 0; floorNum <= maxSize; floorNum++) {
            for (int pos = 0; pos <= maxSize; pos++) {
                if (pos < lastStep) {
                    floor = floor + " ";
                } else if (pos >= lastStep) {
                    floor = floor + "#";
                }
            }
            System.out.println(floor);
            floor = "";
            lastStep--;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }
}
