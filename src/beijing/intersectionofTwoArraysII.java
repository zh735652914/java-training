package beijing;
/*
https://leetcode.cn/problems/intersection-of-two-arrays-ii/
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 这题好像没有那么简单
public class intersectionofTwoArraysII {
    static class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            if (nums1.length < nums2.length) {
                return intersect(nums2, nums1);
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums1) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            int[] T = new int[nums2.length];
            int index = 0;
            for (int j : nums2) {
                if (map.containsKey(j)) {
                    T[index++] = j;
                    if (map.get(j) == 1) {
                        map.remove(j);
                    } else {
                        map.put(j, map.get(j) - 1);
                    }
                }
            }
            return Arrays.copyOfRange(T, 0, index);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1}, nums2 = {2, 2};
        int[] ans = new Solution().intersect(nums1, nums2);
        for (int x : ans) {
            System.out.print(x + ", ");
        }
    }
}
