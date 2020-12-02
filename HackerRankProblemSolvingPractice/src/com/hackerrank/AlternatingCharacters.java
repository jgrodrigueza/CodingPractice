//https://www.hackerrank.com/challenges/alternating-characters/problem

package com.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AlternatingCharacters {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
        int delete = 0;
        for (int pos = 0; pos < s.length() - 1; pos++) {
            if (s.charAt(pos) == s.charAt(pos + 1)) {
                delete++;
            }
        }
        return delete;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
