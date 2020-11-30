//https://www.hackerrank.com/challenges/sha-256/problem

package com.hackerrank;

import java.io.*;
import java.util.*;
import java.math.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class JavaSHA256 {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		Scanner in = new Scanner(System.in);
		String password = in.next();
		MessageDigest m = MessageDigest.getInstance("SHA-256");
		m.update(password.getBytes());
		for (byte i : m.digest()) {
			System.out.print(String.format("%02x", i));
		}
		System.out.println();
	}
}
