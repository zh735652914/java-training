package nowcoder;
/*
 牛客题霸-名企高频面试题
滑动窗口的最大值 相似的企业真题
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：404784
本题知识点： 堆 双指针
 算法知识视频讲解
题目描述
给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
{[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
窗口大于数组长度的时候，返回空
题解 讨论 通过的代码笔记 纠错 收藏
 */

import java.util.ArrayList;

public class maxInWindows {
    static public class Solution {
        public ArrayList<Integer> maxInWindows(int[] num, int size) {
            ArrayList<Integer> ans = new ArrayList<>();
            if (num.length == 0 || size == 0 || num.length < size) {
                return ans;
            }
            int pos = findMax(num, size, size - 1);
            ans.add(num[pos]);
            for (int i = size; i < num.length; i++) {
                if (num[i] >= num[pos]) {
                    pos = i;
                    ans.add(num[i]);
                } else if (pos > i - size) {
                    ans.add(num[pos]);
                } else {
                    pos = findMax(num, size, i);
                    ans.add(num[pos]);
                }
            }
            return ans;
        }

        private int findMax(int[] num, int size, int end) {
            int pos = end - size + 1;
            for (int i = pos; i <= end && i < num.length; i++) {
                if (num[i] > num[pos]) {
                    pos = i;
                }
            }
            return pos;
        }
    }

    public static void main(String[] args) {
        int[] nums = {10, 14, 12, 11};
        int size = 5;
        System.out.println(new Solution().maxInWindows(nums, size));
    }
}
