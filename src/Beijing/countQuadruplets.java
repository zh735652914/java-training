package Beijing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
https://leetcode-cn.com/problems/count-special-quadruplets/
 */
public class countQuadruplets {
    // 这种解法我的确不会
    static class Solution {
        public int countQuadruplets(int[] nums) {
            int ans = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int b = nums.length - 3; b >= 1; b--) {
                for (int d = b + 2; d < nums.length; d++) {
                    map.put(nums[d] - nums[b + 1], map.getOrDefault(nums[d] - nums[b + 1], 0) + 1);
                }
                for (int a = 0; a < b; a++) {
                    ans += map.getOrDefault(nums[a] + nums[b], 0);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 5};
        System.out.println(new Solution().countQuadruplets(nums));
    }
}
