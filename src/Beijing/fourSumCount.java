package Beijing;
/*
https://leetcode.cn/problems/4sum-ii/
 */

import java.util.HashMap;
import java.util.Map;

// 看了评论才会，还比较重要，看过就很简单
public class fourSumCount {
    static class Solution {
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int k : nums1) {
                for (int i : nums2) {
                    int key = k + i;
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
            }
            int count = 0;
            for (int a : nums3) {
                for (int b : nums4) {
                    int key = -(a + b);
                    count += map.getOrDefault(key, 0);
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2}, nums2 = {-2, -1}, nums3 = {-1, 2}, nums4 = {0, 2};
        System.out.println(new Solution().fourSumCount(nums1, nums2, nums3, nums4));
    }
}
