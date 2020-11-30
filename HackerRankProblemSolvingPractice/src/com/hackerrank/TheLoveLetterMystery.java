//https://www.hackerrank.com/challenges/the-love-letter-mystery/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class TheLoveLetterMystery {

    // Complete the theLoveLetterMystery function below.
    static int theLoveLetterMystery(String s) {
        int operations = 0;
        int len = s.length() / 2;
        int rStart = (s.length() % 2 == 0) ? len : len + 1;
        String sLeft = s.substring(0, len);
        String sRight =  s.substring(rStart, s.length());
        int rPos = sRight.length() - 1;
        for (int lPos = 0; lPos < sLeft.length(); lPos++) {
            int lc = sLeft.charAt(lPos);
            int rc = sRight.charAt(rPos);
            if (lc > rc) {
                operations += lc - rc;
            } else if (lc < rc) {
                operations += rc - lc;
            }
            rPos--;
        }    
        return operations;    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = theLoveLetterMystery(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

