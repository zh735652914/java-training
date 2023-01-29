package beijing;
/*
https://leetcode.cn/problems/reverse-bits/
 */

public class ReverseBits_190_topInterviewList {
    // 的确很简单
    static public class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int ans = 0;
            int count = 32;
            while (count-- > 0) {
                ans <<= 1;
                ans += n & 1;
                n >>= 1;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int n = 43261596;
        System.out.println(new Solution().reverseBits(n));
    }
}
