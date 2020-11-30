//https://www.hackerrank.com/challenges/game-of-thrones/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class GameOfThronesI {

    // Complete the gameOfThrones function below.
    static String gameOfThrones(String s) {
        int strLen = s.length();
        String result = "NO";
        String abc = "abcdefghijklmnopqrstuvwxyz";
        int oddTolerance = (s.length() % 2 == 0) ? 0 : 1;
        int[] freq = new int[abc.length()];
        int evens = 0;
        int odds = 0;
        for (int pos = 0; pos < s.length(); pos++) {
            freq[abc.indexOf(s.charAt(pos))]++;
        }
        for (int pos = 0; pos < freq.length; pos++) {
            if (freq[pos] > 0) {
                if (freq[pos] % 2 != 0) {
                    odds++;    
                } else {
                    evens++;
                }
            }
        }
        if (odds <= 1) {
                result = "YES";
           } else if (odds == 2 && s.length() %2 == 0) {
               result = "YES";
           }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
