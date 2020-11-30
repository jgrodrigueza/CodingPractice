//https://www.hackerrank.com/challenges/flatland-space-stations/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FlatlandSpaceStations {

    // Complete the flatlandSpaceStations function below.
    static int flatlandSpaceStations(int n, int[] c) {
        Arrays.sort(c);
        int distance = 0;
        if (n == c.length) {
            return 0; //All cities have spaces stations.
        } else {
            //Check cities before first space station.
            if (c[0] > 0) {
                distance = c[0];
            }
            //Check cities after last space station.
            if (n - 1 > c[c.length - 1]) {
                int dist = (n - 1) - c[c.length - 1];
                if (distance < dist) {
                    distance = dist;
                }
            }
            //Check cities between first and last space station.
            for (int city = 1; city < c.length; city++) {
                int dist = (c[city] - c[city - 1]) / 2;
                if (distance < dist) {
                    distance = dist;
                }
            }
        }
        return distance;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] c = new int[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = flatlandSpaceStations(n, c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
