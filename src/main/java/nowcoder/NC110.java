package nowcoder;
/*
 牛客题霸-名企高频面试题
旋转数组
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：691
本题知识点： 数组
 算法知识视频讲解
题目描述
一个数组A中存有N（N&gt0）个整数，在不允许使用另外数组的前提下，将每个整数循环向右移M（M>=0）个位置，
即将A中的数据由（A0 A1 ……AN-1 ）变换为（AN-M …… AN-1 A0 A1 ……AN-M-1 ）（最后M个数循环移至最前面的M个位置）。
如果需要考虑程序移动数据的次数尽量少，要如何设计移动的方法？
示例1
输入
复制
6,2,[1,2,3,4,5,6]
输出
复制
[5,6,1,2,3,4]
备注:
(1<=N<=100,M>=0)
 */

public class NC110 {
    static public class Solution {
        /**
         * 旋转数组
         *
         * @param n int整型 数组长度
         * @param m int整型 右移距离
         * @param a int整型一维数组 给定数组
         * @return int整型一维数组
         */
        public int[] solve(int n, int m, int[] a) {
            if (m == 0) {
                return a;
            }
            m %= n;
            reverse(a, 0, n - m - 1);
            reverse(a, n - m, n - 1);
            reverse(a, 0, n - 1);
            return a;
        }

        private void reverse(int[] a, int start, int end) {
            int tmp = 0;
            while (start < end) {
                tmp = a[end];
                a[end] = a[start];
                a[start] = tmp;
                start++;
                end--;
            }
        }
    }

    public static void main(String[] args) {
        int n = 100, m = 99;
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100};
//        int n = 6, m = 5;
//        int[] a = {1, 2, 3, 4, 5, 6};
        int[] ans = new Solution().solve(n, m, a);
        for (int x : ans) {
            System.out.print(x + ",");
        }
    }
}
