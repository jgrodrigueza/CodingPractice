//https://www.hackerrank.com/challenges/java-biginteger/problem

package com.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class JavaBigInteger {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String sNum1 = input.next();
        String sNum2 = input.next();
        BigInteger num1 = new BigInteger(sNum1);
        BigInteger num2 = new BigInteger(sNum2);
        System.out.println(num1.add(num2));
        System.out.println(num1.multiply(num2));
    }
}
