package beijing;
/*
https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 */

import java.util.Arrays;

/**
 * @author zhouhao
 * @date 2023/5/4 12:56
 */
// 自己还是不会写，魔鬼
public class FindFirstandLastPositionofElementinSortedArray_34_HotOneHundred {
    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            int left = findPos(nums, target);
            int right = findPos(nums, target + 1);
            if (left >= nums.length || nums[left] != target) {
                return new int[]{-1, -1};
            }
            return new int[]{left, right - 1};
        }

        // 找第一个大于等于target的数
        private int findPos(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] >= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] ans = new Solution().searchRange(nums, target);
        System.out.println(Arrays.toString(ans));
    }
}
