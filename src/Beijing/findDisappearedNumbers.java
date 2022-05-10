package Beijing;
/*
https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/
 */

import java.util.ArrayList;
import java.util.List;

public class findDisappearedNumbers {
    // 这个是自己写的
    static class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                int index = Math.abs(nums[i]) - 1;
                nums[index] = -Math.abs(nums[index]);
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    ans.add(i + 1);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};  // [5,6]
        System.out.println(new Solution().findDisappearedNumbers(nums));
    }
}
