package beijing;
/*
https://leetcode.cn/problems/kth-smallest-element-in-a-sorted-matrix/
 */

/**
 * @author zhouhao
 * @date 2023/2/10 13:10
 */
// 自己还是不会写这个
public class KthSmallestElementinaSortedMatrix_378_topInterviewList {
    static class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            int left = matrix[0][0], right = matrix[matrix.length - 1][matrix[0].length - 1];
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
            int x = matrix.length - 1, y = 0;
            int count = 0;
            while (x >= 0 && y < matrix[0].length) {
                if (matrix[x][y] <= mid) {
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
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k = 8;
        System.out.println(new Solution().kthSmallest(matrix, k));
    }
}
