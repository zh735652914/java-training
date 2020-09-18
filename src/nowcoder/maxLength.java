package nowcoder;
/*
题目描述
给定一个数组arr，返回arr的最长无的重复子串的长度(无重复指的是所有数字都不相同)。
示例1
输入
复制
[2,3,4,5]
输出
复制
4
示例2
输入
复制
[2,2,3,4,3]
输出
复制
3
备注:
1 \leq n \leq 10^51≤n≤10
5
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class maxLength {
    public static class Solution {
        /**
         * @param arr int整型一维数组 the array
         * @return int整型
         */
        public int maxLength(int[] arr) {
            int maxLen = 0;
            int start = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                if (map.containsKey(arr[i])) {
                    start = Math.max(start, map.get(arr[i]) + 1);
                }
                maxLen = Math.max(maxLen, i - start + 1);
                map.put(arr[i], i);
            }
            return maxLen;
        }

        public static void main(String[] args) {
            int[] arr = {2, 2, 3, 4, 3};
            System.out.println(new Solution().maxLength(arr));
        }
    }
}