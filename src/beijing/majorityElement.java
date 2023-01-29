package beijing;
/*
https://leetcode-cn.com/problems/majority-element/
 */

// 简单题
public class majorityElement {
    static class Solution {
        public int majorityElement(int[] nums) {
            int count = 1;
            int ans = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == ans) {
                    count++;
                } else {
                    if (count == 0) {
                        ans = nums[i];
                        count = 1;
                    } else {
                        count--;
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        System.out.println(new Solution().majorityElement(nums));
    }
}
