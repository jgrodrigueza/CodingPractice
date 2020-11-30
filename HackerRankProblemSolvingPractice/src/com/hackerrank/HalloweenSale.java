//https://www.hackerrank.com/challenges/halloween-sale/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HalloweenSale {

    // Complete the howManyGames function below.
    static int howManyGames(int p, int d, int m, int s) {
        // Return the number of games you can buy
        int price = p;
        int discount = d;
        int minimum = m;
        int budget = s;
        int games = 0;
        int spent = 0;
        if (price <= budget) {
            //For first purchase, we set the value, for subsequent purchases, it is done in the loop.
            games = 1;
            spent+=price;
            while (spent <= budget) {
                price = (price - discount > minimum) ? price-=discount : minimum;
                spent+=price;
                if (spent > budget) {
                    break;
                }
                games++;
            }
        }
        return games;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] pdms = scanner.nextLine().split(" ");

        int p = Integer.parseInt(pdms[0]);

        int d = Integer.parseInt(pdms[1]);

        int m = Integer.parseInt(pdms[2]);

        int s = Integer.parseInt(pdms[3]);

        int answer = howManyGames(p, d, m, s);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

