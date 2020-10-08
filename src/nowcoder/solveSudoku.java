package nowcoder;
/*
 牛客题霸-名企高频面试题
数独 相似的企业真题
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：6349
本题知识点： 哈希 回溯
 算法知识视频讲解
题目描述
请编写一个程序，给数独中的剩余的空格填写上数字
空格用字符'.'表示
假设给定的数独只有唯一的解法

这盘数独的解法是：

红色表示填上的解
题解 讨论 通过的代码笔记 纠错 收藏
 */

/*
https://leetcode-cn.com/problems/sudoku-solver/
 */

public class solveSudoku {
    static public class Solution {
        public void solveSudoku(char[][] board) {
            dfs(board, 0, 0);
        }

        private boolean dfs(char[][] board, int x, int y) {
            if (x == 9) {
                return true;
            }
            if (y == 9) {
                return dfs(board, x + 1, y = 0);
            }
            if (board[x][y] != '.') {
                return dfs(board, x, y + 1);
            }
            for (char num = '1'; num <= '9'; num++) {
                if (isVaild(board, x, y, num)) {
                    board[x][y] = num;
                    if (dfs(board, x, y + 1)) {
                        return true;
                    }
                    board[x][y] = '.';
                }
            }
            return false;
        }

        private boolean isVaild(char[][] board, int x, int y, char num) {
            for (int i = 0; i < 9; i++) {
                if (board[i][y] == num) {
                    return false;
                }
            }
            for (int i = 0; i < 9; i++) {
                if (board[x][i] == num) {
                    return false;
                }
            }
            int row = x / 3 * 3;
            int col = y / 3 * 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[row + i][col + j] == num) {
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
        new Solution().solveSudoku(board);
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(aChar + ",");
            }
            System.out.println();
        }
    }
}
