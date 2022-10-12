package Beijing;
/*
https://leetcode.cn/problems/surrounded-regions/
 */

// 居然想了一会才会写
public class surroundedRegions_130_topInterviewList {
    static class Solution {

        private char[][] board;
        private final int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited;

        public void solve(char[][] board) {
            this.board = board;
            visited = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                dfs(i, 0);
                dfs(i, board[0].length - 1);
            }
            for (int i = 0; i < board[0].length; i++) {
                dfs(0, i);
                dfs(board.length - 1, i);
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    } else if (board[i][j] == '*') {
                        board[i][j] = 'O';
                    }
                }
            }
        }

        private void dfs(int x, int y) {
            if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
                return;
            }
            if (board[x][y] != 'O' || visited[x][y]) {
                return;
            }
            board[x][y] = '*';
            visited[x][y] = true;
            for (int[] dir : dirs) {
                dfs(x + dir[0], y + dir[1]);
            }
            visited[x][y] = false;
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
        for (char[] row : board) {
            for (char x : row) {
                System.out.print(x + ", ");
            }
            System.out.println();
        }
    }
}
