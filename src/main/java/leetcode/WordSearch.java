package leetcode;

/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell,
where "adjacent" cells are those horizontally or vertically neighboring.
The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 */
class WordSearchSolution {

    public boolean exist(char[][] board, String word) {
//        if (word.length() == 0) return true;
//        if (board.length * board[0].length < word.length()) return false;
        boolean[][] used = new boolean[board.length][board[0].length];
//        for (int i = 0; i < used.length; i++) {
//            for (int j = 0; j < used[i].length; j++) {
//                used[i][j] = false;
//            }
//        }
//        int flag = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && bracktrack(board, word, 0, i, j, used)) {
                    return true;
                }
            }
        }
//        if (flag == 1) return true;
        return false;
    }

    private boolean bracktrack(char[][] board, String word, int pos, int x, int y, boolean[][] used) {
        if (pos >= word.length()) return true;

        if (x >= board.length ||
                x < 0 ||
                y < 0 ||
                y >= board[x].length ||
                used[x][y] ||
                board[x][y] != word.charAt(pos)
        ) {
            return false;
        }
        used[x][y] = true;
        if (bracktrack(board, word, pos + 1, x - 1, y, used) ||
                bracktrack(board, word, pos + 1, x + 1, y, used) ||
                bracktrack(board, word, pos + 1, x, y - 1, used) ||
                bracktrack(board, word, pos + 1, x, y + 1, used)
        ) {
            return true;
        }
        used[x][y] = false;
        return false;


//        int flag = 0;
//        if ((x - 1) >= 0 && !used[x - 1][y] && board[x - 1][y] == word.charAt(pos)) {
//            used[x - 1][y] = true;
//            if (bracktrack(board, word, pos + 1, x - 1, y, used)) {
//                flag = 1;
//            }
//            used[x - 1][y] = false;
//        }
//        if ((x + 1) < board.length && !used[x + 1][y] && board[x + 1][y] == word.charAt(pos)) {
//            used[x + 1][y] = true;
//            if (bracktrack(board, word, pos + 1, x + 1, y, used)) flag = 1;
//            used[x + 1][y] = false;
//        }
//        if ((y - 1) >= 0 && !used[x][y - 1] && board[x][y - 1] == word.charAt(pos)) {
//            used[x][y - 1] = true;
//            if (bracktrack(board, word, pos + 1, x, y - 1, used)) flag = 1;
//            used[x][y - 1] = false;
//        }
//        if ((y + 1) < board[x].length && !used[x][y + 1] && board[x][y + 1] == word.charAt(pos)) {
//            used[x][y + 1] = true;
//            if (bracktrack(board, word, pos + 1, x, y + 1, used)) flag = 1;
//            used[x][y + 1] = false;
//        }
//        if (flag == 1) return true;
//        return false;
    }

}

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        WordSearchSolution WS = new WordSearchSolution();
        if (WS.exist(board, word)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
