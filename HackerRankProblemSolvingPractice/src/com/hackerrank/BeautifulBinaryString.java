//https://www.hackerrank.com/challenges/beautiful-binary-string/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BeautifulBinaryString {

    // Complete the beautifulBinaryString function below.
    static int beautifulBinaryString(String b) {
        char[] str = b.toCharArray();
        int moves = 0;
        if (b.contains("010")) {
            int first = b.indexOf("010");
            for (int pos = first; pos < str.length - 2; pos++) {
                if (b.charAt(pos) == '0' && b.charAt(pos + 1) == '1' && b.charAt(pos + 2) == '0') {
                    StringBuilder temp = new StringBuilder(b);
                    temp.setCharAt(pos + 2, '1');
                    b = temp.toString();
                    moves++;
                }
            }
        }
        return moves;    
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String b = scanner.nextLine();

        int result = beautifulBinaryString(b);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
