//https://www.hackerrank.com/challenges/java-end-of-file

package com.hackerrank;

import java.util.Scanner;

public class JavEndOfFile {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int lineNum = 1;
        while (scanner.hasNext()) {
            String lineText = scanner.nextLine();
            System.out.println(lineNum + " " + lineText);
            lineNum++;
        }
        
    }
   
}
