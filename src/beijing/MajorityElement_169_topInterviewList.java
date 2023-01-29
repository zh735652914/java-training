package beijing;
/*
https://leetcode.cn/problems/majority-element/
 */

public class MajorityElement_169_topInterviewList {
    // 怎么第四次写就不会了呢
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
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(new Solution().majorityElement(nums));
    }
}
