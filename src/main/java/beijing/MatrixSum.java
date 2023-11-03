package beijing;
/*
https://leetcode.cn/problems/sum-in-a-matrix/
 */

import java.util.Arrays;

/**
 * @author zhouhao
 * @date 2023/7/4 14:04
 */
public class MatrixSum {
    // 这题是中等？
    static class Solution {
        public int matrixSum(int[][] nums) {
            for (int[] num : nums) {
                Arrays.sort(num);
            }
            int ans = 0;
            int index = nums[0].length - 1;
            while (index >= 0) {
                int max = 0;
                for (int[] num : nums) {
                    max = Math.max(max, num[index]);
                }
                ans += max;
                index--;
            }
            return ans;
        }
    }


    public static void main(String[] args) {
        int[][] nums = {{7, 2, 1}, {6, 4, 2}, {6, 5, 3}, {3, 2, 1}};
        System.out.println(new Solution().matrixSum(nums));
    }
}
