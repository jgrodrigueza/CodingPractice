//https://www.hackerrank.com/challenges/kangaroo/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class NumberLineJumps {

    // Complete the kangaroo function below.
    static String kangaroo(int x1, int v1, int x2, int v2) {
        int kang1Pos = x1;
        int kang1Dist = v1;
        int kang1Jumps = 0;
        int kang2Pos = x2;
        int kang2Dist = v2;
        int kang2Jumps = 0;
        String response = "NO";
        
        while (kang1Pos <= 100000000 && kang2Pos <= 100000000) {
            kang1Pos = kang1Pos + kang1Dist;
            kang1Jumps++;
            kang2Pos = kang2Pos + kang2Dist;
            kang2Jumps++;
            if (kang1Pos == kang2Pos && kang1Jumps == kang2Jumps) {
                response = "YES";
                break;
            }
            
        }
        return response;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] x1V1X2V2 = scanner.nextLine().split(" ");

        int x1 = Integer.parseInt(x1V1X2V2[0]);

        int v1 = Integer.parseInt(x1V1X2V2[1]);

        int x2 = Integer.parseInt(x1V1X2V2[2]);

        int v2 = Integer.parseInt(x1V1X2V2[3]);

        String result = kangaroo(x1, v1, x2, v2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

