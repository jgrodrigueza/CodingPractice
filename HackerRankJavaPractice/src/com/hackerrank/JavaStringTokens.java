//https://www.hackerrank.com/challenges/java-string-tokens/problem

package com.hackerrank;

import java.io.*;
import java.util.*;

public class JavaStringTokens {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        s = s.trim();
        if (s.length() == 0) {
            System.out.println(0);
        } else {
            String[] result = s.split("[ !,?.\\_'@]+"); //s.split("[^A-Za-z0-9]");
            System.out.println(result.length);
            for (int pos = 0; pos < result.length; pos++) {
                System.out.println(result[pos]);
            }
        }
        scan.close();
    }
}

