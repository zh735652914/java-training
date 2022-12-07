package Beijing;
/*
https://leetcode.cn/problems/equal-sum-arrays-with-minimum-number-of-operations/
 */

/**
 * @author zhouhao
 * @date 2022/12/7 20:16
 */
// 自己思路都没有
public class EqualSumArraysWithMinimumNumberofOperations_1775 {
    static class Solution {
        public int minOperations(int[] nums1, int[] nums2) {
            if (nums1.length * 6 < nums2.length || nums2.length * 6 < nums1.length) {
                return -1;
            }
            int diff = 0;
            for (int x : nums1) {
                diff += x;
            }
            for (int x : nums2) {
                diff -= x;
            }
            if (diff < 0) {
                diff = -diff;
                int[] tmp = nums2;
                nums2 = nums1;
                nums1 = tmp;
            }
            int[] cnt = new int[6];
            for (int x : nums2) {
                cnt[6 - x]++;
            }
            for (int x : nums1) {
                cnt[x - 1]++;
            }
            int ans = 0;
            for (int i = 5; i >= 0; i--) {
                if (i * cnt[i] >= diff) {
                    return ans + (diff + i - 1) / i;
                } else {
                    ans += cnt[i];
                    diff -= cnt[i] * i;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6}, nums2 = {1, 1, 2, 2, 2, 2};
        System.out.println(new Solution().minOperations(nums1, nums2));
    }
}
