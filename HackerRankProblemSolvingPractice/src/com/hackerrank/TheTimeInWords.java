//https://www.hackerrank.com/challenges/the-time-in-words/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class TheTimeInWords {

    // Complete the timeInWords function below.
    static String timeInWords(int h, int m) {
        String[] hours = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve"};
        String[] minutes = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty", "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine"};
        String hourText = hours[h - 1];
        String nextHour = (h == 12) ? hours[0] : hours[h];
        if (m == 0) {
            return String.format("%s o' clock", hours[h - 1]);
        } else if (m == 1) {
            return String.format("%s minute past %s", minutes[m - 1], hours[h - 1]);
        } else if ((2 <= m && m < 15) || (16 <= m && m <= 29)) {
            return String.format("%s minutes past %s", minutes[m - 1], hours[h - 1]);
        } else if (m == 15) {
            return String.format("quarter past %s", hours[h - 1]);
        } else if (m == 30) {
            return String.format("half past %s", hours[h - 1]);
        } else if ((31 <= m && m <= 44) || (46 <= m && m <= 58)) {
            return String.format("%s minutes to %s", minutes[60 - m - 1], nextHour);
        } else if (m == 45) {
            return String.format("quarter to %s", nextHour);
        } else if ((m == 59)) {
            return String.format("%s minute to %s", minutes[60 - m - 1], nextHour);
        }
        return "";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
