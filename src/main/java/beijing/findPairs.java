package beijing;
/*
https://leetcode.cn/problems/k-diff-pairs-in-an-array/
 */

import java.util.Arrays;

public class findPairs {
    // 自己写的双指针
    static class Solution {
        public int findPairs(int[] nums, int k) {
            Arrays.sort(nums);
            int ans = 0;
            int left = 0;
            while (left + 1 < nums.length) {
                int right = left + 1;
                while (right < nums.length) {
                    if (nums[right] - nums[left] > k) {
                        break;
                    }
                    if (nums[right] - nums[left] == k) {
                        ans++;
                        break;
                    } else {
                        right++;
                    }
                }
                while (left + 1 < nums.length && nums[left + 1] == nums[left]) {
                    left++;
                }
                left++;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 5, 4};
        int k = 0;
        System.out.println(new Solution().findPairs(nums, k));
    }
}
