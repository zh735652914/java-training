package Beijing;
/*
https://leetcode-cn.com/problems/find-missing-observations/
 */

public class missingRolls {
    // 自己写的超时了，这个是官方的代码，很精巧
    static class Solution {
        public int[] missingRolls(int[] rolls, int mean, int n) {
            int MissingSum = (n + rolls.length) * mean;
            for (int x : rolls) {
                MissingSum -= x;
            }
            if (MissingSum < n || MissingSum > 6 * n) {
                return new int[]{};
            }
            int[] ans = new int[n];
            int quotient = MissingSum / n;
            int remainder = MissingSum % n;
            for (int i = 0; i < n; i++) {
                ans[i] = quotient + (i < remainder ? 1 : 0);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] rolls = {6, 3, 4, 3, 5, 3};
        int mean = 1, n = 6;
        int[] ans = new Solution().missingRolls(rolls, mean, n);
        for (int x : ans) {
            System.out.print(x + ", ");
        }
    }
}
