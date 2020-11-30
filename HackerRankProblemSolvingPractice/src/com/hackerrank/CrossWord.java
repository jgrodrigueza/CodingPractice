package com.hackerrank;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/*
		String test = "";
		ByteArrayInputStream systemIn = new ByteArrayInputStream(test.getBytes());
    	System.setIn(systemIn);
    	Scanner scan = new Scanner(System.in);
    	
		File file = new File("GameOfThronesTestCase.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st = br.readLine(); 
    	
*/

public class CrossWord {
	
	static String abc = "-ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static String[] board = null;
	static String[] wordArr = null;
	static int rows = 0;
	static int cols = 0;
	
	static void fitWord(int row, int col, char dir, int size) {

		for (int pos = 0; pos < wordArr.length; pos++) {
			if (wordArr[pos].length() == size) {
				if (dir == 'H') {
					StringBuilder temp = new StringBuilder(board[row]);
					for (int wordPos = 0; wordPos < size; wordPos++) {
						temp.setCharAt(col, wordArr[pos].charAt(wordPos));
						col++;
					}
					board[row] = temp.toString();
					break;
				} else if (dir == 'V') {
					for (int wordPos = 0; wordPos < size; wordPos++) {
						StringBuilder temp = new StringBuilder(board[row]);
						temp.setCharAt(col, wordArr[pos].charAt(wordPos));
						board[row] = temp.toString();
						row++;
					}
					break;
				}
			}
		}
	
	}
	
	static void checkSpaces(int row, int col, char dir) {
		
		//Check horizontal
		int hSpaces = 0;
		int vSpaces = 0;
		int rowMv = row;
		int colMv = col;
		if (dir == 'H') {
			while (abc.indexOf(board[row].charAt(colMv)) > -1) {
				colMv++;
				hSpaces++;
			}
			if (hSpaces > 1) {
				fitWord(row, col, dir, hSpaces);
			}
		} else if (dir == 'V') {
			while (abc.indexOf(board[rowMv].charAt(col)) > -1) {
				rowMv++;
				vSpaces++;
			}
			if (vSpaces > 1) {
				fitWord(row, col, dir, vSpaces);
			}
		}
	}

	// Complete the crosswordPuzzle function below.
    static String[] crosswordPuzzle(String[] crossword, String words) {
    	board = crossword;
    	rows = crossword.length;
    	cols = crossword[0].length();
    	wordArr = words.split(";");
    	for (int row = 0; row < board.length; row++) {
    		board[row] = board[row].replace("X", "+");
    		for (int col = 0; col < board.length; col++) {
    			if (board[row].charAt(col) != '+' && board[row].charAt(col + 1) == '-') {
    				checkSpaces(row, col, 'H');
    			}
    			if (board[row].charAt(col) != '+' && board[row + 1].charAt(col) == '-') {
    				checkSpaces(row, col, 'V');
    			}
    		}
    	}
    	return board;

    }

    public static void main(String[] args) throws IOException {
		String test = "++++++++++\r\n+------+++\r\n+++-++++++\r\n+++-++++++\r\n+++-----++\r\n+++-++-+++\r\n++++++-+++\r\n++++++-+++\r\n++++++-+++\r\n++++++++++\r\nPOLAND;LHASA;SPAIN;INDIA";
		ByteArrayInputStream systemIn = new ByteArrayInputStream(test.getBytes());
    	System.setIn(systemIn);
    	Scanner scanner = new Scanner(System.in);
        String[] crossword = new String[10];
        for (int i = 0; i < 10; i++) {
            String crosswordItem = scanner.nextLine();
            crossword[i] = crosswordItem;
        }
        String words = scanner.nextLine();
        String[] result = crosswordPuzzle(crossword, words);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        scanner.close();
    }
}