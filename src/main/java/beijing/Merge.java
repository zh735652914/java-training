package beijing;
/*
https://leetcode.cn/problems/merge-sorted-array/
 */

import java.util.Arrays;

/**
 * @author zhouhao
 * @date 2023/8/13 11:12
 */
public class Merge {
    // 这题面试遇到就尴尬了
    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int index = nums1.length - 1;
            while (m > 0 || n > 0) {
                if (m == 0) {
                    nums1[index] = nums2[n - 1];
                    n--;
                } else if (n == 0) {
                    nums1[index] = nums1[m - 1];
                    m--;
                } else if (nums1[m - 1] >= nums2[n - 1]) {
                    nums1[index] = nums1[m - 1];
                    m--;
                } else {
                    nums1[index] = nums2[n - 1];
                    n--;
                }
                index--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        new Solution().merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
