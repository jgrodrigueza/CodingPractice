package com.hackerrank;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/*
		String test = "";
		ByteArrayInputStream systemIn = new ByteArrayInputStream(test.getBytes());
    	System.setIn(systemIn);
    	Scanner scan = new Scanner(System.in);
    	
		File file = new File("GameOfThronesTestCase.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st = br.readLine(); 
    	
*/

public class Solution {
	
	//https://www.hackerrank.com/challenges/lilys-homework/problem
    // Complete the lilysHomework function below.
    static int lilysHomework(int[] arr) {
    	
    	int swaps = 0;
    	return swaps;

    }


    public static void main(String[] args) throws IOException {
		String test = "4\r\n2 5 3 1";
		ByteArrayInputStream systemIn = new ByteArrayInputStream(test.getBytes());
    	System.setIn(systemIn);
    	Scanner scanner = new Scanner(System.in);
    	int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] arr = new int[n];
        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }
        int result = lilysHomework(arr);
        scanner.close();
    }
}
