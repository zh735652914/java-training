package Beijing;
/*
https://leetcode.cn/problems/contains-duplicate/
 */

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate_217_topInterviewList {
    // 用set的确就很没意思了
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
        int[] nums = {1, 2, 3, 1};
        System.out.println(new Solution().containsDuplicate(nums));
    }
}
