//https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem

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

class ResultClimbingTheLeaderboard {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> scores = new ArrayList<Integer>();
        List<Integer> finalRanks = new ArrayList<Integer>();
        Set<Integer> set = new LinkedHashSet<>();
        scores.addAll(ranked); //Add all scores.
        set.addAll(scores); //Put all scores in a set to remove duplicates.  We do this after adding in case the score of the game is equal to a score in the leader board.
        scores.clear();
        scores.addAll(set); //Re-do scores without duplicates.
        Collections.sort(player, Collections.reverseOrder());
        int rank = scores.size() + 1;
        int playPos = player.size() - 1;
        int scorePos = scores.size() - 1;
        while (playPos >= 0) {
            int s = scores.get(scorePos);
            int p = player.get(playPos);
            if (player.get(playPos) >= scores.get(0)) {
                rank = 1;
            } else if (player.get(playPos) < scores.get(scores.size() - 1)) {
                //No actions to take, if score is lower, we will assign the max rank value, which was already added above.
            } else {
                while (scorePos >= 0 && player.get(playPos) >= scores.get(scorePos)) {
                    rank--;
                    scorePos--;
                }
            }
            finalRanks.add(rank);
            playPos--;
        }
        return finalRanks;
    }

}

public class ClimbingTheLeaderboard {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = ResultClimbingTheLeaderboard.climbingLeaderboard(ranked, player);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
