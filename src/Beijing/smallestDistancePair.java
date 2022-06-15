package Beijing;
/*
https://leetcode.cn/problems/find-k-th-smallest-pair-distance/
 */

import java.util.Arrays;

// 自己不会写，看了解析后才会，可能第二次还是不会写
public class smallestDistancePair {
    static class Solution {
        public int smallestDistancePair(int[] nums, int k) {
            Arrays.sort(nums);
            int left = 0, right = nums[nums.length - 1] - nums[0];
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int count = 0;
                for (int i = 0, j = 0; i < nums.length; i++) {
                    while (nums[i] - nums[j] > mid) {
                        j++;
                    }
                    count += i - j;
                }
                if (count >= k) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 1};
        int k = 1;
        System.out.println(new Solution().smallestDistancePair(nums, k));
    }
}
