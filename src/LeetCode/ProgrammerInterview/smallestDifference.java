package LeetCode.ProgrammerInterview;
/*
面试题 16.06. 最小差
给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差

示例：

输入：{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
输出： 3，即数值对(11, 8)
提示：

1 <= a.length, b.length <= 100000
-2147483648 <= a[i], b[i] <= 2147483647
正确结果在区间[-2147483648, 2147483647]内
通过次数4,259提交次数10,462
 */

import java.util.Arrays;

//又是自己不会写。。。。
public class smallestDifference {
    static class Solution {
        public int smallestDifference(int[] a, int[] b) {
            Arrays.sort(a);
            Arrays.sort(b);
            int x = 0, y = 0;
            int ans = Integer.MAX_VALUE;
            while (x < a.length && y < b.length) {
                long diff = a[x] - b[y];
                ans = (int) Math.min(Math.abs(diff), ans);
                if (diff < 0) {
                    x++;
                } else {
                    y++;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 15, 11, 2};
        int[] b = {23, 127, 235, 19, 8};
        System.out.println(new Solution().smallestDifference(a, b));
    }
}
