package Beijing.hot100;
/*
https://leetcode.cn/problems/subarray-sum-equals-k/
 */

import java.util.HashMap;
import java.util.Map;

public class subarraySumEqualsK_560 {
    // 自己不会写，但是很重要！！
    static class Solution {
        public int subarraySum(int[] nums, int k) {
            int count = 0, preSum = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            for (int i = 0; i < nums.length; i++) {
                preSum += nums[i];
                if (map.containsKey(preSum - k)) {
                    count += map.get(preSum - k);
                }
                map.put(preSum, map.getOrDefault(preSum, 0) + 1);
            }
            return count;
        }
    }

    // 不是自己写的
    static class Solution0 {
        public int subarraySum(int[] nums, int k) {
            int count = 0;
            for (int start = 0; start < nums.length; start++) {
                int sum = 0;
                for (int end = start; end >= 0; end--) {
                    sum += nums[end];
                    if (sum == k) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(new Solution().subarraySum(nums, k));
    }
}
