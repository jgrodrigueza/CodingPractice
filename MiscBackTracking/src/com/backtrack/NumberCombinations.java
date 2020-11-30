package com.backtrack;

import java.util.ArrayList;

public class NumberCombinations {
	
	public static void main(String[] args) {
		
		int targetSum = 5;
		ArrayList<Integer> nums = new ArrayList<Integer>();
		numberCombinations(targetSum, nums, 0);
		
	}
	
	public static void numberCombinations(int num, ArrayList<Integer> nums, int sum) {
		
		if (sum == num) {
			System.out.println(nums);
		} else {
			for (int i = 1; i <= num; i++) {
				sum+=i;
				if (sum <= num) {
					nums.add(i);
					numberCombinations(num, nums, sum);
					nums.remove(nums.indexOf(i));
				}
				sum-=i;
			}
		}
	}

}
