package beijing;
/*
https://leetcode.cn/problems/power-of-three/
 */

/**
 * @author zhouhao
 * @date 2023/1/5 12:34
 */
public class PowerofThree_326_topInterviewList {
    // 这特例有点多啊
    static class Solution {
        public boolean isPowerOfThree(int n) {
            if (n <= 0 || n == 2) {
                return false;
            }
            if (n == 1) {
                return true;
            }
            while (n > 1) {
                int res = n / 3;
                if (res * 3 != n) {
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
