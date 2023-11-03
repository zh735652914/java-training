package nowcoder;
/*
 牛客题霸-名企高频面试题
数组中未出现的最小正整数
时间限制：C/C++ 2秒，其他语言4秒 空间限制：C/C++ 256M，其他语言512M 热度指数：2558
本题知识点： 数组
 算法知识视频讲解
题目描述
给定一个无序数组arr，找到数组中未出现的最小正整数
例如arr = [-1, 2, 3, 4]。返回1
arr = [1, 2, 3, 4]。返回5
[要求]
时间复杂度为O(n)O(n)，空间复杂度为O(1)O(1)

示例1
输入
复制
[-1,2,3,4]
输出
复制
1
备注:
1 \leq N \leq 10^61≤N≤10
6

|arr_i| \leq 10^9∣arr
i
​
 ∣≤10
9
 */

public class minNumberdisappered {
    static public class Solution {
        /**
         * return the min number
         *
         * @param arr int整型一维数组 the array
         * @return int整型
         */
        public int minNumberdisappered(int[] arr) {
            if (arr == null) {
                return 1;
            }
            for (int i = 0; i < arr.length; i++) {
                while (arr[i] > 0 && arr[i] <= arr.length && arr[arr[i] - 1] != arr[i]) {
                    swap(arr, i, arr[i] - 1);
                }
            }
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != i + 1) {
                    return i + 1;
                }
            }
            return arr.length + 1;
        }

        private void swap(int[] arr, int x, int y) {
            int tmp = arr[x];
            arr[x] = arr[y];
            arr[y] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(new Solution().minNumberdisappered(nums));
    }
}
