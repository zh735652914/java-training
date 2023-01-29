package beijing;
/*
https://leetcode.cn/problems/sqrtx/
 */

public class sqrt_69_topInterviewList {
    // 自己还是不会写
    static class Solution {
        public int mySqrt(int x) {
            int left = 0, right = x;
            int ans = 0;
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
        int x = 4;
        System.out.println(new Solution().mySqrt(x));
    }
}
