//https://www.hackerrank.com/challenges/the-grid-search/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class TheGridSearch {

    // Complete the gridSearch function below.
    static String gridSearch(String[] G, String[] P) {
        boolean exists = false;
        for (int gridRow = 0; gridRow < G.length; gridRow++) {
            for (int gridCol = 0; gridCol < G[0].length() - P[0].length() + 1; gridCol++) {
                String searchString = G[gridRow].substring(gridCol, gridCol + P[0].length());
                if (searchString.equals(P[0])) {
                    exists = true;
                    if (gridRow + P.length <= G.length) { //If search pattern lines is greater than remaining grid lines, pattern will not be found.
                        for (int pSearch = 1; pSearch < P.length; pSearch++) {
                            //System.out.println("GridRow: " + gridRow +  ", GridCol: " + gridCol + ", Search: " + searchString + ", Found: " + foundAt + ", pSearch: " + pSearch);
                            String checkPattern = G[gridRow + pSearch].substring(gridCol, gridCol + P[pSearch].length());
                            if (!checkPattern.equals(P[pSearch])) { //If one of the following strings at same position is not equal, we break.
                                exists = false;
                                break;
                            }
                        }
                        if (exists == true) {
                            return "YES"; //If the full pattern search was done, means at least one exists and we can return.
                        }
                    }
                }
            }
        }
        return "NO"; //If the end of the method is reached, the pattern was not found.
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] RC = scanner.nextLine().split(" ");

            int R = Integer.parseInt(RC[0]);

            int C = Integer.parseInt(RC[1]);

            String[] G = new String[R];

            for (int i = 0; i < R; i++) {
                String GItem = scanner.nextLine();
                G[i] = GItem;
            }

            String[] rc = scanner.nextLine().split(" ");

            int r = Integer.parseInt(rc[0]);

            int c = Integer.parseInt(rc[1]);

            String[] P = new String[r];

            for (int i = 0; i < r; i++) {
                String PItem = scanner.nextLine();
                P[i] = PItem;
            }

            String result = gridSearch(G, P);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

