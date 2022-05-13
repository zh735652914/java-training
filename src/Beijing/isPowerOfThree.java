package Beijing;
/*
https://leetcode.cn/problems/power-of-three/
 */

// 错了三次我是没想到的
public class isPowerOfThree {
    static class Solution {
        public boolean isPowerOfThree(int n) {
            if (n <= 0) {
                return false;
            }
            while (n > 1) {
                if (n % 3 != 0) {
                    return false;
                }
                n /= 3;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int n = 27;
        System.out.println(new Solution().isPowerOfThree(n));
    }
}
