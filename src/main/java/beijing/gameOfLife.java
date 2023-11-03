package beijing;
/*
https://leetcode.cn/problems/game-of-life/
 */

// 这题就属于比较简单的中等题了
public class gameOfLife {
    static class Solution {
        private int[][] matrix;
        private final int[][] dirs = {{-1, -1}, {-1, 0}, {0, -1}, {1, 0}, {0, 1}, {1, 1}, {1, -1}, {-1, 1}};

        public void gameOfLife(int[][] board) {
            matrix = new int[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                System.arraycopy(board[i], 0, matrix[i], 0, board[i].length);
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (canLive(i, j)) {
                        board[i][j] = 1;
                    } else {
                        board[i][j] = 0;
                    }
                }
            }
        }

        private boolean canLive(int x, int y) {
            int NbX, NbY;
            int count = 0;
            for (int[] dir : dirs) {
                NbX = x + dir[0];
                NbY = y + dir[1];
                if (NbX >= 0 && NbX < matrix.length && NbY >= 0 && NbY < matrix[0].length) {
                    if (matrix[NbX][NbY] == 1) {
                        count++;
                    }
                }
            }
            return count == 3 || matrix[x][y] == 1 && count == 2;
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
