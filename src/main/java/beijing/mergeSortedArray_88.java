package beijing;
/*
https://leetcode.cn/problems/merge-sorted-array/
 */

// 第一次写的代码更好
public class mergeSortedArray_88 {
    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            if (n == 0) {
                return;
            }
            int index = nums1.length - 1;
            while (index >= 0 && m > 0 && n > 0) {
                if (nums1[m - 1] >= nums2[n - 1]) {
                    nums1[index] = nums1[m - 1];
                    m--;
                } else {
                    nums1[index] = nums2[n - 1];
                    n--;
                }
                index--;
            }
            while (n > 0) {
                nums1[index--] = nums2[n - 1];
                n--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        new Solution().merge(nums1, m, nums2, n);
        for (int num : nums1) {
            System.out.print(num + ", ");
        }
    }
}
