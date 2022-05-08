package Beijing;
/*
https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 */

// 看了解析才会，但可能后面还是不会写，需要重点看看
public class findUnsortedSubarray {
    static class Solution {
        public int findUnsortedSubarray(int[] nums) {
            int n = nums.length;
            int max = nums[0], min = nums[n - 1];
            int left = n - 1, right = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] < max) {
                    right = i;
                }
                if (nums[n - i - 1] > min) {
                    left = n - i - 1;
                }
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[n - i - 1]);
            }
            return right > left ? right - left + 1 : 0;
        }
    }

    // 自己写的效率太低
    static class Solution0 {
        public int findUnsortedSubarray(int[] nums) {
            int left = 0, right = nums.length - 1;
            int[] maxMin = getMaxMin(nums, left, right);
            while (left < right) {
                if (maxMin[0] == nums[left] && maxMin[1] == nums[right]) {
                    left++;
                    right--;
                } else if (maxMin[0] == nums[left]) {
                    left++;
                } else if (maxMin[1] == nums[right]) {
                    right--;
                } else {
                    break;
                }
                maxMin = getMaxMin(nums, left, right);
            }
            return left == right ? 0 : right - left + 1;
        }

        private int[] getMaxMin(int[] nums, int start, int end) {
            int[] maxMin = new int[2];
            maxMin[0] = nums[start];
            maxMin[1] = nums[start];
            for (int i = start; i <= end; i++) {
                maxMin[0] = Math.min(maxMin[0], nums[i]);
                maxMin[1] = Math.max(maxMin[1], nums[i]);
            }
            return maxMin;
        }
    }

    public static void main(String[] args) {
//        int[] nums = {2, 6, 4, 8, 10, 9, 15}; // 5
//        int[] nums = {1, 3, 2, 4, 5};
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(new Solution().findUnsortedSubarray(nums));
    }
}
