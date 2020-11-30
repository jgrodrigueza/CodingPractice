//https://www.hackerrank.com/challenges/java-string-reverse/problem

package com.hackerrank;

import java.io.*;
import java.util.*;

public class JavaStringReverse {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        System.out.print((new StringBuilder(A).reverse().toString().equals(A) == true) ? "Yes" : "No");
        
    }
}
