package beijing;
/*
https://leetcode-cn.com/problems/valid-sudoku/
 */

public class isValidSudoku {
    static class Solution {
        public boolean isValidSudoku(char[][] board) {
            int[][] row = new int[9][9];
            int[][] col = new int[9][9];
            int[][][] count = new int[3][3][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    char x = board[i][j];
                    if (x == '.') {
                        continue;
                    }
                    int num = x - '0';
                    row[i][num - 1]++;
                    col[j][num - 1]++;
                    count[i / 3][j / 3][num - 1]++;
                    if (row[i][num - 1] > 1 || col[j][num - 1] > 1 || count[i / 3][j / 3][num - 1] > 1) {
                        return false;
                    }
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
