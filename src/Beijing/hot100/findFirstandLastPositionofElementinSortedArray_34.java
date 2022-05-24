package Beijing.hot100;
/*
https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 */

public class findFirstandLastPositionofElementinSortedArray_34 {
    // 官方的解析
    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            /*
            L为true，寻找第一个大于等于target的下标，否则寻找第一个大于target的下标
             */
            int left = findBorder(nums, target, true);
            int right = findBorder(nums, target, false) - 1;
            if (left < 0 || left >= nums.length || right < 0 || right >= nums.length || left > right) {
                return new int[]{-1, -1};
            }
            return new int[]{left, right};
        }

        private int findBorder(int[] nums, int target, boolean L) {
            int left = 0, right = nums.length - 1, mid;
            int border = nums.length;   // 这个地方也很重要
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (nums[mid] > target || (nums[mid] >= target && L)) {
                    border = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return border;
        }
    }

    // 自己写的，代码不优美
    static class Solution0 {
        public int[] searchRange(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            int pos = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    pos = mid;
                    break;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (pos == -1) {
                return new int[]{-1, -1};
            }
            int L = pos;
            int R = pos;
            left = 0;
            right = pos - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            L = right + 1;
            left = pos + 1;
            right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            R = left - 1;
            return new int[]{L, R};
        }
    }

    public static void main(String[] args) {
//        int[] nums = {5, 7, 7, 8, 8, 10};
//        int target = 8;
        int[] nums = {1};
        int target = 1;
        int[] ans = new Solution().searchRange(nums, target);
        for (int x : ans) {
            System.out.print(x + ", ");
        }
    }
}
