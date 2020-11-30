//https://www.hackerrank.com/challenges/java-exception-handling-try-catch/problem

package com.hackerrank;

import java.io.*;
import java.util.*;

public class JavaExceptionHandlingTryCatch {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        try {
            int x = in.nextInt();
            int y = in.nextInt();
            int result = 0;
            result = x / y;
            System.out.println(result);
        } catch (ArithmeticException | InputMismatchException e) {
            if (e instanceof ArithmeticException) {
              System.out.println("java.lang.ArithmeticException: / by zero");
            } else if (e instanceof InputMismatchException){
              System.out.println("java.util.InputMismatchException");
            }
        }
        in.close();
    }
}
