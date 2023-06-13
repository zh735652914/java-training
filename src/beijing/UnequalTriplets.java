package beijing;
/*
https://leetcode.cn/problems/number-of-unequal-triplets-in-array/
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouhao
 * @date 2023/6/13 12:44
 */
public class UnequalTriplets {
    // 自己居然不会写
    static class Solution {
        public int unequalTriplets(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.merge(num, 1, Integer::sum);
            }
            int ans = 0, left = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                ans += entry.getValue() * left * (nums.length - left - entry.getValue());
                left += entry.getValue();
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 4, 2, 4, 3};
        System.out.println(new Solution().unequalTriplets(nums));
    }
}
