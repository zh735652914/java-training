package nowcoder;
/*
 牛客题霸-名企高频面试题
在两个长度相等的排序数组中找到上中位数
时间限制：C/C++ 2秒，其他语言4秒 空间限制：C/C++ 256M，其他语言512M 热度指数：2252
本题知识点： 数组 二分 分治
 算法知识视频讲解
题目描述
给定两个有序数组arr1和arr2，已知两个数组的长度都为N，求两个数组中所有数的上中位数。
上中位数：假设递增序列长度为n，若n为奇数，则上中位数为第n/2+1个数；否则为第n个数
[要求]
时间复杂度为O(logN)O(logN)，额外空间复杂度为O(1)O(1)
示例1
输入
复制
[1,2,3,4],[3,4,5,6]
输出
复制
3
说明
总共有8个数，上中位数是第4小的数，所以返回3。
示例2
输入
复制
[0,1,2],[3,4,5]
输出
复制
2
说明
总共有6个数，那么上中位数是第3小的数，所以返回2
备注:
1 \leq N \leq 10^51≤N≤10
5

0 \leq arr_{1i}, arr_{2i} \leq 10^90≤arr
1i
​
 ,arr
2i
​
 ≤10
9
 */

public class findMedianinTwoSortedAray {
    static public class Solution {
        /**
         * find median in two sorted array
         *
         * @param arr1 int整型一维数组 the array1
         * @param arr2 int整型一维数组 the array2
         * @return int整型
         */
        public int findMedianinTwoSortedAray(int[] arr1, int[] arr2) {
            int len1 = arr1.length, len2 = arr2.length;
            int pos = (len1 + len2) % 2 == 0 ? (len1 + len2) / 2 : (len1 + len2) / 2 + 1;
            int index1 = 0, index2 = 0;
            int count = 0, cur = 0;
            while (index1 < arr1.length && index2 < arr2.length) {
                if (arr1[index1] < arr2[index2]) {
                    cur = arr1[index1];
                    index1++;
                } else {
                    cur = arr2[index2];
                    index2++;
                }
                if (++count == pos) {
                    return cur;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {3, 4, 5, 6};
        System.out.println(new Solution().findMedianinTwoSortedAray(arr1, arr2));
    }
}
