package Beijing;
/*
https://leetcode.cn/problems/kth-smallest-number-in-multiplication-table/
 */

import java.util.PriorityQueue;

public class kthSmallestNumberinMultiplicationTable {
    // 这个二分很重要！！自己不会写
    static class Solution {
        public int findKthNumber(int m, int n, int k) {
            int left = 1, right = m * n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                int count = mid / n * n;
                for (int i = mid / n + 1; i <= m; i++) {
                    count += mid / i;
                }
                if (count >= k) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }

    // 超出内存限制
    static class Solution0 {
        public int findKthNumber(int m, int n, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    queue.add(i * j);
                }
            }
            for (int i = 1; i < k; i++) {
                queue.poll();
            }
            return queue.poll();
        }
    }

    public static void main(String[] args) {
        int m = 3, n = 3, k = 5;
        System.out.println(new Solution().findKthNumber(m, n, k));
    }
}
