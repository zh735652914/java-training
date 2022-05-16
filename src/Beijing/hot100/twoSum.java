package Beijing.hot100;
/*
https://leetcode.cn/problems/two-sum/
 */

import java.util.HashMap;
import java.util.Map;

public class twoSum {
    // 官方解析
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(target - nums[0], 0);
            for (int i = 1; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    return new int[]{map.get(nums[i]), i};
                } else {
                    map.put(target - nums[i], i);
                }
            }
            return new int[]{-1, -1};
        }
    }

    // 自己写的还是不行
    static class Solution0 {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length - 1; i++) {
                int T = target - nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    if (T == nums[j]) {
                        return new int[]{i, j};
                    }
                }
            }
            return new int[]{-1, -1};
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 5, 11};
        int target = 10;
        int[] ans = new Solution().twoSum(nums, target);
        for (int x : ans) {
            System.out.print(x + ", ");
        }
    }
}
