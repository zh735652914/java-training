package LeetCode;

/*
130. Surrounded Regions
Medium

1079

520

Add to List

Share
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of
the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected
to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent
cells connected horizontally or vertically.
 */
//自己写的死活过不了
class SurroundedRegionsSolution {

//    public void solve(char[][] board) {
//        if (board == null || board.length < 2 || board[0].length < 2) return;
////        boolean[][] visited = new boolean[board.length][board[0].length];
//        boolean[][] border = new boolean[board.length][board[0].length];
//
//        for (int i = 1; i < board.length - 1; i++) {
//            for (int j = 1; j < board[i].length - 1; j++) {
//                if (board[i][j] == 'X') {
////                    visited[i][j] = true;
//                    continue;
//                }
//                if (!isBorder(board, border, i, j)) board[i][j] = 'X';
//            }
//        }
//
//        OutPut(board);
//    }
//
//    private boolean isBorder(char[][] board, boolean[][] border, int x, int y) {
//        if (board[x][y] == 'X') return false;
//        if (x == (board.length - 1) || x == 0) {
//            border[x][y] = true;
//            return true;
//        }
//        if (y == (board[x].length - 1) || y == 0) {
//            border[x][y] = true;
//            return true;
//        }
////        visited[x][y] = true;
//        boolean NotFile = border[x - 1][y] || border[x + 1][y] || border[x][y - 1] || border[x][y + 1];
//        if (NotFile) return NotFile;
////        NotFile = (!visited[x - 1][y] && isBorder(board, visited, border, x - 1, y)) ||
////                (!visited[x + 1][y] && isBorder(board, visited, border, x + 1, y)) ||
////                (!visited[x][y - 1] && isBorder(board, visited, border, x, y - 1)) ||
////                (!visited[x][y + 1] && isBorder(board, visited, border, x, y + 1));
//
//        NotFile = isBorder(board, border, x + 1, y) || isBorder(board, border, x, y + 1);
//
//        border[x][y] = NotFile;
////        if (!NotFile) board[x][y] = 'X';
//        return NotFile;
//    }

//    private boolean isBorder(char[][] board, boolean[][] visited, int x, int y) {
//        visited[x][y] = true;
//        if (board[x][y] == 'X') return false;
//        if (x == (board.length - 1) || x == 0) return true;
//        if (y == board[x].length - 1 || y == 0) return true;
//        boolean NotFlip = (!visited[x - 1][y] && isBorder(board, visited, x - 1, y)) ||
//                (!visited[x + 1][y] && isBorder(board, visited, x + 1, y)) ||
//                (!visited[x][y - 1] && isBorder(board, visited, x, y - 1)) ||
//                (!visited[x][y + 1] && isBorder(board, visited, x, y + 1));
//        if (!NotFlip) board[x][y] = 'X';
//        return NotFlip;
//    }

    private void OutPut(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length < 2 || board[0].length < 2) return;
        for (int i = 0; i < board.length; i++) {
            dfs(board, i, 0);
            dfs(board, i, board[0].length - 1);
        }
        for (int i = 0; i < board[0].length; i++) {
            dfs(board, 0, i);
            dfs(board, board.length - 1, i);
        }
//        OutPut(board);
//        System.out.println();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '*') board[i][j] = 'O';
            }
        }

        OutPut(board);
    }

    private void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[x].length) return;

        if (board[x][y] == 'X' || board[x][y] == '*') return;
        board[x][y] = '*';
        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
    }
}

public class SurroundedRegions {
    public static void main(String[] args) {
//        char[][] board = {
//                {'X', 'X', 'X', 'X'},
//                {'X', 'O', 'O', 'X'},
//                {'X', 'X', 'O', 'X'},
//                {'X', 'O', 'X', 'X'}
//        };
        char[][] board = {
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'}
        };
//        char[][] board = {
//                {'X', 'O', 'X', 'O', 'X', 'O'},
//                {'O', 'X', 'O', 'X', 'O', 'X'},
//                {'X', 'O', 'X', 'O', 'X', 'O'},
//                {'O', 'X', 'O', 'X', 'O', 'X'}
//        };
//        char[][] board = {
//                {'O', 'O', 'O', 'O', 'X', 'X'},
//                {'O', 'O', 'O', 'O', 'O', 'O'},
//                {'O', 'X', 'O', 'X', 'O', 'O'},
//                {'O', 'X', 'O', 'O', 'X', 'O'},
//                {'O', 'X', 'O', 'X', 'O', 'O'},
//                {'O', 'X', 'O', 'O', 'O', 'O'}
//        };
//        char[][] board = {
//                {'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
//                {'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'X'},
//                {'O', 'X', 'O', 'X', 'O', 'O', 'O', 'O', 'X'},
//                {'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O'},
//                {'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X'},
//                {'X', 'X', 'O', 'O', 'X', 'O', 'X', 'O', 'X'},
//                {'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O'},
//                {'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O'},
//                {'O', 'O', 'O', 'O', 'O', 'X', 'X', 'O', 'O'}
//        };
        SurroundedRegionsSolution surroundedRegionsSolution = new SurroundedRegionsSolution();
        surroundedRegionsSolution.solve(board);
    }
}

