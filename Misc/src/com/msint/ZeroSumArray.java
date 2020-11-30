package com.msint;
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

public class ZeroSumArray {
    public int[] solution(int N) {
        int arraySize = N;
        if (arraySize >= 0 && arraySize <= 100) {
            int intsArray[];
            intsArray = new int[arraySize]; //Create an array of integers of the specified size.
            boolean sizeIsEven = (arraySize % 2 == 0) ? true : false; //Check if the size of the array is an even number.
            int startVal = (arraySize / 2) * -1; //First value of the array.  For odd numbers, the result has decimals, but data type integer truncates decimals.
            int sum = 0;
            
            //Generate the array
            for (int pos = 0; pos < arraySize; pos++) {
                if (sizeIsEven == true && startVal == 0) { //For even sizes, zero center is skipped, else, not all numbers will fir int the array and result will not be zero.
                    startVal++;
                }
                
                intsArray[pos] = startVal;
                startVal++;
                sum = sum + intsArray[pos]; //Used to check final result of the sum.
            }
            return intsArray;
        } else {
            return null;
        }
    }
}