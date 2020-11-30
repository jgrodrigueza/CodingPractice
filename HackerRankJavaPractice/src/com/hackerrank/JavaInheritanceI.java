//https://www.hackerrank.com/challenges/java-inheritance-1/problem

package com.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Animal {
	void walk() {
		System.out.println("I am walking");
	}
}

class Bird extends Animal {
	void fly() {
		System.out.println("I am flying");
	}

	void walk() {
		System.out.println("I am walking");
	}

	void sing() {
		System.out.println("I am singing");
	}
}

public class JavaInheritanceI {

	public static void main(String args[]) {

		Bird bird = new Bird();
		bird.walk();
		bird.fly();
		bird.sing();

	}
}
