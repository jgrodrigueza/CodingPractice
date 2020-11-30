//https://www.hackerrank.com/challenges/phone-book/problem

package com.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class JavaMap {
	public static void main(String[] argh) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		Map<String, Integer> phones = new HashMap<String, Integer>();
		for (int i = 0; i < n; i++) {
			String name = in.nextLine();
			int phone = in.nextInt();
			phones.put(name, phone);
			in.nextLine();
		}
		while (in.hasNext()) {
			String s = in.nextLine();
			System.out.println((phones.get(s) == null) ? "Not found" : s + "=" + phones.get(s));
		}
	}
}
