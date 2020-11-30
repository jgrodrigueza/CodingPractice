package com.msint;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {

    	//int[] A = {1, 3, 6, 4, 1, 2};
        //int[] A = {1, 2, 3};
		int[] A = {-3, -1};
		int retVal = 0;
    	Arrays.sort(A);
    	int pos = 0;
    	while (pos <= A.length) {
    		if (pos == A.length - 1 && retVal == 0) {
    			retVal = A[A.length - 1] + 1;
    			break;
    		} else {
    			if (A[pos] + 2 == A[pos + 1]) {
    				retVal = A[pos] + 1;
    				break;
    			}
    		}
    		pos++;
    	}
    	System.out.println(retVal);
	}
}
