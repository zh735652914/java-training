package nowcoder;
/*
 牛客题霸-名企高频面试题
缺失数字
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：1621
本题知识点： 位运算 数组 数学
 算法知识视频讲解
题目描述
从0,1,2,...,n这n+1个数中选择n个数，找出这n个数中缺失的那个数，要求O(n)尽可能小。
示例1
输入
复制
[0,1,2,3,4,5,7]
输出
复制
6
 */

public class NC101 {
    static public class Solution {
        /**
         * 找缺失数字
         *
         * @param a int整型一维数组 给定的数字串
         * @return int整型
         */
        public int solve(int[] a) {
            int ans = a.length;
            for (int i = 0; i < a.length; i++) {
                ans ^= a[i] ^ i;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 7};
        System.out.println(new Solution().solve(nums));
    }
}
