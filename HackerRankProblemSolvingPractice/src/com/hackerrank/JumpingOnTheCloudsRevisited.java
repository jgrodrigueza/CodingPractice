//https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class JumpingOnTheCloudsRevisited {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c, int k) {
        int energy = 100;
        int cloudPos = 0; //Starting position.
        boolean zeroLand = false;
        //First jump before loop
        if ((cloudPos + k) < c.length) {
            cloudPos+=k;
        } else {
            cloudPos = k - (c.length - cloudPos);
        }
        energy = reduceEnergy(energy, c[cloudPos]);
        //Loop over cloud array until reaching zero position.
        while (zeroLand == false) {
            //System.out.println(cloudPos + " -> " + energy);
            if (cloudPos == 0) {
                zeroLand = true;
                break;
            } else {
                if ((cloudPos + k) < c.length) {
                    cloudPos+=k;
                    energy = reduceEnergy(energy, c[cloudPos]);
                } else {
                    cloudPos = k - (c.length - cloudPos); //Sets the next position for circular movement.
                    energy = reduceEnergy(energy, c[cloudPos]);
                }
            }
        }
        return energy;
    }

    private static int reduceEnergy(int energy, int cloudType) {
        if (cloudType == 0) {
            return energy-=1;
        } else {
            return energy-=3; //Reduces 1 - 2 additional units.
        }
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

