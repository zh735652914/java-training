package beijing;
/*
https://leetcode.cn/problems/minimum-value-to-get-positive-step-by-step-sum/
 */

// 这题的确不难
public class minStartValue {
    static class Solution {
        public int minStartValue(int[] nums) {
            int min = 0, sum = 0;
            for (int num : nums) {
                sum += num;
                min = Math.min(min, sum);
            }
            return 1 - min;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-3, 2, -3, 4, 2};
        System.out.println(new Solution().minStartValue(nums));
    }
}
