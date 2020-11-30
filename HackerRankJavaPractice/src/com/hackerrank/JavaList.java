//https://www.hackerrank.com/challenges/java-list/problem

package com.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class JavaList {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<Integer>();
        int n = in.nextInt();
        in.nextLine();
        for (int num = 0; num < n; num++) {
            list.add(in.nextInt());
        }
        in.nextLine();
        int ops = in.nextInt();
        for (int op = 0; op < ops; op++) {
            String operation = in.next();
            if (operation.equalsIgnoreCase("INSERT")) {
                int pos = in.nextInt();
                int num = in.nextInt();
                list.add(pos, num);
            } else if (operation.equalsIgnoreCase("DELETE")) {
                int pos = in.nextInt();
                list.remove(pos);
            }
        }
        for (int num : list) {
            System.out.print(num + " ");
        }    }
}

