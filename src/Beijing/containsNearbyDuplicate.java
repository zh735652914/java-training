package Beijing;
/*
https://leetcode-cn.com/problems/contains-duplicate-ii/
 */

import java.util.HashMap;
import java.util.Map;

public class containsNearbyDuplicate {
    static class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i]) && Math.abs(i - map.get(nums[i])) <= k) {
                    return true;
                }
                map.put(nums[i], i);
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 1;
        System.out.println(new Solution().containsNearbyDuplicate(nums, k));
    }
}
