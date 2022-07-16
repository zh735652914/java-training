package Beijing;
/*
https://leetcode.cn/problems/spiral-matrix-ii/
 */

// 还是要控制好上下左右
public class spiralMatrixII_59 {
    static class Solution {
        public int[][] generateMatrix(int n) {
            int[][] ans = new int[n][n];
            int num = 1;
            int left = 0, right = ans[0].length - 1, top = 0, bottom = ans.length - 1;
            while (true) {
                if (left > right) {
                    break;
                }
                for (int i = left; i <= right; i++) {
                    ans[top][i] = num++;
                }
                top++;
                if (top > bottom) {
                    break;
                }
                for (int i = top; i <= bottom; i++) {
                    ans[i][right] = num++;
                }
                right--;
                if (left > right) {
                    break;
                }
                for (int i = right; i >= left; i--) {
                    ans[bottom][i] = num++;
                }
                bottom--;
                if (top > bottom) {
                    break;
                }
                for (int i = bottom; i >= top; i--) {
                    ans[i][left] = num++;
                }
                left++;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] ans = new Solution().generateMatrix(n);
        for (int[] nums : ans) {
            for (int num : nums) {
                System.out.print(num + ", ");
            }
            System.out.println();
        }
    }
}
