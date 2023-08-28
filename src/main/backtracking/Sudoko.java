package backtracking;

import java.util.Arrays;

/**
 * Problem Description
 * Write a program to solve a Sudoku puzzle by filling the empty cells. Empty cells are indicated by the character '.' You may assume that there will be only one unique solution.
 *
 * Problem Constraints
 * N = 9
 *
 *
 * Input Format
 * First argument is an array of array of characters representing the Sudoku puzzle.
 *
 *
 * Output Format
 * Modify the given input to the required answer.
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [[53..7....], [6..195...], [.98....6.], [8...6...3], [4..8.3..1], [7...2...6], [.6....28.], [...419..5], [....8..79]]
 *
 *
 * Example Output
 * Output 1:
 *
 * [[534678912], [672195348], [198342567], [859761423], [426853791], [713924856], [961537284], [287419635], [345286179]]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Look at the diagrams given in the question.
 */
public class Sudoko {
    public void solveSudoku(char[][] mat) {
        sudoku(mat, 0, 9);
    }

    boolean sudoku(char[][] mat, int cell, int n) {
        if(cell == n*n) {
            return true;
        }
        int i = cell/9;
        int j = cell%9;
        if(mat[i][j] != '.') {
            return sudoku(mat, cell+1, n);
        }
        for(int k=1; k<=n; k++) {
            char ch = (char) (k + 48);
            boolean isSafe = isSafe(mat, i, j, ch, n);
            if(isSafe) {
                mat[i][j] = ch;
                boolean ans = sudoku(mat, cell+1, n);
                if(ans) {
                    return true;
                }
                mat[i][j] = '.';
            }
        }
        return false;
    }

    boolean isSafe(char[][] mat, int row, int col, char k, int n) {
        // check cols
        for(int j=0; j<n; j++) {
            if(mat[row][j] == k) {
                return false;
            }
        }
        // check rows
        for(int i=0; i<n; i++) {
            if(mat[i][col] == k) {
                return false;
            }
        }
        // check 3*3 box
        int startRow = row - (row % 3);
        int startCol = col - (col % 3);
        for(int i=startRow; i<startRow+3; i++) {
            for(int j=startCol; j<startCol+3; j++) {
                if(mat[i][j] == k) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Sudoko ob = new Sudoko();
        char[][] sudoko = new char[][] {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(Arrays.deepToString(sudoko)); //[[5, 3, ., ., 7, ., ., ., .], [6, ., ., 1, 9, 5, ., ., .], [., 9, 8, ., ., ., ., 6, .], [8, ., ., ., 6, ., ., ., 3], [4, ., ., 8, ., 3, ., ., 1], [7, ., ., ., 2, ., ., ., 6], [., 6, ., ., ., ., 2, 8, .], [., ., ., 4, 1, 9, ., ., 5], [., ., ., ., 8, ., ., 7, 9]]
        ob.solveSudoku(sudoko);
        System.out.println(Arrays.deepToString(sudoko)); //[[5, 3, 4, 6, 7, 8, 9, 1, 2], [6, 7, 2, 1, 9, 5, 3, 4, 8], [1, 9, 8, 3, 4, 2, 5, 6, 7], [8, 5, 9, 7, 6, 1, 4, 2, 3], [4, 2, 6, 8, 5, 3, 7, 9, 1], [7, 1, 3, 9, 2, 4, 8, 5, 6], [9, 6, 1, 5, 3, 7, 2, 8, 4], [2, 8, 7, 4, 1, 9, 6, 3, 5], [3, 4, 5, 2, 8, 6, 1, 7, 9]]
    }
}
