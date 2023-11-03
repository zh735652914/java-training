package beijing;
/*
https://leetcode-cn.com/problems/factorial-trailing-zeroes/
 */

public class trailingZeroes {
    // 官方的解答，这个感觉要背下来
    static class Solution {
        public int trailingZeroes(int n) {
            int ans = 0;
            while (n > 0) {
                n /= 5;
                ans += n;
            }
            return ans;
        }
    }

    // 自己写的效率不高
    static class Solution0 {
        public int trailingZeroes(int n) {
            int TenCount = 0;
            int TwoCount = 0;
            int FiveCount = 0;
            for (int i = 1; i <= n; i++) {
                int x = i;
//                // 10 不用计算
//                while (x != 0 && x % 10 == 0) {
//                    x /= 10;
//                    TenCount++;
//                }
                while (x != 0 && x % 2 == 0) {
                    x /= 2;
                    TwoCount++;
                }
                while (x != 0 && x % 5 == 0) {
                    x /= 5;
                    FiveCount++;
                }
            }
            return TenCount + Math.min(TwoCount, FiveCount);
        }
    }

    public static void main(String[] args) {
        int n = 15;
        System.out.println(new Solution().trailingZeroes(n));
    }
}
