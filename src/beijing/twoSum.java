package beijing;
/*
https://leetcode-cn.com/problems/two-sum/
 */

import java.util.HashMap;
import java.util.Map;

public class twoSum {
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] ans = new int[2];
            for (int i = 0; i < nums.length - 1; i++) {
                int T = target - nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == T) {
                        ans[0] = i;
                        ans[1] = j;
                    }
                }
            }
            return ans;
        }

        //牛逼，我没想到这个方法
        public int[] twoSum2(int[] nums, int target) {
            int[] ans = new int[2];
            Map<Integer, Integer> map = new HashMap<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    ans[0] = map.get(nums[i]);
                    ans[1] = i;
                } else {
                    map.put(target - nums[i], i);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Solution solution = new Solution();
        int[] ans = solution.twoSum2(nums, target);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + ",");
        }
    }
}
