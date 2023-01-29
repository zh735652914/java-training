package beijing;

import java.util.Scanner;

public class AmazonTest {
    static class test {
        public int[] solution(int[][] matrix, int m, int n) {
            int[] rows = new int[m];
            for (int i = 0; i < m; i++) {
                for (int x : matrix[i]) {
                    rows[i] += x;
                }
            }
            int[] cols = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    cols[i] += matrix[j][i];
                }
            }
            int[] R = new int[m];
            int[] C = new int[n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    R[i] += rows[j] * Math.abs(j - i);
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    C[i] += cols[j] * Math.abs(j - i);
                }
            }
            int cost = Integer.MAX_VALUE;
            int x = 0, y = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (cost > (R[i] + C[j])) {
                        cost = R[i] + C[j];
                        x = i;
                        y = j;
                    }
                }
            }
            return new int[]{x, y};
        }
    }

    public static void main(String[] args) {
        /*
2 3
0 5 1
2 0 0
         */
        Scanner scanner = new Scanner(System.in);
        String[] firstCol = scanner.nextLine().split(" ");
        int m = Integer.parseInt(firstCol[0]);
        int n = Integer.parseInt(firstCol[1]);
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            String[] tmp = scanner.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        int[] ans = new test().solution(matrix, m, n);
        System.out.print(ans[0] + ", " + ans[1]);
    }
}
