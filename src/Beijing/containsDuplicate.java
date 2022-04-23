package Beijing;
/*
https://leetcode-cn.com/problems/contains-duplicate/
 */

import java.util.HashSet;
import java.util.Set;

public class containsDuplicate {
    static class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                if (set.contains(num)) {
                    return true;
                } else {
                    set.add(num);
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(new Solution().containsDuplicate(nums));
    }
}
