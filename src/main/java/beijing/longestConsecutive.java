package beijing;
/*
https://leetcode-cn.com/problems/longest-consecutive-sequence/
 */

import java.util.HashSet;
import java.util.Set;

public class longestConsecutive {
    // 还是使用set，但是这种去重的方法很重要
    static class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>(nums.length);
            for (int num : nums) {
                set.add(num);
            }
            int ans = 0;
            for (int num : set) {
                if (!set.contains(num - 1)) {
                    int nextNum = num + 1;
                    while (set.contains(nextNum)) {
                        nextNum++;
                    }
                    ans = Math.max(ans, nextNum - num);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(new Solution().longestConsecutive(nums));
    }
}
