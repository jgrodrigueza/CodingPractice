//https://www.hackerrank.com/challenges/cavity-map/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CavityMap {

    // Complete the cavityMap function below.
    static String[] cavityMap(String[] grid) {
        int rows = grid.length - 2;
        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= grid[0].length() - 2; col++) {
                String sup = String.valueOf(grid[row - 1].charAt(col));
                String sright = String.valueOf(grid[row].charAt(col + 1));
                String sdown = String.valueOf(grid[row + 1].charAt(col));
                String sleft = String.valueOf(grid[row].charAt(col - 1));
                if (!sup.equals("X") && !sright.equals("X") && !sdown.equals("X") && !sleft.equals("X")) {
                    int cell = Integer.parseInt(String.valueOf(grid[row].charAt(col)));
                    int up = Integer.parseInt(String.valueOf(grid[row - 1].charAt(col)));
                    int right = Integer.parseInt(String.valueOf(grid[row].charAt(col + 1)));
                    int down = Integer.parseInt(String.valueOf(grid[row + 1].charAt(col)));
                    int left = Integer.parseInt(String.valueOf(grid[row].charAt(col - 1)));
                    if (up < cell && right < cell && down < cell && left < cell) {
                        StringBuilder rowVal = new StringBuilder(grid[row]);
                        rowVal.setCharAt(col, 'X');
                        grid[row] = rowVal.toString();
                    }
                }
            }
        }
        return grid;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] result = cavityMap(grid);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
