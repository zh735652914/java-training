package beijing;
/*
https://leetcode.cn/problems/arithmetic-subarrays/
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouhao
 * @date 2023/3/23 12:53
 */
// 如果暴力的话，就是简单题
public class CheckArithmeticSubarrays {
    static class Solution {
        public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
            List<Boolean> ans = new ArrayList<>();
            for (int i = 0; i < l.length; i++) {
                ans.add(isArithmeticSubarray(nums, l[i], r[i]));
            }
            return ans;
        }

        private boolean isArithmeticSubarray(int[] nums, int l, int r) {
            int max = nums[l], min = nums[l];
            for (int i = l; i <= r; i++) {
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i]);
            }
            if (max == min) {
                return true;
            }
            if ((max - min) % (r - l) != 0) {
                return false;
            }
            int d = (max - min) / (r - l);
            boolean[] count = new boolean[r - l + 1];
            for (int i = l; i <= r; i++) {
                if ((nums[i] - min) % d != 0) {
                    return false;
                }
                int index = (nums[i] - min) / d;
                if (count[index]) {
                    return false;
                }
                count[index] = true;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 6, 5, 9, 3, 7}, l = {0, 0, 2}, r = {2, 3, 5};
        System.out.println(new Solution().checkArithmeticSubarrays(nums, l, r));
    }
}
