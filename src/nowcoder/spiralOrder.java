package nowcoder;
/*
 牛客题霸-名企高频面试题
螺旋矩阵 相似的企业真题
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：12799
本题知识点： 数组
 算法知识视频讲解
题目描述
给定一个m x n大小的矩阵（m行，n列），按螺旋的顺序返回矩阵中的所有元素。
例如，
给出以下矩阵：
[
    [ 1, 2, 3 ],
    [ 4, 5, 6 ],
    [ 7, 8, 9 ]
]
你应该返回[1,2,3,6,9,8,7,4,5]。
题解 讨论 通过的代码笔记 纠错 收藏
 */

import java.util.ArrayList;

public class spiralOrder {
    static public class Solution {
        public ArrayList<Integer> spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return new ArrayList<>();
            }
            int r_begin = 0, r_end = matrix.length - 1;
            int c_begin = 0, c_end = matrix[0].length - 1;
            ArrayList<Integer> ans = new ArrayList<>();
            int x = 0, y = 0;
            while (r_begin <= r_end && c_begin <= c_end) {
                for (y = c_begin; y <= c_end; y++) {
                    ans.add(matrix[x][y]);
                }
                y--;
                r_begin++;
                if (r_begin > r_end) {
                    break;
                }
                for (x = r_begin; x <= r_end; x++) {
                    ans.add(matrix[x][y]);
                }
                c_end--;
                x--;
                if (c_begin > c_end) {
                    break;
                }
                for (y = c_end; y >= c_begin; y--) {
                    ans.add(matrix[x][y]);
                }
                r_end--;
                y++;
                if (c_begin > c_end) {
                    break;
                }
                for (x = r_end; x >= r_begin; x--) {
                    ans.add(matrix[x][y]);
                }
                c_begin++;
                x++;
                if (r_begin > r_end) {
                    break;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {2, 5},
                {8, 4},
                {0, -1}
        };
        System.out.println(new Solution().spiralOrder(matrix));
    }
}
