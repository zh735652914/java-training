package Beijing;
/*
https://leetcode.cn/problems/minimum-limit-of-balls-in-a-bag/
 */

import java.util.Arrays;

/**
 * @author zhouhao
 * @date 2022/12/20 20:49
 */
public class minimumSize {
    // 自己不会写
    static class Solution {
        public int minimumSize(int[] nums, int maxOperations) {
            int left = 1, right = Arrays.stream(nums).max().getAsInt();
            int ans = 0;
            while (left <= right) {
                int y = (left + right) / 2;
                long ops = 0;
                for (int x : nums) {
                    ops += (x - 1) / y;
                }
                if (ops <= maxOperations) {
                    ans = y;
                    right = y - 1;
                } else {
                    left = y + 1;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 8, 2};
        int maxOperations = 4;
        System.out.println(new Solution().minimumSize(nums, maxOperations));
    }
}
