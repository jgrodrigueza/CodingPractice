//https://www.hackerrank.com/challenges/java-primality-test/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class JavaPrimalityTest {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String n = scanner.nextLine();
		System.out.println((new BigInteger(n).isProbablePrime(1) == true) ? "prime" : "not prime");
		scanner.close();
	}
}
