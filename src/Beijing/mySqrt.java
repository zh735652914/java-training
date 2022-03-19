package Beijing;
/*
https://leetcode-cn.com/problems/sqrtx/
 */

public class mySqrt {
    // 重要！自己不会
    static class Solution {
        public int mySqrt(int x) {
            int left = 0, right = x, ans = 0;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if ((long) mid * mid <= x) {
                    ans = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int x = 2147395600;
        System.out.println(new Solution().mySqrt(x));
    }
}
