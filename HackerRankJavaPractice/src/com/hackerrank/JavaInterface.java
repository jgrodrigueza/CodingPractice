//https://www.hackerrank.com/challenges/java-interface/problem

package com.hackerrank;

import java.util.*;

interface AdvancedArithmetic {
	int divisor_sum(int n);
}

class MyCalculatorJavaInterface implements AdvancedArithmetic {

	public int divisor_sum(int n) {
		int result = 0;
		for (int div = 1; div <= n; div++) {
			if (n % div == 0) {
				result = result + div;
			}
		}
		return result;
	}

}

class JavaInterface {
	public static void main(String[] args) {
		MyCalculatorJavaInterface my_calculator = new MyCalculatorJavaInterface();
		System.out.print("I implemented: ");
		ImplementedInterfaceNames(my_calculator);
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.print(my_calculator.divisor_sum(n) + "\n");
		sc.close();
	}

	/*
	 * ImplementedInterfaceNames method takes an object and prints the name of the
	 * interfaces it implemented
	 */
	static void ImplementedInterfaceNames(Object o) {
		Class[] theInterfaces = o.getClass().getInterfaces();
		for (int i = 0; i < theInterfaces.length; i++) {
			String interfaceName = theInterfaces[i].getName();
			System.out.println(interfaceName);
		}
	}
}
