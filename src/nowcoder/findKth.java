package nowcoder;
/*
 牛客题霸-名企高频面试题
寻找第K大
时间限制：C/C++ 3秒，其他语言6秒 空间限制：C/C++ 32M，其他语言64M 热度指数：45412
本题知识点： 堆 分治
 算法知识视频讲解
题目描述
有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。

给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。

测试样例：
[1,3,5,2,2],5,3
返回：2
 */

public class findKth {
    static public class Finder {
        public int findKth(int[] a, int n, int K) {
            return FindK(a, 0, n - 1, K);
        }

        private int FindK(int[] a, int start, int end, int K) {
            int pos = partition(a, start, end);
            if (pos == K - 1) {
                return a[pos];
            } else if (pos > K - 1) {
                return FindK(a, start, pos - 1, K);
            } else {
                return FindK(a, pos + 1, end, K);
            }
        }

        private int partition(int[] a, int start, int end) {
            int x = a[start];
            while (start < end) {
                while (start < end && a[end] <= x) {
                    end--;
                }
                a[start] = a[end];
                while (start < end && a[start] >= x) {
                    start++;
                }
                a[end] = a[start];
            }
            a[start] = x;
            return start;
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 2, 2};
        int n = 5;
        int k = 2;
        System.out.println((new Finder().findKth(nums, n, k)));
    }
}
