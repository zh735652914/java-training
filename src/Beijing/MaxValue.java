package Beijing;
/*
https://leetcode.cn/problems/maximum-value-at-a-given-index-in-a-bounded-array/
 */

/**
 * @author zhouhao
 * @date 2023/1/4 12:36
 */
public class MaxValue {
    // 这个二分很厉害
    static class Solution {
        public int maxValue(int n, int index, int maxSum) {
            int left = 1, right = maxSum;
            while (left < right) {
                /*
                避免死循环，这是二分的其中一个模板:
                如果遇到 right=mid-1，那么 mid 就是 (left + right + 1) >> 1；
                如果 right = mid，那么 mid 就是 (left + right) >> 1。
                 */
                int mid = (right + left + 1) / 2;
                if (sum(mid - 1, index) + sum(mid, n - index) <= maxSum) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }

        private long sum(long x, int cnt) {
            return x >= cnt ? (x + x - cnt + 1) * cnt / 2 : (x + 1) * x / 2 + cnt - x;
        }
    }

    public static void main(String[] args) {
        int n = 4, index = 2, maxSum = 6;
        System.out.println(new Solution().maxValue(n, index, maxSum));
    }
}
