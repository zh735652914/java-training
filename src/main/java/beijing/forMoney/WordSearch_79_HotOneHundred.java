package beijing.forMoney;

/**
 * https://leetcode.cn/problems/word-search/
 *
 * @author zhouhao
 * @date 2024/6/5 13:13
 */
public class WordSearch_79_HotOneHundred {
    static class Solution {
        private final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        private boolean[][] visited;

        public boolean exist(char[][] board, String word) {
            visited = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (check(board, word, 0, i, j)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean check(char[][] board, String word, int pos, int x, int y) {
            if (pos >= word.length()) {
                return true;
            }
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || word.charAt(pos) != board[x][y] || visited[x][y]) {
                return false;
            }
            visited[x][y] = true;
            boolean find = false;
            for (int[] dir : dirs) {
                find = find || check(board, word, pos + 1, x + dir[0], y + dir[1]);
            }
            visited[x][y] = false;
            return find;
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        System.out.println(new Solution().exist(board, word));
    }
}
