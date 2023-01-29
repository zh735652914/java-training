package beijing;
/*
https://leetcode.cn/problems/reverse-bits/
 */

// 自己没写出来，需要看看
public class reverseBits {
    static class Solution {
        // you need treat n as an unsigned value
        public int reverseBits1(int n) {
            return Integer.reverse(n);
        }

        public int reverseBits(int n) {
            int ans = 0;
            for (int i = 0; i < 32 && n != 0; i++) {
                ans |= (n & 1) << (31 - i);
                n >>>= 1;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int n = 322122;
        System.out.println(new Solution().reverseBits(n));
    }
}
