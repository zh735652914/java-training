package beijing;
/*
https://leetcode-cn.com/problems/count-number-of-pairs-with-absolute-difference-k/
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class countKDifference {
    static class Solution {
        public int countKDifference(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            int count = 0;
            for (int num : nums) {
                if (map.containsKey(num + k)) {
                    count += map.get(num + k);
                }
                if (map.containsKey(num - k)) {
                    count += map.get(num - k);
                }
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            return count;
        }

        public int countKDifference0(int[] nums, int k) {
            Arrays.sort(nums);
            int count = 0, index = 0, p = index + 1;
            while (index < nums.length) {
                if (p >= nums.length) {
                    index++;
                    p = index + 1;
                    continue;
                }
                int diff = nums[p] - nums[index];
                if (diff == k) {
                    count++;
                    p++;
                } else if (diff > k) {
                    index++;
                    p = index + 1;
                } else {
                    p++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 1};
        int k = 1;
        System.out.println(new Solution().countKDifference(nums, k));
    }
}
