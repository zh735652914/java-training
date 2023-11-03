package beijing;
/*
https://leetcode.cn/problems/power-of-two/
 */

// 边界条件考虑到就行
public class powerofTwo_231 {
    static class Solution {
        public boolean isPowerOfTwo(int n) {
            if (n < 1) {
                return false;
            }
            while (n > 1) {
                if ((n & 1) == 1) {
                    return false;
                }
                n >>= 1;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int n = -16;
        System.out.println(new Solution().isPowerOfTwo(n));
    }
}
