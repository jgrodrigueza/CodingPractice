//https://www.hackerrank.com/challenges/the-birthday-bar/problem

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

public class SubArrayDivision {

    // Complete the birthday function below.
    static int birthday(List<Integer> s, int d, int m) {
        
        int result = 0;
        for (int sq = 0; sq < s.size(); sq++) {
            List<Integer> sub = new ArrayList<Integer>();
            boolean checkres = false;
            for (int pos = 0; pos < m; pos++) {
                if (sq + pos < s.size()) {
                    sub.add(s.get(sq + pos));
                }
                int day = 0;
                for (int curday : sub) {
                    day+=curday;
                }
                if (day == d && sub.size() == m) {
                    checkres = true;
                }
            }
            if (checkres == true) {
                result++;
            }
        }
        return result;    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        String[] dm = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(dm[0]);

        int m = Integer.parseInt(dm[1]);

        int result = birthday(s, d, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
