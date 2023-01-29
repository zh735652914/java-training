package beijing;
/*
https://leetcode.cn/problems/merge-sorted-array/
 */

public class mergeSortedArray_88_topInterviewList {
    // 怎么简单题还卡了一会
    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int pos = nums1.length - 1;
            while (pos >= 0 && m > 0 && n > 0) {
                nums1[pos--] = nums1[m - 1] >= nums2[n - 1] ? nums1[m-- - 1] : nums2[n-- - 1];
            }
            while (pos >= 0 && n > 0) {
                nums1[pos--] = nums2[n-- - 1];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 5, 6, 0, 0, 0};
        int m = 3;
        int[] nums2 = {1, 2, 3};
        int n = 3;
        new Solution().merge(nums1, m, nums2, n);
        for (int num : nums1) {
            System.out.print(num + ", ");
        }
    }
}
