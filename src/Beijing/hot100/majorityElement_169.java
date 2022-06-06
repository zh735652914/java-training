package Beijing.hot100;
/*
https://leetcode.cn/problems/majority-element/
 */

public class majorityElement_169 {
    // 这题也不难
    static class Solution {
        public int majorityElement(int[] nums) {
            int majority = nums[0];
            int count = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == majority) {
                    count++;
                } else {
                    count--;
                    if (count < 0) {
                        majority = nums[i];
                        count = 1;
                    }
                }
            }
            return majority;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(new Solution().majorityElement(nums));
    }
}
