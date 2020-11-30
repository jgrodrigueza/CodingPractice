//https://www.hackerrank.com/challenges/java-md5/problem

package com.hackerrank;

import java.io.*;
import java.util.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.*;

public class JavaMD5 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String password = in.next();
		MessageDigest encrypt = null;
		String finalPwd = "";
		try {
			encrypt = MessageDigest.getInstance("MD5");
			encrypt.update(password.getBytes());
			byte[] encrypted = encrypt.digest();
			finalPwd = new String(encrypted, StandardCharsets.UTF_8);
			BigInteger i = new BigInteger(1, encrypted);
			finalPwd = String.format("%1$032X", i);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		System.out.println(finalPwd.toLowerCase());
	}
}
