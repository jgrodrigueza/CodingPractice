//https://www.hackerrank.com/challenges/java-string-compare/problem

package com.hackerrank;

import java.util.Scanner;

public class JavaSubstringComparisons {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        smallest = s.substring(0, k);
        largest = s.substring(0, k);
        for (int pos = 0; pos < s.length() - (k - 1); pos++) {
            String check = s.substring(pos, pos + k);
            //System.out.println(smallest + ", " + largest + ", " + check);
            if (smallest.compareTo(check) > 0) {
                smallest = check;
            }
            if (largest.compareTo(check) < 0) {
                largest = check;
            }
        }
        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
      
        System.out.println(getSmallestAndLargest(s, k));
    }
}
