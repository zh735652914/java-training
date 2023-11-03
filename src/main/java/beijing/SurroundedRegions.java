package beijing;
/*
https://leetcode-cn.com/problems/surrounded-regions/
 */

public class SurroundedRegions {
    static class Solution {
        private char[][] board;

        public void solve(char[][] board) {
            this.board = board;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == 'O') {
                        if (i == 0 || j == 0 || i == board.length - 1 || j == board[i].length - 1) {
                            search(i, j);
                        }
                    }
                }
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    }
                }
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == '*') {
                        board[i][j] = 'O';
                    }
                }
            }
        }

        private void search(int x, int y) {
            if (x < 0 || x >= board.length || y < 0 || y >= board[x].length) {
                return;
            }
            if (board[x][y] != 'O') {
                return;
            }
            board[x][y] = '*';
            search(x - 1, y);
            search(x + 1, y);
            search(x, y - 1);
            search(x, y + 1);
        }

        private void OUPUT() {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    System.out.print(board[i][j] + ",");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        new Solution().solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + ",");
            }
            System.out.println();
        }
    }
}
