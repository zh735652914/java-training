package Beijing;
/*
https://leetcode.cn/problems/advantage-shuffle/
 */

import java.util.Arrays;

public class advantageCount {
    // 自己不会写，看解析都有点懵
    static class Solution {
        public int[] advantageCount(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Integer[] indexs = new Integer[nums2.length];
            for (int i = 0; i < indexs.length; i++) {
                indexs[i] = i;
            }
            Arrays.sort(indexs, (o1, o2) -> nums2[o1] - nums2[o2]);
            int L = 0, R = indexs.length - 1;
            for (int x : nums1) {
                if (x > nums2[indexs[L]]) {
                    nums2[indexs[L++]] = x;
                } else {
                    nums2[indexs[R--]] = x;
                }
            }
            return nums2;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15}, nums2 = {1, 10, 4, 11};
        int[] ans = new Solution().advantageCount(nums1, nums2);
        for (int x : ans) {
            System.out.print(x + ", ");
        }
    }
}
