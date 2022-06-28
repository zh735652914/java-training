package Beijing.hot100;
/*
https://leetcode.cn/problems/hamming-distance/
 */

// 的确比较简单
public class hammingDistance_461 {
    static class Solution {
        public int hammingDistance(int x, int y) {
            x ^= y;
            int count = 0;
            while (x > 0) {
                if ((x & 1) == 1) {
                    count++;
                }
                x >>= 1;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int x = 1, y = 4;
        System.out.println(new Solution().hammingDistance(x, y));
    }
}
