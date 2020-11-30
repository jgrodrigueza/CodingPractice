//https://www.hackerrank.com/challenges/encryption/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Encryption {

    // Complete the encryption function below.
    static String encryption(String s) {
        s = s.replace(" ", "");
        int len = s.length();
        double sqrt = Math.sqrt(len);
        int rows = (int) sqrt;
        int cols = (int) Math.ceil(sqrt);
        if (rows * cols < s.length()) {
            rows++;
        }
        int start = 0;
        int end = cols;
        String first = s.substring(start, end);
        String[][] result = new String[cols][rows];
        int retCol = 0;
        int retRow = 0;
        boolean last = false;
        for (int row = 0; row < rows; row++) {
            String temp = s.substring(start, end);
            for (int pos = 0; pos < temp.length(); pos++) {
                result[retRow][retCol] = String.valueOf(temp.charAt(pos));
                retRow++;
            }
            retCol++;
            retRow = 0;
            start = start + cols;
            end = (end + cols >= s.length() ? s.length() : end + cols);
        }
        String res = "";
        int test = result.length;
        for (int rowPos = 0; rowPos < cols; rowPos++) {
            for (int colPos = 0; colPos < rows; colPos++) {
                if (result[rowPos][colPos] != null) {
                    res = res + result[rowPos][colPos];
                }
            }
            res = res + " ";
        }
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
