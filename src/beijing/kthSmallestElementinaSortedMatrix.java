package beijing;
/*
https://leetcode.cn/problems/kth-smallest-element-in-a-sorted-matrix/
 */

// 这题面试遇到就完犊子，但是这个二分真的很牛逼
public class kthSmallestElementinaSortedMatrix {
    static class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            int left = matrix[0][0];
            int right = matrix[matrix.length - 1][matrix[0].length - 1];
            while (left < right) {
                int mid = left + ((right - left) >> 1);
                if (check(matrix, mid, k)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        private boolean check(int[][] matrix, int mid, int k) {
            int count = 0;
            int x = matrix.length - 1, y = 0;
            while (x >= 0 && y < matrix[0].length) {
                if (mid >= matrix[x][y]) {
                    count += x + 1;
                    y++;
                } else {
                    x--;
                }
            }
            return count >= k;
        }
    }

    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 5, 9},
//                {10, 11, 13},
//                {12, 13, 15}
//        };
//        int k = 8;
        int[][] matrix = {
                {1, 2},
                {1, 3}
        };
        int k = 2;
        System.out.println(new Solution().kthSmallest(matrix, k));
    }
}
