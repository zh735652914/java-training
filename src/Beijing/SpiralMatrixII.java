package Beijing;
/*
https://leetcode-cn.com/problems/spiral-matrix-ii/
 */

public class SpiralMatrixII {
    // 上下左右控制好就行
    static class Solution {
        public int[][] generateMatrix(int n) {
            int[][] ans = new int[n][n];
            int top = 0, bottom = n - 1, left = 0, right = n - 1;
            int count = 1, max = n * n;
            while (count <= max) {
                for (int i = left; i <= right; i++) {
                    ans[top][i] = count;
                    count++;
                }
                top++;
                for (int i = top; i <= bottom; i++) {
                    ans[i][right] = count;
                    count++;
                }
                right--;
                for (int i = right; i >= left; i--) {
                    ans[bottom][i] = count;
                    count++;
                }
                bottom--;
                for (int i = bottom; i >= top; i--) {
                    ans[i][left] = count;
                    count++;
                }
                left++;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] ans = new Solution().generateMatrix(n);
        for (int[] an : ans) {
            for (int i : an) {
                System.out.print(i + ", ");
            }
            System.out.println();
        }
    }
}
