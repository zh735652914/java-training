package Beijing;
/*
https://leetcode-cn.com/problems/find-peak-element/
 */

public class findPeakElement {
    static class Solution {
        // 别的写的，很牛逼
        // 只要数组中存在一个元素比相邻元素大，那么沿着它一定可以找到一个峰值！！
        public int findPeakElement(int[] nums) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] < nums[mid + 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        int[] nums = {2, 1, 1, 2, 3, 3};
        System.out.println(new Solution().findPeakElement(nums));
    }
}
