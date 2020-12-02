//https://www.hackerrank.com/challenges/luck-balance/problem

package com.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LuckBalance {

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
        int luck = 0;
        List<Integer> importantContests = new ArrayList<Integer>();
        List<Integer> normalContests = new ArrayList<Integer>();
        for (int cont = 0; cont < contests.length; cont++) {
            if (contests[cont][1] == 1) {
                importantContests.add(contests[cont][0]); //Adds only the luck of important contests.
            } else {
                normalContests.add(contests[cont][0]);
            }
        }
        Collections.sort(importantContests, Collections.reverseOrder());
        int luckControl = 1;
        for (int pos = 0; pos < importantContests.size(); pos++) {
            if (luckControl <= k) {
                luck+=importantContests.get(pos);
            } else {
                luck-=importantContests.get(pos);
            }
            luckControl++;
        }
        for (int pos = 0; pos < normalContests.size(); pos++) {
            luck+=normalContests.get(pos);
        }
        return luck;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
