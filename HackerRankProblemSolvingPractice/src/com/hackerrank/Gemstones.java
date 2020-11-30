//https://www.hackerrank.com/challenges/gem-stones/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Gemstones {

    // Complete the gemstones function below.
    static int gemstones(String[] arr) {
        String minerals = "";
        //Concatenate minerals
        int mins = 0;
        for (int pos = 0; pos < arr.length; pos++) {
            minerals = minerals + arr[pos];
        }
        //Remove duplicates
        Set<Character> chars = new HashSet<>();
        StringBuilder output = new StringBuilder(minerals.length());
        for (int i = 0; i < minerals.length(); i++) {
            char ch = minerals.charAt(i);
            if (chars.add(ch)) {
                output.append(ch);
            }
        }
        minerals = output.toString();
        //String[][] gemstones = new String[minerals.length()][arr.length];
        for (int pos = 0; pos < minerals.length(); pos++) {
            int times = 0;
            for (int rock = 0; rock < arr.length; rock++) {
                if (arr[rock].indexOf(minerals.charAt(pos)) > -1 ) {
                    //gemstones[pos][rock] = String.valueOf(minerals.charAt(pos));
                    times++; //Counts the times a mineral appears.
                }
            }
            if (times == arr.length) { //If the time a mineral appears equals the size of the array, it is present in all rocks.
                mins++;
            }
        }
       return mins;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            String arrItem = scanner.nextLine();
            arr[i] = arrItem;
        }

        int result = gemstones(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
