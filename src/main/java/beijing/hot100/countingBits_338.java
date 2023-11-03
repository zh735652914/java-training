package beijing.hot100;
/*
https://leetcode.cn/problems/counting-bits/
 */

public class countingBits_338 {
    // 这题有点意思，看了提示才会
    static class Solution {
        public int[] countBits(int n) {
            if (n == 0) {
                return new int[]{0};
            }
            if (n == 1) {
                return new int[]{0, 1};
            }
            int[] ans = new int[n + 1];
            ans[1] = 1;
            for (int i = 2; i <= n; i++) {
                if ((i & 1) == 1) {
                    ans[i] = ans[i >> 1] + 1;
                } else {
                    ans[i] = ans[i >> 1];
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[] ans = new Solution().countBits(n);
        for (int x : ans) {
            System.out.print(x + ", ");
        }
    }
}
