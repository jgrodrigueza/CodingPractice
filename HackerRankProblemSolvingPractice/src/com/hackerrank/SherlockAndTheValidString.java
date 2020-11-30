//https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SherlockAndTheValidString {

    // Complete the isValid function below.
    static String isValid(String s) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int greaterCount = 0;
        String result = "YES";
        String abc = "abcdefghijklmnopqrstuvwxyz";
        int[] freq = new int[abc.length()];
        Map<String, Integer> charsMap = new HashMap<String, Integer>();
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int pos = 0; pos < s.length(); pos++) {
            freq[abc.indexOf(s.charAt(pos))]++;
            charsMap.put(String.valueOf(s.charAt(pos)), freq[abc.indexOf(s.charAt(pos))]);
        }
        for (Map.Entry<String, Integer> entry : charsMap.entrySet()) {
            if (min > entry.getValue()) {
                min = entry.getValue();
            }
            if (max < entry.getValue()) {
                max = entry.getValue();
            }
            if (!counts.containsKey(entry.getValue())) {
                counts.put(entry.getValue(), 1);
            } else {
                counts.put(entry.getValue(), counts.get(entry.getValue()) + 1);
            }
        }
        if (counts.size() > 2) {
            return "NO";
        } else {
            for (Map.Entry<Integer, Integer> c : counts.entrySet()) {
                if (c.getValue() == 1 && c.getKey() - 1 == 0) {
                    return "YES";
                }
            }
        }
        if (max - min > 1) {
            result = "NO";
        } else {
            for (int f : freq) {
                if (f > min) {
                    greaterCount++;
                    if (greaterCount > 1) {
                        result = "NO";
                        break;
                    }
                }
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
