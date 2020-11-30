//https://www.hackerrank.com/challenges/mars-exploration/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MarsExploration {

    // Complete the marsExploration function below.
    static int marsExploration(String s) {
        int changed = 0;
        for (int pos = 0; pos <= s.length() - 3; pos+=3) {
            if (s.charAt(pos) != 'S') {
                changed++;
            }
            if (s.charAt(pos + 1) != 'O') {
                changed++;
            }
            if (s.charAt(pos + 2) != 'S') {
                changed++;
            }
        }
        return changed;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int result = marsExploration(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
