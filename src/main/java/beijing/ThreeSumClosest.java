package beijing;
/*
https://leetcode.cn/problems/3sum-closest/
 */

import java.util.Arrays;

/**
 * @author zhouhao
 * @date 2023/7/10 12:31
 */
public class ThreeSumClosest {
    // 前一天每日一题的改版
    static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int midDiff = Integer.MAX_VALUE;
            int ans = 0;
            for (int i = 0; i < nums.length - 2; i++) {
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[left] + nums[right] + nums[i];
                    if (Math.abs(sum - target) < midDiff) {
                        ans = sum;
                        midDiff = Math.abs(sum - target);
                    }
                    if (sum == target) {
                        return sum;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(new Solution().threeSumClosest(nums, target));
    }
}
