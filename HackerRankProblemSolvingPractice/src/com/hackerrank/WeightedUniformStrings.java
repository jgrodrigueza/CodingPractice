//https://www.hackerrank.com/challenges/weighted-uniform-string/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class WeightedUniformStrings {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = in.nextInt();
        int contString = 1;
        int prevAsciiVal = 0;
        Set<Integer> numList = new HashSet<Integer>();
        //iterating chars and adding ascii value to hashset
        for(char x : s.toCharArray()) {
            int asciiVal = x - 'a' + 1;
            if(asciiVal == prevAsciiVal) { contString++; }
            else {
                contString = 1;
                prevAsciiVal = asciiVal;
            }
            numList.add(asciiVal * contString); 
        }
        //determining if hashset contains the testcase
        for(int a0 = 0; a0 < n; a0++) {
            int x = in.nextInt();
            String ans = numList.contains(x) ? "Yes" : "No"; 
            System.out.println(ans);
        }
    }
}
