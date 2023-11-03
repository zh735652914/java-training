package nowcoder;
/*
 牛客题霸-名企高频面试题
矩阵元素查找 相似的企业真题
时间限制：C/C++ 3秒，其他语言6秒 空间限制：C/C++ 32M，其他语言64M 热度指数：6020
本题知识点： 二分 分治
 算法知识视频讲解
题目描述
已知int一个有序矩阵mat，同时给定矩阵的大小n和m以及需要查找的元素x，且矩阵的行和列都是从小到大有序的。
设计查找算法返回所查找元素的二元数组，代表该元素的行号和列号(均从零开始)。保证元素互异。

测试样例：
[[1,2,3],[4,5,6]],2,3,6
返回：[1,2]
题解 讨论 通过的代码笔记 纠错 收藏
 */

public class findElement {
    static public class Finder0 {
        public int[] findElement(int[][] mat, int n, int m, int target) {
            int[] ans = new int[2];
            int x = 0, y = 0;
            while (x < n && y < m) {
                if (mat[x][y] == target) {
                    ans[0] = x;
                    ans[1] = y;
                    return ans;
                }
                if (x + 1 < n && mat[x + 1][y] <= target && y + 1 < m && mat[x][y + 1] <= target) {
                    if (mat[x + 1][y] > mat[x][y + 1]) {
                        x++;
                    } else {
                        y++;
                    }
                } else if (x + 1 >= n || mat[x + 1][y] > target) {
                    y++;
                } else {
                    x++;
                }
            }
            return ans;
        }
    }

    static public class Finder {
        public int[] findElement(int[][] mat, int n, int m, int target) {
            int x = 0, y = m - 1;
            int[] ans = new int[2];
            while (x < n && y >= 0) {
                if (target == mat[x][y]) {
                    ans[0] = x;
                    ans[1] = y;
                    return ans;
                }
                if (mat[x][y] > target) {
                    y--;
                } else {
                    x++;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}};
        int x = 6;
        int[] ans = new Finder().findElement(mat, mat.length, mat[0].length, x);
        for (int i : ans) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
