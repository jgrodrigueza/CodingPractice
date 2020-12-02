package com.hackerrank;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
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

public class A1Solution {

    public static boolean isSmartNumber(int num) {
        int val = (int) Math.sqrt(num);    
        if((double)num / val == val)
            return true;
        return false;
    }
    
    public static void main(String[] args) throws IOException {
    	
		String test = "4\r\n1\r\n2\r\n7\r\n169";
		ByteArrayInputStream systemIn = new ByteArrayInputStream(test.getBytes());
    	System.setIn(systemIn);
    	Scanner scanner = new Scanner(System.in);
        int test_cases = scanner.nextInt();
        int num;
        for(int i = 0; i < test_cases; i++){
            num = scanner.nextInt();
            boolean ans = isSmartNumber(num);
            if(ans){
                System.out.println("YES");
            }
            else System.out.println("NO");
        }
    }
    
}
