package beijing;
/*
https://leetcode.cn/problems/hamming-distance/
 */

public class hammingDistance {
    // 这题很简单
    static class Solution {
        public int hammingDistance(int x, int y) {
            int count = 0;
            while (x > 0 || y > 0) {
                if ((x & 1) != (y & 1)) {
                    count++;
                }
                x >>= 1;
                y >>= 1;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int x = 1, y = 4;
        System.out.println(new Solution().hammingDistance(x, y));
    }
}
