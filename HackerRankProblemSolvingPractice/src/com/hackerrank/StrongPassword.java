//https://www.hackerrank.com/challenges/strong-password/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class StrongPassword {

    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        String numbers = "[0-9]";
        String lowerCase = "[a-z]+";
        String upperCase = "[A-Z]+";
        String specialCharacters = "[!@#$%^&*()\\-\\+]";
        int missing = 0;
        
        Pattern pNumbers = Pattern.compile(numbers);
        Matcher mNumbers = pNumbers.matcher(password);
        if (!mNumbers.find()) {
            missing++;
        }
        
        Pattern pLowerCase = Pattern.compile(lowerCase);
        Matcher mLowerCase = pLowerCase.matcher(password);
        if (!mLowerCase.find()) {
            missing++;
        }
        
        Pattern pUpperCase = Pattern.compile(upperCase);
        Matcher mUpperCase = pUpperCase.matcher(password);
        if (!mUpperCase.find()) {
            missing++;
        }
        
        Pattern pSpecialCharacters = Pattern.compile(specialCharacters);
        Matcher mSpecialCharacters = pSpecialCharacters.matcher(password);
        if (!mSpecialCharacters.find()) {
            missing++;
        }
        if (password.length() + missing < 6) {
            missing = 6 - password.length();
        }
        return missing;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

