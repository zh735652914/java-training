package interview;
/*
https://leetcode.cn/problems/house-robber-iv/?envType=daily-question&envId=2023-09-19
 */

import java.util.Arrays;

/**
 * @author zhouhao
 * @date 2023/9/19 22:13
 */
// 自己想不到用二分
public class MinCapability {
    static class Solution {
        public int minCapability(int[] nums, int k) {
            int low = Arrays.stream(nums).min().getAsInt();
            int high = Arrays.stream(nums).max().getAsInt();
            while (low <= high) {
                int mid = low + (high - low) / 2;
                int count = 0;
                boolean visitedLast = false;
                for (int num : nums) {
                    if (num <= mid && !visitedLast) {
                        count++;
                        visitedLast = true;
                    } else {
                        visitedLast = false;
                    }
                }
                if (count >= k) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 9};
        int k = 2;
        System.out.println(new Solution().minCapability(nums, k));
    }
}
