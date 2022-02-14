package Beijing;
/*
https://leetcode-cn.com/problems/single-element-in-a-sorted-array/
 */

public class singleNonDuplicate {
    // 这题的二分法还是要看看的
    static class Solution {
        public int singleNonDuplicate(int[] nums) {
            int L = 0, R = nums.length - 1;
            while (L < R) {
                int mid = (R - L) / 2 + L;
                if (nums[mid] == nums[mid ^ 1]) {
                    L = mid + 1;
                } else {
                    R = mid;
                }
            }
            return nums[L];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(new Solution().singleNonDuplicate(nums));
    }
}
