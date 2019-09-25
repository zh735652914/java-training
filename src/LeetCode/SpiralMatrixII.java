package LeetCode;

/*
Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 */
class SpiralMatrixIISolution {
    public int[][] generateMatrix(int n) {
//        int row = n, col = n, num = 1;
        int[][] ans = new int[n][n];
        int r1 = 0, r2 = n - 1, c1 = 0, c2 = n - 1, num = 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int i = c1; i <= c2; i++) {
                if (num > n * n) break;
                ans[r1][i] = num++;
            }
            for (int i = r1 + 1; i <= r2; i++) {
                if (num > n * n) break;
                ans[i][c2] = num++;
            }
            if (c1 < c2 && r1 < r2) {
                for (int i = c2 - 1; i > c1; i--) {
                    if (num > n * n) break;
                    ans[r2][i] = num++;
                }
                for (int i = r2; i > r1; i--) {
                    if (num > n * n) break;
                    ans[i][c1] = num++;
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return ans;
    }
}

public class SpiralMatrixII {
    public static void main(String[] args) {
        int n = 4;
        SpiralMatrixIISolution SMIIS = new SpiralMatrixIISolution();
        int[][] ans = SMIIS.generateMatrix(n);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
