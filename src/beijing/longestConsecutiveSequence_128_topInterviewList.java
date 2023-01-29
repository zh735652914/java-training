package beijing;
/*
https://leetcode.cn/problems/longest-consecutive-sequence/
 */

import java.util.HashSet;
import java.util.Set;

public class longestConsecutiveSequence_128_topInterviewList {
    // 第三次写了，自己还是不会
    static class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            int ans = 0;
            for (int num : set) {
                if (!set.contains(num - 1)) {
                    int count = 1;
                    while (set.contains(num + 1)) {
                        count++;
                        num = num + 1;
                    }
                    ans = Math.max(ans, count);
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
