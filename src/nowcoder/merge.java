package nowcoder;
/*
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：23635
本题知识点： 数组 双指针
 算法知识视频讲解
题目描述
给出两个有序的整数数组 和 ，请将数组 合并到数组 中，变成一个有序的数组
注意：
可以假设 数组有足够的空间存放 数组的元素， 和 中初始的元素数目分别为 和
 */

public class merge {
    static public class Solution {
        public void merge(int[] A, int m, int[] B, int n) {
            int index = A.length - 1;
            int a, b;
            while (index >= 0) {
                a = Integer.MIN_VALUE;
                b = Integer.MIN_VALUE;
                if (m > 0) {
                    a = A[m - 1];
                }
                if (n > 0) {
                    b = B[n - 1];
                }

                if (a >= b) {
                    A[index] = a;
                    m--;
                } else {
                    A[index] = b;
                    n--;
                }
                index--;
            }


            OUTPUT(A);
        }

        private void OUTPUT(int[] nums) {
            for (int num : nums) {
                System.out.print(num + ",");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int m = 4;
        int n = 2;
        int[] A = {1, 3, 5, 6, 0, 0};
        int[] B = {2, 4};
        new Solution().merge(A, m, B, n);
    }
}
