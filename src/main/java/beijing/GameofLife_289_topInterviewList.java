package beijing;
/*
https://leetcode.cn/problems/game-of-life/
 */

/**
 * @author zhouhao
 * @date 2022/12/22 21:49
 */
// 第一次写的更好
public class GameofLife_289_topInterviewList {
    static class Solution {

        private final int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        public void gameOfLife(int[][] board) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    int count = countNeighbors(board, i, j);
                    if (board[i][j] == 0 && count == 3) {
                        board[i][j] = 2;
                    }
                    if (board[i][j] == 1 && (count < 2 || count > 3)) {
                        board[i][j] = -1;
                    }
                }
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == -1) {
                        board[i][j] = 0;
                    } else if (board[i][j] == 2) {
                        board[i][j] = 1;
                    }
                }
            }
        }

        private int countNeighbors(int[][] board, int x, int y) {
            int count = 0;
            for (int[] dir : dirs) {
                int Nx = x + dir[0];
                int Ny = y + dir[1];
                if (Nx >= 0 && Nx < board.length && Ny >= 0 && Ny < board[0].length) {
                    if (board[Nx][Ny] == 1 || board[Nx][Ny] == -1) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        new Solution().gameOfLife(board);
        for (int[] row : board) {
            for (int col : row) {
                System.out.print(col + ", ");
            }
            System.out.println();
        }
    }
}
