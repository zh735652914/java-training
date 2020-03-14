package Interview;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char[][] matrix = new char[2][n];
        for (int i = 0; i < 2; i++) {
            String tmp = scanner.nextLine();
            for (int j = 0; j < tmp.length(); j++) {
                matrix[i][j] = tmp.charAt(j);
            }
//            System.out.println(tmp);
        }
        System.out.println(new Main().uniquePaths2(2, n, matrix));
    }

//    private int bacxktrack(char[][] matrix, int[][] dp,)

    public int uniquePaths2(int m, int n, char[][] matrix) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0) {
                    dp[j][i] = j == 0 ? 1 : 0;
                } else {
                    if (matrix[j][i] == 'X') {
                        dp[j][i] = 0;
                        continue;
                    }
                    if (j == 0) {
                        dp[j][i] = dp[j][i - 1] + dp[j + 1][i - 1];
                    } else {
                        dp[j][i] = dp[j][i - 1] + dp[j - 1][i - 1];
                    }
//                    dp[j][i] = dp[j][i - 1] + j == 0 ? dp[j + 1][i - 1] : dp[j - 1][i - 1];
                }
            }
        }
        return dp[m - 1][n - 1] == 0 ? -1 : dp[m - 1][n - 1];
    }

    public int uniquePaths(int m, int n, char[][] matrix) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (matrix[i][j] == 'X') {
                    dp[i][j] = -1;
                } else {
//                    if (i == 0)
                    if (j == 0) continue;
                    if (i == 0) {
                        dp[i][j] = dp[i][j - 1] + dp[i + 1][j - 1];
                    } else if (i == 1) {
                        dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                    }
//                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j + 1] + dp[i - 1][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
