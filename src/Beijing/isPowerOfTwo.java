package Beijing;
/*
https://leetcode.cn/problems/power-of-two/
 */

// 昨天没考虑到负数，今天还是没考虑到
public class isPowerOfTwo {
    static class Solution {
        public boolean isPowerOfTwo(int n) {
            if (n == 1) {
                return true;
            }
            if (n <= 0) {
                return false;
            }
            while (n > 1) {
                if (n % 2 != 0) {
                    return false;
                }
                n >>= 1;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int n = 16;
        System.out.println(new Solution().isPowerOfTwo(n));
    }
}
