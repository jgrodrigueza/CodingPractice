//https://www.hackerrank.com/challenges/java-loops-i/problem

package com.hackerrank;

import java.util.Scanner;

public class JavaLoopsI {

    private static final Scanner scanner = new Scanner(System.in);
	
    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int num = 1; num <= 10; num++) {
            System.out.println(String.format("%s x %s = %s", N, num, N * num));
        }
        scanner.close();
    }
    
}
