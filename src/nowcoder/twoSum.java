package nowcoder;
/*
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：54075
本题知识点： 数组 哈希
 算法知识视频讲解
题目描述
给出一个整数数组，请在数组中找出两个加起来等于目标值的数，
你给出的函数twoSum 需要返回这两个数字的下标（index1，index2），需要满足 index1 小于index2.。注意：下标是从1开始的
假设给出的数组中只存在唯一解
例如：
给出的数组为 {2, 7, 11, 15},目标值为9
输出 index1=1, index2=2


示例1
输入
复制
[3,2,4],6
输出
复制
[2,3]
 */

import java.util.HashMap;
import java.util.Map;

public class twoSum {
    static public class Solution {
        /**
         * @param numbers int整型一维数组
         * @param target  int整型
         * @return int整型一维数组
         */
        public int[] twoSum(int[] numbers, int target) {
            Map<Integer, Integer> map = new HashMap<>(numbers.length);
            int[] ans = new int[2];
            for (int i = 0; i < numbers.length; i++) {
                if (map.containsKey(numbers[i])) {
                    ans[1] = i + 1;
                    ans[0] = map.get(numbers[i]) + 1;
                } else {
                    map.put(target - numbers[i], i);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] ans = new Solution().twoSum(nums, target);
        for (int x : ans) {
            System.out.print(x + ",");
        }
        System.out.println();
    }
}
