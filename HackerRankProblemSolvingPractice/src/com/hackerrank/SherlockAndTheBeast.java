//https://www.hackerrank.com/challenges/sherlock-and-the-beast/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SherlockAndTheBeast {

    // Complete the decentNumber function below.
    static void decentNumber(int n) {
        if (n <= 2) {
            System.out.println(-1);
            return;
        } else if (n == 3) {
            System.out.println(new String(new char[n]).replace("\0", String.valueOf("5")));
            return;
        } else if (n == 5) {
            System.out.println(new String(new char[n]).replace("\0", String.valueOf("3")));
            return;
        } else {
            //Start building with 5 as we need the largest number, then replace right digits with 3 as required.
            String outnum = new String(new char[n]).replace("\0", String.valueOf("5"));
            boolean isValid = false;
            int fiveCount = n;
            int threeCount = 0;
            while (!isValid) {
                if (fiveCount % 3 == 0 && threeCount % 5 == 0) {
                    outnum = new String(new char[fiveCount]).replace("\0", String.valueOf("5")) + new String(new char[threeCount]).replace("\0", String.valueOf("3"));;
                    System.out.println(outnum);
                    isValid = true;
                    return;
                } else {
                    threeCount += 5;
                    fiveCount = n - threeCount;
                    if (fiveCount < 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
            System.out.println(-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                decentNumber(n);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}

