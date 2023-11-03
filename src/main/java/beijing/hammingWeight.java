package beijing;
/*
https://leetcode.cn/problems/number-of-1-bits/
 */

// 这题比较简单
public class hammingWeight {
    static class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int count = 0;
            for (int i = 0; i < 32 && n != 0; i++) {
                if ((n & 1) == 1) {
                    count++;
                }
                n >>>= 1;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int n = -3;
        System.out.println(new Solution().hammingWeight(n));
    }
}
