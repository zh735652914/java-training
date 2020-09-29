package nowcoder;
/*
 牛客题霸-名企高频面试题
子数组最大乘积
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：4571
本题知识点： 数组 动态规划
 算法知识视频讲解
题目描述
给定一个double类型的数组arr，其中的元素可正可负可0，返回子数组累乘的最大乘积。
例如arr=[-2.5，4，0，3，0.5，8，-1]，子数组[3，0.5，8]累乘可以获得最大的乘积12，所以返回12。
 */

public class maxProduct {
    static public class Solution {
        public double maxProduct(double[] arr) {
            double curMax = arr[0];
            double curMin = arr[0];
            double max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                double perMax = curMax;
                curMax = Math.max(Math.max(arr[i] * perMax, arr[i] * curMin), arr[i]);
                curMin = Math.min(Math.min(arr[i] * perMax, arr[i] * curMin), arr[i]);
                max = Math.max(curMax, max);
            }
            return max;
        }

        public static void main(String[] args) {
            double[] arr = {0.1, 0.0, 3.0, -2.0, 0.9, -1.3, 5.0, -4.4};
            System.out.println(new Solution().maxProduct(arr));
        }
    }
}
