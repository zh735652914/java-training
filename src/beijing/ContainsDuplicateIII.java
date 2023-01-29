package beijing;
/*
https://leetcode-cn.com/problems/contains-duplicate-iii/
 */

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateIII {
    // 这题真的不好写，自己看了解析都不会写！！
    static class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            Map<Long, Long> map = new HashMap<>();
            long w = (long) t + 1;
            for (int i = 0; i < nums.length; i++) {
                long id = getId(nums[i], w);
                if (map.containsKey(id)) {
                    return true;
                }
                if (map.containsKey(id - 1) && Math.abs(nums[i] - map.get(id - 1)) < w) {
                    return true;
                }
                if (map.containsKey(id + 1) && Math.abs(nums[i] - map.get(id + 1)) < w) {
                    return true;
                }
                map.put(id, (long) nums[i]);
                if (i >= k) {
                    map.remove(getId(nums[i - k], w));
                }
            }
            return false;
        }

        private long getId(long x, long t) {
            if (x >= 0) {
                return x / t;
            }
            return (x + 1) / t - 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 9, 1, 5, 9};
        int k = 2, t = 3;
        System.out.println(new Solution().containsNearbyAlmostDuplicate(nums, k, t));
    }
}
