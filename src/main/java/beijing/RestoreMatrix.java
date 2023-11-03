package beijing;
/*
https://leetcode.cn/problems/find-valid-matrix-given-row-and-column-sums/
 */

/**
 * @author zhouhao
 * @date 2023/3/14 12:09
 */
public class RestoreMatrix {
    // 不看解析我不会写
    static class Solution {
        public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
            int[][] ans = new int[rowSum.length][colSum.length];
            int x = 0, y = 0;
            while (x < rowSum.length && y < colSum.length) {
                int val = Math.min(rowSum[x], colSum[y]);
                rowSum[x] -= val;
                colSum[y] -= val;
                ans[x][y] = val;
                if (rowSum[x] == 0) {
                    x++;
                }
                if (colSum[y] == 0) {
                    y++;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] rowSum = {3, 8}, colSum = {4, 7};
        int[][] ans = new Solution().restoreMatrix(rowSum, colSum);
        for (int[] row : ans) {
            for (int col : row) {
                System.out.print(col + ", ");
            }
            System.out.println();
        }
    }
}
