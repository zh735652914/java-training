package beijing;
/*
https://leetcode.cn/problems/word-search/
 */

/**
 * @author zhouhao
 * @date 2023/8/10 13:09
 */
public class WordSearch_79_HotOneHundred {
    static class Solution {
        private final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        private boolean[][] visited;

        public boolean exist(char[][] board, String word) {
            visited = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (find(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean find(char[][] board, String word, int x, int y, int index) {
            if (index >= word.length()) {
                return true;
            }
            if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
                return false;
            }
            if (board[x][y] != word.charAt(index) || visited[x][y]) {
                return false;
            }
            visited[x][y] = true;
            index++;
            for (int[] dir : dirs) {
                if (find(board, word, x + dir[0], y + dir[1], index)) {
                    return true;
                }
            }
            visited[x][y] = false;
            return false;
        }
    }

    public static void main(String[] args) {
//        char[][] board = {
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}
//        };
//        String word = "ABCCED";
        char[][] board = {
                {'A'}
        };
        String word = "A";
        System.out.println(new Solution().exist(board, word));
    }
}
