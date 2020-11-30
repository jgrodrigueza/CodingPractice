//https://www.hackerrank.com/challenges/reduced-string/problem

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

public class SuperReducedString {

    static String[] replace = {"aa","bb","cc","dd","ee","ff","gg","hh","ii","jj","kk","ll","mm","nn","oo","pp","qq","rr","ss","tt","uu","vv","ww","xx","yy","zz"};

    
    static boolean hasReplace(String s) {
        for (int pos = 0; pos < replace.length; pos++) {
            if (s.contains(replace[pos])) {
                return true;
            }
        }
        return false;
    }
    
    static String superReducedString(String s) {
        boolean replaceable = true;
        while (replaceable) {
            for (int pos = 0; pos < replace.length; pos++) {
                s = s.replace(replace[pos], "");
                if (s.length() == 0 || s.isEmpty() || hasReplace(s) == false) {
                    replaceable = false;
                    break;
                }
            }
        }
        return (s.length() == 0) ? "Empty String" : s;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
