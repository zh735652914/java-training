package beijing;
/*
https://leetcode.cn/problems/merge-sorted-array/
 */

import java.util.Arrays;

/**
 * @author zhouhao
 * @date 2023/8/17 12:31
 */
public class MergeSortedArray_88_HotOneHundred {
    // 很简单的题
    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int index = nums1.length - 1;
            m--;
            n--;
            while (index >= 0 && m >= 0 && n >= 0) {
                nums1[index--] = nums1[m] >= nums2[n] ? nums1[m--] : nums2[n--];
            }
            while (n >= 0) {
                nums1[index--] = nums2[n--];
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
