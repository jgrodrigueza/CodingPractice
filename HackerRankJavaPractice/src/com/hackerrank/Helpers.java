package com.hackerrank;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Helpers {
	
	private static final SimpleDateFormat tsformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//	class StudentSort implements Comparator<Student> {
//
//		@Override
//		public int compare(Student student1, Student student2) {
//			//CGPA (Desc), First Name (Asc), ID (Asc)
//			int cgpaComp = (int) Double.compare(student1.getCgpa(), student2.getCgpa());
//			int nameComp = student1.getFname().compareTo(student2.getFname());
//			int idComp = Integer.compare(student1.getId(), student2.getId());
//			if (cgpaComp != 0) {
//				return -cgpaComp;
//			} else if (nameComp != 0) {
//					return nameComp;
//			} else {
//				return idComp;
//			}
//		}
//	}

	public void createStringRepetedChars() {
		String character = "_";
		int size = 2;
		String s1Pos = IntStream.range(0, size).mapToObj(i -> character).collect(Collectors.joining(""));
	}
	
	class BigDecimalComparator implements Comparator<String> {

		@Override
		public int compare(String string1, String string2) {
			BigDecimal bd1 = new BigDecimal(string1);
			BigDecimal bd2 = new BigDecimal(string2);
			return bd2.compareTo(bd1);
		}
	}

	public static int[] getInts() {
		
		int n = 2*(10*10*10*10*10);
		int size = 10*10*10*10;
		int[] arr = new int[n];
		Random rand = new Random();
		for (int i = 0; i < n; i++) {
			arr[i] = rand.nextInt(size);
		}
		//Arrays.sort(arr);
		return arr;
	}
	
	public static String[] getStrings() {
		
		int lenght = 10*10*10*10*10;
		int size = 10*10*10*10*10*10*10*10*10;
		String[] arr = new String[lenght];
		Random rand = new Random();
		for (int i = 0; i < lenght; i++) {
			arr[i] = String.valueOf(rand.nextInt(size));
		}
		//Arrays.sort(arr);
		return arr;
	}
	
	
	public static List<int[]> tests() {
		
		List<int[]> list = new ArrayList<int[]>();
		list.add(new int[] {0,3});
		list.add(new int[] {4,6});
		list.add(new int[] {6,7});
		list.add(new int[] {3,5});
		list.add(new int[] {0,7});
		return list;
	}
	
	/*
	 * Array to Lst / List to Array with type conversions
	 * 
	 * 	List<BigInteger> list = Arrays.stream(unsorted).map(BigInteger::new).collect(Collectors.toList());
	 *	String[] ret = list.stream().map(s -> String.valueOf(s)).toArray(String[]::new);
	 * */
	
	public static List<Integer> arrayToList(int[] arr) {
		
		return Arrays.stream(arr).boxed().collect(Collectors.toList());
		
	}
	
	public static int[] listToArray(List<Integer> list) {
		
		return list.stream().mapToInt(i->i).toArray();
		
	}
	
	public static String getTS() {
		
		return tsformat.format(new Timestamp(System.currentTimeMillis()));
		
	}
	
	public static Timestamp getCurrentTS() {
		
		return new Timestamp(System.currentTimeMillis());
		
	}
	
	public static String getDateDiff(Timestamp start, Timestamp end) {
		
		long diff = end.getTime() - start.getTime();
		long diffSeconds = diff / 1000 % 60;  
		long diffMinutes = diff / (60 * 1000) % 60; 
		long diffHours = diff / (60 * 60 * 1000);
		return String.format("%02d hours, %02d minutes, %02d seconds.", diffHours, diffMinutes, diffSeconds);
		
	}
	
	public static long fibonacci(int n) {
		
		System.out.println("Fibonacci " + n);
		if (n <= 1) {
			return 1;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
		
	}
	
	public static void sort() {
		int[] arr = {2,1,3,1,2};
		//Start of solution.
	    int shifts = 0;
		for (int i = 1; i < arr.length; i++) {
	        int j = i;
	        int value = arr[i];
	        while (j >= 1 && arr[j-1] > value) {
	        	arr[j] = arr[j-1];
	            j--;
	            shifts++;
	        }
	        arr[j] = value;
	        //print(A);
	    }
	}
	
	public static void calendar() {
		int month = 8;
		int day = 5;
		int year = 2015;
		Calendar date = Calendar.getInstance();
		date.set(year, month - 1, day);
		System.out.println(date.get(Calendar.YEAR));
		System.out.println(date.get(Calendar.MONTH));
		System.out.println(date.get(Calendar.DAY_OF_MONTH));
		System.out.println(date.get(Calendar.DAY_OF_WEEK));
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE", Locale.ENGLISH);
		String t = dateFormat.format(date.getTime()).toUpperCase();
		String s = (new SimpleDateFormat("EEEE", Locale.ENGLISH)).format(date.getTime()).toUpperCase();
		System.out.println((new SimpleDateFormat("EEEE", Locale.ENGLISH)).format(date.getTime()).toUpperCase());
	}

}
