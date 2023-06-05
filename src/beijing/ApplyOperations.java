package beijing;
/*
https://leetcode.cn/problems/apply-operations-to-an-array/
 */

import java.util.Arrays;

/**
 * @author zhouhao
 * @date 2023/6/5 12:37
 */
public class ApplyOperations {
    // 很简单
    static class Solution {
        public int[] applyOperations(int[] nums) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i - 1]) {
                    nums[i] = 0;
                    nums[i - 1] *= 2;
                }
            }
            int left = 0, right = 0;
            while (right < nums.length) {
                if (nums[right] != 0) {
                    nums[left] = nums[right];
                    left++;
                }
                right++;
            }
            while (left < nums.length) {
                nums[left++] = 0;
            }
            return nums;
        }
    }

    public static void main(String[] args) {
        int[] nums = {847, 847, 0, 0, 0, 399, 416, 416, 879, 879, 206, 206, 206, 272};
        System.out.println(Arrays.toString(new Solution().applyOperations(nums)));
    }
}
