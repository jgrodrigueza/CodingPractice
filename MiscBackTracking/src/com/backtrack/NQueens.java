//https://www.geeksforgeeks.org/java-program-for-n-queen-problem-backtracking-3/

/*
 	1) Start in the leftmost column
	2) If all queens are placed
    	return true
	3) Try all rows in the current column. 
	   	Do following for every tried row.
		    a) If the queen can be placed safely in this row 
		       then mark this [row, column] as part of the 
		       solution and recursively check if placing
		       queen here leads to a solution.
		    b) If placing the queen in [row, column] leads to
		       a solution then return true.
		    c) If placing queen doesn't lead to a solution then
		       unmark this [row, column] (Backtrack) and go to 
		       step (a) to try other rows.
	3) If all rows have been tried and nothing worked,
   		return false to trigger backtracking.
*/

package com.backtrack;

public class NQueens {

    final static int boardSize = 4; //Assumes board size is square. 
    
    public static void main(String args[]) {
    	
    	//Build the board - START
    	int board[][] = new int[boardSize][boardSize];
    	for (int row = 0; row < boardSize; row++) {
    		for (int col = 0; col < boardSize; col++) {
    			board[row][col] = 0;
    		}
    	} //Build the board - END
	    
    	if (placeQueens(board, 0) == false) { //Start on column 0
	        System.out.print("Solution does not exist"); 
	    } else {
	    	printSolution(board); 
	    }
    }
  
    //Recursive function to place the queens in the board.
    static boolean placeQueens(int board[][], int col) { 
        if (col >= boardSize) { //If all queens are placed then return true
            return true; 
        }
        for (int row = 0; row < boardSize; row++) { //Consider this column and try placing this queen in all rows
            if (isSafe(board, row, col)) { //Check if the queen can be placed.
                board[row][col] = 1; //Place the queen
                if (placeQueens(board, col + 1) == true) { //Recursive call
                    return true;
                }
                board[row][col] = 0; //Backtrack, we undo the operation if we don't have a solution.
            }
        }
        return false; //Return false if no solution was found.
    }

    /* A utility function to check if a queen can be placed on board[row][col]. Note that this 
    function is called when "col" queens are already placed in columns from 0 to col - 1. So we need 
    to check only left side for attacking queens*/
    static boolean isSafe(int board[][], int row, int col) { 
        int rowChck, colChck; 
        for (rowChck = 0; rowChck < col; rowChck++) { //Check from column 0 to current column.
            if (board[row][rowChck] == 1) { 
                return false; //A queen exists on the same row.
            }
        }
        for (rowChck = row, colChck = col; rowChck >= 0 && colChck >= 0; rowChck--, colChck--) { //Check upper diagonal.
            if (board[rowChck][colChck] == 1) {
                return false; //A queen exists in the same diagonal.
            }
        }
        for (rowChck = row, colChck = col; colChck >= 0 && rowChck < boardSize; rowChck++, colChck--) {//Check the lower diagonal.
            if (board[rowChck][colChck] == 1) {
                return false; //A queen exists in the same diagonal.
            }
        }
        return true; 
    }

    static void printSolution(int board[][]) { 
        for (int i = 0; i < boardSize; i++) { 
            for (int j = 0; j < boardSize; j++) 
                System.out.print(" " + board[i][j] 
                                 + " "); 
            System.out.println(); 
        }
    }

}