package com.msint;
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

public class CodeGame {
    public String solution(String S, int[] A) {
        
        int nextPerson = 0; //Holds the position of the next person
        int stringSize = S.length();
        String message = S.substring(0, 1); //Assigns the first character at position 0
        boolean msgComplete = false;
        while (msgComplete == false) { //Control to determine if the message is complete (as not all letters may be used)
            nextPerson = A[nextPerson]; //Assigns the position of the next person.
            if (nextPerson > 0) { //If person is "0" (zero), no character will be appended
                message = message + S.substring(nextPerson, nextPerson + 1);
            }
            if (message.length() == stringSize || nextPerson == 0) { //If message has all characters or person "0" (zero) was reached, the loop ends
                msgComplete = true;
                break;
            }
            
        }
        return message;
    }
}
