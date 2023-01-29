package beijing;
/*
https://leetcode.cn/problems/increasing-triplet-subsequence/
 */

/**
 * @author zhouhao
 * @date 2023/1/5 12:58
 */
public class IncreasingTripletSubsequence_334_topInterviewList {
    // 官方解析很详细
    static class Solution0 {
        public boolean increasingTriplet(int[] nums) {
            if (nums.length < 3) {
                return false;
            }
            int[] leftMin = new int[nums.length];
            int[] rightMax = new int[nums.length];
            leftMin[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                leftMin[i] = Math.min(nums[i], leftMin[i - 1]);
            }
            rightMax[nums.length - 1] = nums[nums.length - 1];
            for (int i = nums.length - 2; i >= 0; i--) {
                rightMax[i] = Math.max(nums[i], rightMax[i + 1]);
            }
            for (int i = 1; i < nums.length - 1; i++) {
                if (leftMin[i] < nums[i] && rightMax[i] > nums[i]) {
                    return true;
                }
            }
            return false;
        }
    }

    // 这种写法很牛逼
    static class Solution {
        public boolean increasingTriplet(int[] nums) {
            int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
            for (int num : nums) {
                if (num <= a) {
                    a = num;
                } else if (num <= b) {
                    b = num;
                } else {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {20, 100, 10, 12, 5, 13};
        System.out.println(new Solution().increasingTriplet(nums));
    }
}
