package com.msint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LocateIslands {

	static int rows = 20;
	static int cols = 20;
	static int islands = 0;
	static List<String> checkedPos = new ArrayList<String>();
	static List<String> currentIsland = new ArrayList<String>();
	
	public static void main(String args[]) {
		
	    int[][] grid = {
	    		/*00*/ {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	    		/*01*/ {0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	    		/*02*/ {0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
	    		/*03*/ {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	    		/*04*/ {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	    		/*05*/ {0,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
	    		/*06*/ {0,1,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
	    		/*07*/ {0,1,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
	    		/*08*/ {0,1,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
	    		/*09*/ {0,1,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
	    		/*10*/ {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
	    		/*11*/ {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
	    		/*12*/ {0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0},
	    		/*13*/ {0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0},
	    		/*14*/ {0,0,0,0,0,1,1,1,1,1,1,0,0,0,1,1,1,1,0,0},
	    		/*15*/ {0,0,0,0,0,1,1,1,1,1,1,0,0,0,1,1,1,0,0,0},
	    		/*16*/ {0,1,1,0,0,1,1,1,1,1,1,0,0,0,1,1,0,0,0,0},
	    		/*17*/ {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
	    		/*18*/ {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	    		/*19*/ {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
	    
	    for (int row = 0; row < rows; row++) {
	    	for (int col = 0; col < cols; col++) {
	    		String pos = cellCode(row, col);
	    		if (grid[row][col] == 1 && !checkedPos.contains(pos)) {
	    			checkIsland(grid, row, col);
	    			Collections.sort(currentIsland);
	    			System.out.println(currentIsland);
	    			currentIsland.clear();
	    			islands++;
	    		}
	    	}
	    }
	    System.out.println("Total Islands: " + islands);
	}

	public static void checkIsland(int[][] grid, int row, int col) {
		
		String pos = cellCode(row, col);
		String posH = cellCode(row, col + 1);
		String posV = cellCode(row + 1, col);
		checkedPos.add(pos);
		currentIsland.add(pos);
		if (grid[row + 1][col] == 1 && !checkedPos.contains(posV)) {
			checkIsland(grid, row + 1, col);
		}
		if (grid[row][col + 1] == 1 && !checkedPos.contains(posH)) {
			checkIsland(grid, row, col + 1);
		}
	}
	
	public static String cellCode(int row, int col) {
		
		return "R" + Integer.toString(row) + "-C" + Integer.toString(col);
		
	}

}