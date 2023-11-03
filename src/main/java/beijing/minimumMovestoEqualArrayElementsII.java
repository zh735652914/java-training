package beijing;
/*
https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/
 */

import java.util.Arrays;

// 这？？？？？
public class minimumMovestoEqualArrayElementsII {
    static class Solution {
        public int minMoves2(int[] nums) {
            int mid = nums.length / 2;
            Arrays.sort(nums);
            int ans = 0;
            for (int i = 0; i < mid; i++) {
                ans += nums[mid] - nums[i];
                ans += nums[nums.length - 1 - i] - nums[mid];
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 10, 2, 9};
        System.out.println(new Solution().minMoves2(nums));
    }
}
