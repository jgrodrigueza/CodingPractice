//https://www.hackerrank.com/challenges/java-anagrams/problem

package com.hackerrank;

import java.util.Scanner;

public class JavaAnagrams {

	static boolean isAnagram(String a, String b) {
		boolean result = true;
		a = a.toLowerCase();
		b = b.toLowerCase();
		String abc = "abcdefghijklmnopqrstuvwxyz";
		int[] freq1 = new int[abc.length()];
		int[] freq2 = new int[abc.length()];
		for (int pos = 0; pos < a.length(); pos++) {
			freq1[abc.indexOf(a.charAt(pos))]++;

		}
		for (int pos = 0; pos < b.length(); pos++) {
			freq2[abc.indexOf(b.charAt(pos))]++;
		}
		for (int pos = 0; pos < abc.length(); pos++) {
			if (freq1[pos] != freq2[pos]) {
				result = false;
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String a = scan.next();
		String b = scan.next();
		scan.close();
		boolean ret = isAnagram(a, b);
		System.out.println((ret) ? "Anagrams" : "Not Anagrams");
	}
}