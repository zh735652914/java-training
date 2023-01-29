package leetcode.tooffer;
/*
面试题12. 矩阵中的路径
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，
每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。

[["a","b","c","e"],
["s","f","c","s"],
["a","d","e","e"]]

但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。



示例 1：

输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
输出：true
示例 2：

输入：board = [["a","b"],["c","d"]], word = "abcd"
输出：false
提示：

1 <= board.length <= 200
1 <= board[i].length <= 200
注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/

通过次数3,120提交次数6,717
 */

//不难，但是人晕了
public class exist {
    static class Solution {
        public boolean exist(char[][] board, String word) {
            boolean[][] visited = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (dfs(board, visited, word, i, j, 0)) return true;
                }
            }
            return false;
        }

        private boolean dfs(char[][] board, boolean[][] visited, String word, int x, int y, int index) {
            if (index == word.length()) return true;
            if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || visited[x][y] || board[x][y] != word.charAt(index)) {
                return false;
            }
            visited[x][y] = true;
            boolean hasAns = dfs(board, visited, word, x + 1, y, index + 1) || dfs(board, visited, word, x - 1, y, index + 1) ||
                    dfs(board, visited, word, x, y + 1, index + 1) || dfs(board, visited, word, x, y - 1, index + 1);
            visited[x][y] = false;
            return hasAns;
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABFB";
//        String word = "ABCCED";
//        char[][] board = {{'a', 'b'}, {'c', 'd'}};
//        String word = "abcd";
        System.out.println(new Solution().exist(board, word));
    }
}
