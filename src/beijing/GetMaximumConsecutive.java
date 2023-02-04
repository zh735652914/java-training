package beijing;
/*
https://leetcode.cn/problems/maximum-number-of-consecutive-values-you-can-make/
 */

import java.util.Arrays;

/**
 * @author zhouhao
 * @date 2023/2/4 19:03
 */
// 又是自己不会写的一题
public class GetMaximumConsecutive {
    static class Solution {
        public int getMaximumConsecutive(int[] coins) {
            int ans = 1;
            Arrays.sort(coins);
            for (int coin : coins) {
                if (coin > ans) {
                    break;
                }
                ans += coin;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] coins = {1, 1, 1, 4};
        System.out.println(new Solution().getMaximumConsecutive(coins));
    }
}
