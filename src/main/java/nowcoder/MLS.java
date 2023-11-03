package nowcoder;
/*
 牛客题霸-名企高频面试题
数组中的最长连续子序列
时间限制：C/C++ 2秒，其他语言4秒 空间限制：C/C++ 256M，其他语言512M 热度指数：2102
本题知识点： 并查集 数组
 算法知识视频讲解
题目描述
给定无序数组arr，返回其中最长的连续序列的长度(要求值连续，位置可以不连续,例如 3,4,5,6为连续的自然数）
示例1
输入
复制
[100,4,200,1,3,2]
输出
复制
4
示例2
输入
复制
[1,1,1]
输出
复制
1
备注:
1 \leq n \leq 10^51≤n≤10
5

1 \leq arr_i \leq 10^81≤arr
i
​
 ≤10
8
 */

import java.util.Arrays;

public class MLS {
    static public class Solution {
        /**
         * max increasing subsequence
         *
         * @param arr int整型一维数组 the array
         * @return int整型
         */
        public int MLS(int[] arr) {
            if (arr == null || arr.length == 0) {
                return 0;
            }
            Arrays.sort(arr);
            int ans = 0;
            int count = 1;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] + 1 == arr[i + 1]) {
                    count++;
                } else if (arr[i] == arr[i + 1]) {
                    continue;
                } else {
                    count = 1;
                }
                ans = Math.max(count, ans);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(new Solution().MLS(nums));
    }
}
