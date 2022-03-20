package Beijing;
/*
https://leetcode-cn.com/problems/word-search/
 */

public class WordSearch {
    // 总感觉自己写的不太好，好像题解也是这样写的
    static class Solution {
        private boolean[][] visit;
        private final int[][] dirs = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};

        public boolean exist(char[][] board, String word) {
            visit = new boolean[board.length][board[0].length];
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
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length ||
                    board[x][y] != word.charAt(index) || visit[x][y]) {
                return false;
            }
            visit[x][y] = true;
            boolean ans = false;
            for (int[] dir : dirs) {
                ans = ans || dfs(board, word, index + 1, x + dir[0], y + dir[1]);
            }
            visit[x][y] = false;
            return ans;
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABB";
        System.out.println(new Solution().exist(board, word));
    }
}
