package nowcoder;
/*
 牛客题霸-名企高频面试题
未排序数组中累加和为给定值的最长子数组长度
时间限制：C/C++ 2秒，其他语言4秒 空间限制：C/C++ 256M，其他语言512M 热度指数：172
本题知识点： 哈希
 算法知识视频讲解
题目描述
给定一个无序数组arr, 其中元素可正、可负、可0。给定一个整数k，求arr所有子数组中累加和为k的最长子数组长度
示例1
输入
复制
[1,-2,1,1,1],0
输出
复制
3
备注:
\begin{array}{l}1 \leqslant N \leqslant 10^{5} \\ -10^{9} \leqslant k \leqslant 10^{9} \\ -100
\leqslant a r r_{i} \leqslant 100\end{array}
1⩽N⩽10
5

−10
9
 ⩽k⩽10
9

−100⩽arr
i
​
 ⩽100
​
 */

import java.util.HashMap;
import java.util.Map;

public class maxlenEqualK {
    static public class Solution {
        /**
         * max length of the subarray sum = k
         *
         * @param arr int整型一维数组 the array
         * @param k   int整型 target
         * @return int整型
         */
        public int maxlenEqualK(int[] arr, int k) {
            int ans = 0;
            Map<Integer, Integer> map = new HashMap<>();
            int sum = 0;
            map.put(0, -1);
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
                if (!map.containsKey(sum)) {
                    map.put(sum, i);
                }
                if (map.containsKey(sum - k) && (i - map.get(sum - k) > ans)) {
                    ans = i - map.get(sum - k);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, -2, 1, 1, 1};
        int k = 0;
        System.out.println(new Solution().maxlenEqualK(nums, k));
    }
}
