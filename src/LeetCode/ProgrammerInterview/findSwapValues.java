package LeetCode.ProgrammerInterview;
/*
面试题 16.21. 交换和
给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。

返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。
若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。

示例:

输入: array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
输出: [1, 3]
示例:

输入: array1 = [1, 2, 3], array2 = [4, 5, 6]
输出: []
提示：

1 <= array1.length, array2.length <= 100000
通过次数3,347提交次数7,557
 */

import java.util.HashMap;
import java.util.Map;

//这么久了终于有一道题是自己写出来的。。。。
public class findSwapValues {
    static class Solution {
        public int[] findSwapValues(int[] array1, int[] array2) {
            long sum1 = 0, sum2 = 0;
            Map<Integer, Boolean> map = new HashMap<>(array2.length);
            for (int x : array1) {
                sum1 += x;
            }
            for (int x : array2) {
                sum2 += x;
                map.put(x, true);
            }
            int diff = (int) Math.abs(sum1 - sum2);
            if (diff % 2 == 1) {
                return new int[]{};
            }
            int gap = diff / 2;
            for (int x : array1) {
                if (map.containsKey(x + gap)) {
                    return new int[]{x, x + gap};
                }
                if (map.containsKey(x - gap)) {
                    return new int[]{x, x - gap};
                }
            }
            return new int[]{};
        }
    }

    public static void main(String[] args) {
        int[] array1 = {4, 1, 2, 1, 1, 2};
        int[] array2 = {3, 6, 3, 3};
        int[] ans = new Solution().findSwapValues(array1, array2);
        for (int x : ans) {
            System.out.print(x + ",");
        }
        System.out.println();
    }
}
