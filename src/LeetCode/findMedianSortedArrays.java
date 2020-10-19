package LeetCode;
/*
4. 寻找两个正序数组的中位数
给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。

进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？



示例 1：

输入：nums1 = [1,3], nums2 = [2]
输出：2.00000
解释：合并数组 = [1,2,3] ，中位数 2
示例 2：

输入：nums1 = [1,2], nums2 = [3,4]
输出：2.50000
解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
示例 3：

输入：nums1 = [0,0], nums2 = [0,0]
输出：0.00000
示例 4：

输入：nums1 = [], nums2 = [1]
输出：1.00000
示例 5：

输入：nums1 = [2], nums2 = []
输出：2.00000


提示：

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
通过次数274,691提交次数706,285
 */

public class findMedianSortedArrays {
    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int index1 = 0, index2 = 0;
            int sum = nums1.length + nums2.length;
            boolean flag = false;
            if (sum % 2 == 0) {
                flag = true;
            }
            int pos = 0;
            int left = -1, right = -1;
            while (pos <= sum / 2) {
                left = right;
                if (index1 < nums1.length && index2 < nums2.length) {
                    if (nums1[index1] > nums2[index2]) {
                        right = nums2[index2];
                        index2++;
                    } else {
                        right = nums1[index1];
                        index1++;
                    }
                } else if (index1 < nums1.length) {
                    right = nums1[index1];
                    index1++;
                } else if (index2 < nums2.length) {
                    right = nums2[index2];
                    index2++;
                } else {
                    break;
                }
                pos++;
            }
            if (flag) {
                return ((double) left + (double) right) / 2;
            } else {
                return right;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
    }
}
