//https://www.hackerrank.com/challenges/java-arraylist/problem

package com.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class JavaArraylist {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int lists = input.nextInt();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int line = 0; line < lists; line++) {
            int listSize = input.nextInt();
            List<Integer> subList = new ArrayList<Integer>();
            for (int num = 0; num < listSize; num++) {
                    subList.add(input.nextInt());
            }
            list.add(subList);
        }
        int queries = input.nextInt();
        for (int q = 0; q < queries; q++) {
            int qLine = input.nextInt();
            int qPos = input.nextInt();
            if (qLine > list.size()) {
                System.out.println("ERRRO!");
            } else {
                if (qPos > list.get(qLine - 1).size()) {
                    System.out.println("ERROR!");
                } else {
                    System.out.println(list.get(qLine - 1).get(qPos - 1));
                }
            }
        }
    }
}
