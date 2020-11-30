//https://www.hackerrank.com/challenges/day-of-the-programmer/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DayOfTheProgrammer {

    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {
        String date = "";
        int febLenJulian = (year % 4 == 0) ? 29 : 28;
        int febLenGregorian = (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) ? 29 : 28;
        int[] monthLenghtJulian = new int[] {31,febLenJulian,31,30,31,30,31,31,30,31,30,31};
        int[] monthLenghtTransition = new int[] {31,15,31,30,31,30,31,31,30,31,30,31};
        int[] monthLenghtGregorian = new int[] {31,febLenGregorian,31,30,31,30,31,31,30,31,30,31};
        if (year < 1918) {
            date = findDate(monthLenghtJulian, year);
        } else if (year == 1918) {
            date = findDate(monthLenghtTransition, year);
        } else if (year > 1918) {
            date = findDate(monthLenghtGregorian, year);
        }
        return date;
    }

    public static String findDate(int[] cal, int year) {
        
        String date = "";
        int days = 1;
        int pos = 0;
        int dayOfMonth = 0;
        //Iterates while the sum of days is smaller than 256, then it will end in the previous month.
        while (days < 256) {
            if (days + cal[pos] >= 256) {
                break;
            } else {
                days+=cal[pos];
                pos++;
            }
        }
        //For the month where the 256th day is, goes one bu one until it determines the date.
        while (days <= 256) {
            dayOfMonth++;
            days++;
        }
        date = String.format("%02d.%02d.%04d", dayOfMonth, pos + 1, year);
        return date;
        
    }

   public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
