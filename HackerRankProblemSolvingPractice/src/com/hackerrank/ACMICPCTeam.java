//https://www.hackerrank.com/challenges/acm-icpc-team/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ACMICPCTeam {

    // Complete the acmTeam function below.
    static int[] acmTeam(String[] topic) {
        int attendees = topic.length;
        int topicCount = topic[0].length();
        int maxTopics = 0;
        int maxTopicsTeams = 0;
        //int totalTeams = 0;
        for (int att1 = 0; att1 < attendees - 1; att1++) {
            for (int att2 = att1 + 1; att2 < attendees; att2++) {
                int teamTopics = 0;
                for (int currentTopic = 0; currentTopic < topicCount; currentTopic++) {
                    teamTopics+=(topic[att1].charAt(currentTopic) == '0' && topic[att2].charAt(currentTopic) == '0') ? 0 : 1;
                }
                if (maxTopics < teamTopics) {
                    maxTopics = teamTopics;
                    maxTopicsTeams = 1; //When there is a new maximum topics, the teams with the new max topics is 1.
                } else if (maxTopics == teamTopics) {
                    maxTopicsTeams++; //If the team topics is the same as the current maximum, teams counter increments.
                }
                //totalTeams++;
                //System.out.println(att1 + "," + att2 + ": " + teamTopics + " (Max: " + maxTopics + ")");
            }
        }
        //System.out.println("Max Topics: " + maxTopics + " Teams: " + maxTopicsTeams + " Total Teams: " + totalTeams);
        //System.out.println(maxTopics);
        //System.out.println(maxTopicsTeams);
        int[] result = {maxTopics, maxTopicsTeams};
        return result;    
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

