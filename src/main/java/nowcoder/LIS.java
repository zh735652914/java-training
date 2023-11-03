package nowcoder;
/*
时间限制：C/C++ 2秒，其他语言4秒 空间限制：C/C++ 256M，其他语言512M 热度指数：4655
本题知识点： 二分 动态规划
 算法知识视频讲解
题目描述
给定数组arr，设长度为n，输出arr的最长递增子序列。（如果有多个答案，请输出其中字典序最小的）
示例1
输入
复制
[2,1,5,3,6,4,8,9,7]
输出
复制
[1,3,4,8,9]
示例2
输入
复制
[1,2,8,6,4]
输出
复制
[1,2,4]
说明
其最长递增子序列有3个，（1，2，8）、（1，2，6）、（1，2，4）其中第三个字典序最小，故答案为（1，2，4）
备注:
n \leq 10^5n≤10
5

1 \leq arr_i \leq 10^91≤arr
i
​
 ≤10
9
 */


public class LIS {


    static public class Solution {
        /**
         * retrun the longest increasing subsequence
         *
         * @param arr int整型一维数组 the array
         * @return int整型一维数组
         */
        public int[] LIS(int[] arr) {
            int[] tmp = new int[arr.length];
            int[] beforeMin = new int[arr.length];
            int[] nums = new int[arr.length];
            tmp[0] = arr[0];
            beforeMin[0] = 1;
            int index = 0;
            int maxLen = 1;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > tmp[index]) {
                    tmp[++index] = arr[i];
                    beforeMin[i] = index + 1;
                } else {
                    for (int pos = 0; pos <= index; pos++) {
                        if (tmp[pos] >= arr[i]) {
                            tmp[pos] = arr[i];
                            beforeMin[i] = pos + 1;
                            break;
                        }
                    }
                }
                maxLen = Math.max(maxLen, beforeMin[i]);
            }


            int[] ans = new int[index + 1];
            for (int i = arr.length - 1; i >= 0; i--) {
                if (maxLen == 0) {
                    break;
                }
                if (beforeMin[i] == maxLen) {
                    ans[--maxLen] = arr[i];
                }
            }

            return ans;
        }

    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 3, 6, 4, 8, 9, 7};
//        int[] arr = {2};
        int[] ans = new Solution().LIS(arr);
        for (int x : ans) {
            System.out.print(x + ",");
        }
        System.out.println();
    }
}
