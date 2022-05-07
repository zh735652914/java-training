package Beijing;
/*
https://leetcode-cn.com/problems/subarray-sum-equals-k/
 */

import java.util.HashMap;
import java.util.Map;

// 自己不会写，这题很重要！！！一定要和494题一起看！！
public class subarraySumEqualsK {
    static class Solution {
        public int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            int sum = 0, ans = 0;
            map.put(0, 1);
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (map.containsKey(sum - k)) {
                    ans += map.get(sum - k);
                }
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(new Solution().subarraySum(nums, k));
    }
}
