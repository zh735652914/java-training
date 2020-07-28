package LeetCode.ProgrammerInterview;
/*
面试题 10.01. 合并排序的数组
给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。

初始化 A 和 B 的元素数量分别为 m 和 n。

示例:

输入:
A = [1,2,3,0,0,0], m = 3
B = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]
说明:

A.length == n + m
通过次数28,819提交次数53,245
 */

//自己傻逼了，太久没写题，这么简单都不会了。。。
public class MergeNums {
    static class Solution {
        public void merge(int[] A, int m, int[] B, int n) {
            int k = m + n - 1;
            int p = m - 1, q = n - 1;
            while (p >= 0 && q >= 0) {
                if (A[p] >= B[q]) {
                    A[k--] = A[p--];
                } else {
                    A[k--] = B[q--];
                }
            }
            while (q >= 0) {
                A[k--] = B[q--];
            }
            OUTPUT(A);
        }

        private void OUTPUT(int[] ans) {
            for (int x : ans) {
                System.out.print(x + ",");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 0, 0, 0};
        int[] B = {2, 5, 6};
        int m = 3, n = 3;
        new Solution().merge(A, m, B, n);
    }
}
