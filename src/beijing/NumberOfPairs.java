package beijing;
/*
https://leetcode.cn/problems/maximum-number-of-pairs-in-array/
 */

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhouhao
 * @date 2023/2/16 12:52
 */
public class NumberOfPairs {
    // 面试不会遇到这道题
    static class Solution {
        public int[] numberOfPairs(int[] nums) {
            int[] ans = new int[]{0, nums.length};
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                if (!set.contains(num)) {
                    set.add(num);
                } else {
                    set.remove(num);
                    ans[1] -= 2;
                    ans[0]++;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 1, 3, 2, 2};
        int[] ans = new Solution().numberOfPairs(nums);
        for (int num : ans) {
            System.out.print(num + ", ");
        }
    }
}
