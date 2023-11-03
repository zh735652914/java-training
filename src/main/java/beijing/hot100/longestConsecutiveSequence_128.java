package beijing.hot100;
/*
https://leetcode.cn/problems/longest-consecutive-sequence/
 */

import java.util.HashSet;
import java.util.Set;

// 第二次写，自己还是不会
public class longestConsecutiveSequence_128 {
    static class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>(nums.length);
            int ans = 0;
            for (int num : nums) {
                set.add(num);
            }
            for (int num : set) {
                int count = 0;
                if (!set.contains(num - 1)) {
                    while (set.contains(num)) {
                        count++;
                        num++;
                    }
                }
                ans = Math.max(ans, count);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(new Solution().longestConsecutive(nums));
    }
}
