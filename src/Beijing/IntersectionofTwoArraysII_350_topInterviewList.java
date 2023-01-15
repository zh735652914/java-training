package Beijing;
/*
https://leetcode.cn/problems/intersection-of-two-arrays-ii/
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhouhao
 * @date 2023/1/15 13:21
 */
public class IntersectionofTwoArraysII_350_topInterviewList {
    // 自己写的不行
    static class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            Map<Integer, Integer> map1 = new HashMap<>();
            Map<Integer, Integer> map2 = new HashMap<>();
            for (int num : nums1) {
                map1.put(num, map1.getOrDefault(num, 0) + 1);
            }
            for (int num : nums2) {
                map2.put(num, map2.getOrDefault(num, 0) + 1);
            }
            List<Integer> inter = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
                if (map2.containsKey(entry.getKey())) {
                    int count = Math.min(entry.getValue(), map2.get(entry.getKey()));
                    while (count-- > 0) {
                        inter.add(entry.getKey());
                    }
                }
            }
            int[] ans = new int[inter.size()];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = inter.get(i);
            }
            return ans;
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
