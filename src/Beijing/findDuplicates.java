package Beijing;
/*
https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/
 */

import java.util.ArrayList;
import java.util.List;

// 自己没想出来，等看全题目啊！！
public class findDuplicates {
    static class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                int x = Math.abs(nums[i]);
                if (nums[x - 1] < 0) {
                    ans.add(x);
                } else {
                    nums[x - 1] = -nums[x - 1];
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(new Solution().findDuplicates(nums));
    }
}
