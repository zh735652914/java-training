package Beijing;
/*
https://leetcode.cn/problems/majority-element/
 */

public class majorityElement_169 {
    // 记住写法，大胆写就行
    static class Solution {
        public int majorityElement(int[] nums) {
            int major = nums[0];
            int count = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == major) {
                    count++;
                } else {
                    count--;
                    if (count == 0) {
                        major = nums[i];
                        count = 1;
                    }
                }
            }
            return major;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(new Solution().majorityElement(nums));
    }
}
