package com.hackerrank;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class A1Solution {
 
	public static void main(String[] args) {
		String data = "4\r\n1 4 3 2";
		InputStream stdin = System.in;
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		Scanner scanner = new Scanner(System.in);
	}
	
}
