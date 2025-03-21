package next;

import org.junit.Test;

/**
 * @author zhouhao
 * @date 2025/3/21 08:47
 * https://leetcode.cn/problems/word-search/
 */
public class LeetCode79 {
    final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    boolean[][] visited;

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
        if (x >= board.length || y >= board[0].length || x < 0 || y < 0) {
            return false;
        }
        if (board[x][y] != word.charAt(index) || visited[x][y]) {
            return false;
        }
        visited[x][y] = true;
        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (find(board, word, nextX, nextY, index + 1)) {
                return true;
            }
        }
        visited[x][y] = false;
        return false;
    }

    @Test
    public void test() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }
}
