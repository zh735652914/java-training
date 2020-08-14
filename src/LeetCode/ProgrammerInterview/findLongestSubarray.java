package LeetCode.ProgrammerInterview;
/*
面试题 17.05.  字母与数字
给定一个放有字符和数字的数组，找到最长的子数组，且包含的字符和数字的个数相同。

返回该子数组，若存在多个最长子数组，返回左端点最小的。若不存在这样的数组，返回一个空数组。

示例 1:

输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"]

输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
示例 2:

输入: ["A","A"]

输出: []
提示：

array.length <= 100000
通过次数2,017提交次数5,552
 */

import java.util.Arrays;

//不会写，连解答都看不懂。。
public class findLongestSubarray {
    static class Solution {
        public String[] findLongestSubarray(String[] array) {
            int len = array.length;
            int[] memo = new int[(len << 1) + 1];
            Arrays.fill(memo, -2);
            memo[len] = -1;
            int res = 0, count = 0, begin = 0, end = 0;
            for (int i = 0; i < len; ++i) {
                boolean is_num = true;
                for (char c : array[i].toCharArray()) {
                    if (c < '0' || c > '9') {
                        is_num = false;
                        break;
                    }
                }
                count += is_num ? -1 : 1;
                //未曾见过该前缀和(即memo数组中没有记录)
                if (memo[count + len] <= -2) {
                    memo[count + len] = i;  //记录该前缀和的下标
                }//曾见过该前缀和(即memo数组中已有记录)
                else if (i - memo[count + len] > res) {
                    begin = memo[count + len] + 1;
                    end = i + 1;
                    res = i - memo[count + len];
                }
            }
            return Arrays.copyOfRange(array, begin, end);
        }
    }

    public static void main(String[] args) {
        String[] arry = {"A", "1", "B", "C", "D", "2", "3", "4", "E", "5", "F", "G", "6", "7", "H", "I", "J", "K", "L", "M"};
        String[] ans = new Solution().findLongestSubarray(arry);
        for (String x : ans) {
            System.out.print(x + ",");
        }
        System.out.println();
    }
}
