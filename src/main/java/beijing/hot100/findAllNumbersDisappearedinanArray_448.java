package beijing.hot100;
/*
https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/
 */

import java.util.ArrayList;
import java.util.List;

// 第二次自己就不会写了？？？
public class findAllNumbersDisappearedinanArray_448 {
    static class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                int index = Math.abs(nums[i]) - 1;
                nums[index] = -Math.abs(nums[index]);
            }
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    ans.add(i + 1);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(new Solution().findDisappearedNumbers(nums));
    }
}
