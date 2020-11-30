//https://www.hackerrank.com/challenges/time-conversion/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class TimeConversion {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        String time = s;
        String[] timeS = time.split(":");
        System.out.println("");
        int hour = Integer.parseInt(timeS[0]);
        int mins = Integer.parseInt(timeS[1]);
        int secs = Integer.parseInt(timeS[2].substring(0, 2));
        String ampm = timeS[2].substring(2, 4);
        if (ampm.equalsIgnoreCase("PM") && hour < 12) {
            hour = hour + 12;
        } else if (ampm.equalsIgnoreCase("AM") && hour == 12) {
            hour = 0;
        }
        return String.format("%02d:%02d:%02d", hour, mins, secs);
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
