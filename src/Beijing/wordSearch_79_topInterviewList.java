package Beijing;
/*
https://leetcode.cn/problems/word-search/
 */

import java.util.Arrays;

public class wordSearch_79_topInterviewList {
    // 自己写的比较慢
    static class Solution {
        private final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        private boolean[][] visited;

        public boolean exist(char[][] board, String word) {
            visited = new boolean[board.length][board[0].length];
            for (boolean[] row : visited) {
                Arrays.fill(row, false);
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (dfs(board, word, 0, i, j)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(char[][] board, String word, int index, int x, int y) {
            if (index >= word.length()) {
                return true;
            }
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
                return false;
            }
            if (visited[x][y] || word.charAt(index) != board[x][y]) {
                return false;
            }
            boolean flag = false;
            visited[x][y] = true;
            for (int[] dir : dirs) {
                flag = flag || dfs(board, word, index + 1, x + dir[0], y + dir[1]);
            }
            visited[x][y] = false;
            return flag;
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCE";
        System.out.println(new Solution().exist(board, word));
    }
}
