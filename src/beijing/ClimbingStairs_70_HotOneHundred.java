package beijing;
/*
https://leetcode.cn/problems/climbing-stairs/
 */

/**
 * @author zhouhao
 * @date 2023/7/16 16:29
 */
public class ClimbingStairs_70_HotOneHundred {
    // 滚动数组
    static class Solution {
        public int climbStairs(int n) {
            int two = 0, one = 0, cur = 1;
            for (int i = 1; i <= n; i++) {
                two = one;
                one = cur;
                cur = one + two;
            }
            return cur;
        }
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new Solution().climbStairs(n));
    }
}
