package nowcoder;
/*
 牛客题霸-名企高频面试题
数字在升序数组中出现的次数 相似的企业真题
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：451596
本题知识点： 数组 二分
 算法知识视频讲解
题目描述
统计一个数字在升序数组中出现的次数。
题解 讨论 通过的代码笔记 纠错 收藏
 */

public class GetNumberOfK {
    static public class Solution {
        public int GetNumberOfK(int[] array, int k) {
            int count = 0;
            for (int x : array) {
                if (x == k) {
                    count++;
                } else {
                    if (count != 0) {
                        break;
                    }
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 4, 4, 4, 5, 6};
        int k = 4;
        System.out.println(new Solution().GetNumberOfK(nums, k));
    }
}
