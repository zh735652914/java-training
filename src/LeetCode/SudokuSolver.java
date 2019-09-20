package LeetCode;
/*

https://leetcode.com/problems/sudoku-solver/

Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Empty cells are indicated by the character '.'.


Note:

The given board contain only digits 1-9 and the character '.'.
You may assume that the given Sudoku puzzle will have a single unique solution.
The given board size is always 9x9.
 */

import java.util.ArrayList;
import java.util.List;

class SudokuSolverSolution {
    public void solveSudoku(char[][] board) {

    }

    private Boolean SubBoxes(char[][] board, int x, int y) {
        List<Character> H = new ArrayList<>();
        int flag = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (H.contains(board[x + i][y + j])) {
                    flag = 0;
                    break;
                } else {
                    H.add(board[x + i][y + j]);
                }
            }
        }
        return flag == 1;
    }

    private Boolean Box(char[][] board) {
        int flag = 1;
        for (int i = 0; i < 9; i++) {
            List<Character> R = new ArrayList<>();
            List<Character> C = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                if (R.contains(board[i][j]) || C.contains(board[j][i])) {
                    flag = 0;
                    break;
                } else {
                    R.add(board[i][j]);
                    C.add(board[j][i]);
                }
            }
        }
        return flag == 1;
    }
}

public class SudokuSolver {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        SudokuSolverSolution SSS = new SudokuSolverSolution();
        SSS.solveSudoku(board);
    }
}
