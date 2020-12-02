//https://www.hackerrank.com/challenges/connected-cell-in-a-grid/problem

package com.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ConnectedCellsInAGrid {

    //                        U  UR   R  DR   D  DL   L  UL                        
    static int[] rowDir = {-1, -1, +0, +1, +1, +1, +0, -1};
    static int[] colDir = {+0, +1, +1, +1, +0, -1, -1, -1};
    static int rows = 0;
    static int cols = 0;
    static int islands = 0;
    static Set<String> checkedPos = new HashSet<String>();
    static Set<String> currentRegion = new HashSet<String>();
    
    static int connectedCell(int[][] matrix, int matrixRows, int matrixCols) {
        
        rows = matrixRows;
        cols = matrixCols;
        int largest = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String pos = cellCode(row, col);
                if (matrix[row][col] == 1 && !checkedPos.contains(pos)) {
                    checkConnections(matrix, row, col);
                    List<String> sortedList = new ArrayList<>(currentRegion);
                    Collections.sort(sortedList);
                    System.out.println(sortedList);
                    largest = Math.max(largest, currentRegion.size());
                    currentRegion.clear();
                    islands++;
                }
            }
        }
        System.out.println("Total Islands: " + islands);
        return largest;

    }
    
    public static void checkConnections(int[][] grid, int row, int col) {
        
        String pos = cellCode(row, col);
        checkedPos.add(pos);
        currentRegion.add(pos);
        for (int dir = 0; dir < rowDir.length; dir++) {
            int nextRow = row + rowDir[dir];
            int nextCol = col + colDir[dir];
            String nextCell = cellCode(nextRow, nextCol);
            if (0 <= nextRow && nextRow < rows && 0 <= nextCol && nextCol < cols && !checkedPos.contains(nextCell) && grid[nextRow][nextCol] == 1) {
                checkConnections(grid, nextRow, nextCol);
            }
        }
    }
    
    public static String cellCode(int row, int col) {
        
        return "R" + Integer.toString(row) + "-C" + Integer.toString(col);
        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] matrixRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int matrixItem = Integer.parseInt(matrixRowItems[j]);
                matrix[i][j] = matrixItem;
            }
        }

        int result = connectedCell(matrix, n, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
