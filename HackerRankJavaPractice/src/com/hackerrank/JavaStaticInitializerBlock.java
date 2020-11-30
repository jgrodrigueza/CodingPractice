//https://www.hackerrank.com/challenges/java-static-initializer-block/problem

package com.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class JavaStaticInitializerBlock {

	public static Scanner input = new Scanner(System.in);
	public static int B = input.nextInt();
	public static int H = input.nextInt();
	public static boolean flag = checkNumbers(B, H);
	    
	public static boolean checkNumbers(int B, int H) {
	    if (B >= 1 && H >= 1) {
	        flag = true;
	    } else {
	        flag = false;
	        System.out.println("java.lang.Exception: Breadth and height must be positive");
	    }
	    return flag;
	}

	public static void main(String[] args){
		if(flag){
			int area=B*H;
			System.out.print(area);
		}
		
	}//end of main

}//end of class


