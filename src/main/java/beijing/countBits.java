package beijing;
/*
https://leetcode.cn/problems/counting-bits/
 */

// 自己没写出来，但是解法很巧妙
public class countBits {
    // x&(x-1) 去掉x最右边的1
    static class Solution0 {
        public int[] countBits(int n) {
            int[] ans = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                ans[i] = ans[i & (i - 1)] + 1;
            }
            return ans;
        }
    }

    // 保存比x中的1小一个的和
    static class Solution {
        public int[] countBits(int n) {
            int[] ans = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                ans[i] = ans[i >> 1] + (i & 1);
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
