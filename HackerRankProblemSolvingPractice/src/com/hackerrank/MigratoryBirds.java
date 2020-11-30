//https://www.hackerrank.com/challenges/migratory-birds/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MigratoryBirds {

    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {
        HashMap<Integer, Integer> birds = new HashMap<Integer, Integer>();
        Collections.sort(arr);
        int bird = 0;
        int count = 0;
        for (int a : arr) {
            if (a > bird) {
                bird = a;
                count = 1;
                birds.put(bird, count);
            } else if (a == bird) {
                count++;
                birds.put(bird, count);
            }
        }
        int max = 0;
        int maxBird = 0;
        for (int birdN : birds.keySet()) {
            if (max < birds.get(birdN)) {
                max = birds.get(birdN);
                maxBird = birdN;
            }
        }
        return maxBird;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
