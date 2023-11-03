package beijing;
/*
https://leetcode.cn/problems/valid-sudoku/
 */

public class validSudoku_36_topInterviewList {
    // 又是自己不会写的一题
    static class Solution {
        public boolean isValidSudoku(char[][] board) {
            // 记录某行，某位数字是否已经被摆放
            boolean[][] row = new boolean[9][9];
            // 记录某列，某位数字是否已经被摆放
            boolean[][] col = new boolean[9][9];
            // 记录某 3x3 宫格内，某位数字是否已经被摆放
            boolean[][] suBox = new boolean[9][9];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == '.') {
                        continue;
                    }
                    int x = board[i][j] - '1';
                    int index = i / 3 * 3 + j / 3;
                    if (row[i][x] || col[j][x] || suBox[index][x]) {
                        return false;
                    }
                    row[i][x] = true;
                    col[j][x] = true;
                    suBox[index][x] = true;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(new Solution().isValidSudoku(board));
    }
}
