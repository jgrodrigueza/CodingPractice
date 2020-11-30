//https://www.hackerrank.com/challenges/kaprekar-numbers/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ModifiedKaprekarNumbers {

    // Complete the kaprekarNumbers function below.
    static void kaprekarNumbers(int p, int q) {
        long lp = (long) p;
        long lq = (long) q;
        String print = "";
        for (long num = lp; num <= lq; num++) {
            int numLen = String.valueOf(num).length();
            String square = String.valueOf(num * num);
            String right = square.substring(square.length() - numLen, square.length());
            String left = square.substring(0, square.length() - numLen);
            long lRight = Long.valueOf(right);
            long lLeft = (left.equals("") ? 0 : Long.valueOf(left));
            long sum = lRight + lLeft;
            if (sum == num) {
                print = print + " " + num;
            }
            //System.out.println(num + " -> " + left + "," + right + " -> " + sum);
        }
        //System.out.println(num);
        if (print.equals("")) {
            System.out.print("INVALID RANGE");
        } else {
            System.out.println(print.substring(1, print.length())); //Remove leading and trailing spaces manually as HackerRannk does not support strip() method.
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        kaprekarNumbers(p, q);

        scanner.close();
    }
}

