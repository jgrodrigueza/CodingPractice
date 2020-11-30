//https://www.geeksforgeeks.org/search-a-word-in-a-2d-grid-of-characters/

package com.backtrack;

public class WordSoup {
	  
    // Rows and columns in the given grid 
    static int rows, cols; 
  
    // For searching in all 8 directions (clockwise from 00:00)
    // 0,-1 (00:00): Up
    // 0, 1 (01:30): Diagonal forward-up
    // 1,-1 (03:00): Forward
    // 1, 1 (04:30): Diagonal forward-down
    // 1, 0 (06:00): Down
    //-1,-1 (07:30): Diagonal back-down
    //-1, 0 (09:00): Back
    //-1, 1 (10:30): Diagonal back-up
    static int[] xMove = {  0, 0,  1, 1, 1, -1, -1, -1 };
    static int[] yMove = { -1, 1, -1, 1, 0, -1,  0,  1 };
  
    // This function searches in all 8-direction from starting point (row, col) in grid[][] 
    static boolean checkWord(char[][] grid, int row, int col, String word) {

    	int wordLen = word.length();
  
        // Search word in all 8 directions starting from (row, col) 
        for (int searchDirection = 0; searchDirection < 8; searchDirection++) {
            // Initialize starting point for current direction 
            int wordPos = 0;
            int rowDir = row + xMove[searchDirection];
            int colDir = col + yMove[searchDirection]; 
  
            // First letter is checked, we start on second letter. 
            for (wordPos = 1; wordPos < wordLen; wordPos++) { 
                
            	// If the boundaries of the grid are reached, exit as the word is not complete. 
                if (rowDir >= rows || rowDir < 0 || colDir >= cols || colDir < 0) {
                    break;
                }
  
                // If there is no match, exit as the word is not complete.
                if (grid[rowDir][colDir] != word.charAt(wordPos)) {
                    break;
                }
  
                // Moving in particular direction 
                rowDir += xMove[searchDirection];
                colDir += yMove[searchDirection];
            }
  
            // If all character matched, then value of must be equal to length of word 
            if (wordPos == wordLen) {
                return true;
            }
        }
        return false; 
    }
  
    //Initiates the search of the word, using each cell as starting point.
    static void searchWord(char[][] grid, String word) {
        int ocurrences = 1;
    	for (int row = 0; row < rows; row++) { //Iterates row by row.
            for (int col = 0; col < cols; col++) { //Iterates every column in each row.
            	if (word.charAt(0) == grid[row][col]) { //Searches for word only in cells where the first letter matches.
                    if (checkWord(grid, row, col, word)) {
                    	System.out.println(ocurrences + ". Pattern '" + word + "' found at Row: " + row + ", Col: " + col);
                    	ocurrences++;
                    }
            	}
            }
        }
    }
  
    // Driver code 
    public static void main(String args[]) {
        rows = 20; 
        cols = 20; 
        char[][] wordGrid = {
        		/*00*/ {'G','S','D','D','A','D','N','N','S','A','R','Y','U','I','O','S','M','K','L','P'},
        		/*01*/ {'T','O','D','H','H','S','K','A','S','U','D','H','D','J','K','L','I','S','A','O'},
        		/*02*/ {'F','H','O','A','O','P','A','H','I','O','A','N','G','C','X','R','C','M','S','I'},
        		/*03*/ {'Q','E','R','G','Y','U','I','P','A','T','Q','W','O','R','Y','T','R','I','J','W'},
        		/*04*/ {'P','O','U','Y','L','R','W','E','F','Q','U','L','O','J','A','A','O','C','S','T'},
        		/*05*/ {'K','L','H','G','A','E','B','O','N','M','E','R','G','A','I','V','S','R','G','B'},
        		/*06*/ {'T','H','G','F','T','U','S','Y','T','W','P','A','L','K','C','G','O','D','A','F'},
        		/*07*/ {'F','D','Y','W','Q','O','Q','W','R','Q','W','R','E','A','X','K','F','G','B','S'},
        		/*08*/ {'O','A','B','H','R','T','Y','U','J','K','S','C','Z','V','N','F','T','M','N','D'},
        		/*09*/ {'S','M','N','C','Z','C','T','Y','E','O','O','S','O','F','T','D','K','A','J','K'},
        		/*10*/ {'O','U','I','I','A','S','M','I','C','R','G','H','M','B','A','A','L','B','F','M'},
        		/*11*/ {'R','M','A','C','X','V','B','N','Q','I','O','Y','R','D','A','N','B','K','A','B'},
        		/*12*/ {'C','I','U','P','R','Q','E','Y','X','F','T','F','O','S','O','R','C','I','M','R'},
        		/*13*/ {'I','Q','S','L','N','O','B','G','H','A','Z','A','Q','T','Y','A','P','K','A','E'},
        		/*14*/ {'M','T','D','F','G','G','S','X','V','N','A','X','J','A','D','V','B','L','X','F'},
        		/*15*/ {'B','E','R','A','Y','T','A','O','U','N','Y','H','F','E','L','G','O','O','G','H'},
        		/*16*/ {'A','M','I','C','R','O','S','O','F','T','D','A','A','Y','G','N','S','O','Q','N'},
        		/*17*/ {'T','G','B','E','D','F','A','N','V','T','X','U','I','B','M','Y','T','X','O','X'},
        		/*18*/ {'W','A','B','N','Q','A','G','A','K','L','O','P','R','W','R','N','V','A','S','Z'},
        		/*19*/ {'M','N','B','V','C','G','H','I','P','R','Y','T','F','O','S','O','R','C','I','M'}}; 
        searchWord(wordGrid, "MICROSOFT"); 
        searchWord(wordGrid, "IBM");
        searchWord(wordGrid, "GOOGLE"); 
    }
    
}
