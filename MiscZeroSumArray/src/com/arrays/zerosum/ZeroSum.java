package com.arrays.zerosum;

public class ZeroSum {

	public static void main(String[] args) {
		
		int arraySize = 4;
		int intsArray[];
		intsArray = new int[arraySize]; //Create the array with the required size.
		boolean sizeIsEven = (arraySize % 2 == 0) ? true : false; //Check is the size of the array is an even number, if it is, the "zero" center will be ignored when generating the array. 
		int startVal = (arraySize / 2) * -1; //For even numbers the result has decimals, but as data type is integer, decimals will be truncated.
		int sum = 0;
		String arrayStr = "";

		//Iterate through the array to fill in the value and get the sum of all elements.
		for (int pos = 0; pos < arraySize; pos++) {
			if (sizeIsEven == true && startVal == 0) { //When array size is even, we don't need the zero center or numbers won't fit and sum will not be zero.
				startVal++;
			}
			intsArray[pos] = startVal;
			startVal++;
			sum = sum + intsArray[pos];
			
			//Build array string.
			arrayStr = arrayStr + intsArray[pos];
			if (pos < arraySize - 1) {
				arrayStr = arrayStr + ","; //Comma is added to all elements except las one.
			}
		}

		System.out.println("Array: [" + arrayStr + "] -> Size: " + intsArray.length + " Sum: " + sum);
	}

}
