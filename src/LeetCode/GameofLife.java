package LeetCode;
/*
289. Game of Life
Medium

1363

241

Add to List

Share
According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by
 the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its
eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state. The next state is
created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur
 simultaneously.

Example:

Input:
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
Output:
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]
Follow up:

Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some
 cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause 3
problems when the active area encroaches the border of the array. How would you address these problems?
 */

public class GameofLife {
    static class GameofLifeSolution {
        public void gameOfLife(int[][] board) {
            int[] nextGeneration;
            int[] thePer = nextStatus(board, 0);
            for (int i = 1; i < board.length; ) {
                nextGeneration = nextStatus(board, i);
                board[++i - 2] = thePer;
                thePer = nextGeneration;
            }
            board[board.length - 1] = thePer;


            OUTPUT(board);
        }

        private int[] nextStatus(int[][] board, int n) {
            int[] nextGeneration = new int[board[n].length];
            for (int i = 0; i < board[n].length; i++) {
                nextGeneration[i] = calculation(board, n, i);
            }
            return nextGeneration;
        }

        private int calculation(int[][] board, int x, int y) {
            int count = 0;
            if (x - 1 >= 0) {
                if (y - 1 >= 0 && board[x - 1][y - 1] == 1) count++;
                if (y + 1 < board[x - 1].length && board[x - 1][y + 1] == 1) count++;
                if (board[x - 1][y] == 1) count++;
            }
            if (x + 1 < board.length) {
                if (y - 1 >= 0 && board[x + 1][y - 1] == 1) count++;
                if (y + 1 < board[x + 1].length && board[x + 1][y + 1] == 1) count++;
                if (board[x + 1][y] == 1) count++;
            }
            if (y - 1 >= 0 && board[x][y - 1] == 1) count++;
            if (y + 1 < board[x].length && board[x][y + 1] == 1) count++;
            if (board[x][y] == 1) {
                if (count > 3 || count < 2) return 0;
                return 1;
            } else {
                if (count == 3) return 1;
                return 0;
            }
        }


        private void OUTPUT(int[][] nextBoard) {
            for (int[] ints : nextBoard) {
                for (int anInt : ints) {
                    System.out.print(anInt + ",");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        new GameofLifeSolution().gameOfLife(board);
    }
}
