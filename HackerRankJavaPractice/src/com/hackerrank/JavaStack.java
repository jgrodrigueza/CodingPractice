//https://www.hackerrank.com/challenges/java-stack/problem

package com.hackerrank;

import java.util.*;

class JavaStack {

	public static void main(String[] argh) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String input = sc.next();
			while (input.length() != (input = input.replaceAll("\\(\\)|\\[\\]|\\{\\}", "")).length()) {
				// No code in loop, used only to perform replacements.
			}
			System.out.println(input.isEmpty());
		}
	}
}
