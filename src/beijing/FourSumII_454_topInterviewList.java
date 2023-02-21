package beijing;
/*
https://leetcode.cn/problems/4sum-ii/
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouhao
 * @date 2023/2/21 13:05
 */
public class FourSumII_454_topInterviewList {
    // 这题应该是简单题
    static class Solution {
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int x : nums1) {
                for (int y : nums2) {
                    map.put(x + y, map.getOrDefault(x + y, 0) + 1);
                }
            }
            int ans = 0;
            for (int x : nums3) {
                for (int y : nums4) {
                    ans += map.getOrDefault(-(x + y), 0);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2}, nums2 = {-2, -1}, nums3 = {-1, 2}, nums4 = {0, 2};
        System.out.println(new Solution().fourSumCount(nums1, nums2, nums3, nums4));
    }
}
