//https://www.hackerrank.com/challenges/caesar-cipher-1/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CaesarCipher {

    // Complete the caesarCipher function below.
    static String caesarCipher(String s, int k) {
        String encrypt = "";
        String abcLower = "abcdefghijklmnopqrstuvwxyz";
        List<String> abcList = new ArrayList<String>();
        for (int pos = 0; pos < abcLower.length(); pos++) {
            abcList.add(String.valueOf(abcLower.charAt(pos)));
        }
        Collections.rotate(abcList, k * -1);
        for (int pos = 0; pos < s.length(); pos++) {
            if (Character.isLetter(s.charAt(pos))) {
                char cLower = Character.toLowerCase(s.charAt(pos));
                int originalPos = abcLower.indexOf(cLower);
                String addLetter = "";
                if (Character.isUpperCase(s.charAt(pos))) {
                    addLetter = abcList.get(originalPos).toUpperCase();
                } else {
                    addLetter = abcList.get(originalPos);
                }
                encrypt = encrypt + addLetter;
            } else {
                encrypt = encrypt + s.charAt(pos);
            }
        }
        return encrypt;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
