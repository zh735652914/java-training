package interview;

import java.util.Scanner;

public class xiaomi_bishi2 {
    int[] where_row = {0, 1, 0, -1};
    int[] where_col = {1, 0, -1, 0};

    private boolean solution(String s, char[][] board) {
        if (s.length() == 0 || s.equals(" ")) {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (isTheWay(board, s, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isTheWay(char[][] board, String s, int row, int col, int index, boolean[][] visited) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] || board[row][col] != s.charAt(index)) {
            return false;
        }
        index++;
        if (index == s.length()) {
            return true;
        }
        visited[row][col] = true;
        for (int i = 0; i < where_col.length; i++) {
            if (isTheWay(board, s, row + where_row[i], col + where_col[i], index, visited)) {
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        while (scanner.hasNext()) {
            System.out.println(new xiaomi_bishi2().solution(scanner.nextLine(), board));
        }
    }
}
