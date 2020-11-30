//https://www.hackerrank.com/challenges/java-loops/problem

package com.hackerrank;

import java.util.Scanner;

public class JavaLoopsII {

    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int result = (int) (a + Math.pow(2, 0) * b);
            System.out.print(result + " ");
            for (int num = 1; num < n; num++) {
                result = result + (int) (Math.pow(2, num) * b);
                System.out.print(result + " ");
            }
            System.out.println("");
        }
        in.close();
    }
    
}
