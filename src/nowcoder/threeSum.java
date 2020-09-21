package nowcoder;
/*
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：32653
本题知识点： 数组 双指针
 算法知识视频讲解
题目描述
给出一个有n个元素的数组S，S中是否有元素a,b,c满足a+b+c=0？找出数组S中所有满足条件的三元组。
注意：
三元组（a、b、c）中的元素必须按非降序排列。（即a≤b≤c）
解集中不能包含重复的三元组。
例如，给定的数组 S = {-1 0 1 2 -1 -4},解集为(-1, 0, 1) (-1, -1, 2)
 */

import java.util.ArrayList;
import java.util.Arrays;

public class threeSum {
    static public class Solution {
        public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
            Arrays.sort(num);
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < num.length - 2; i++) {
                if (i > 0 && num[i] == num[i - 1]) {
                    continue;
                }
                int start = i + 1, end = num.length - 1;
                while (start < end) {
                    if (start > i + 1 && num[start] == num[start - 1]) {
                        start++;
                        continue;
                    }
                    if (end < num.length - 1 && num[end] == num[end + 1]) {
                        end--;
                        continue;
                    }
                    int sum = num[start] + num[end];
                    if (sum == -num[i]) {
                        ArrayList<Integer> list = new ArrayList<>(3);
                        list.add(num[i]);
                        list.add(num[start]);
                        list.add(num[end]);
                        ans.add(list);
                        start++;
                    } else if (sum > -num[i]) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0};
        System.out.println(new Solution().threeSum(nums));
    }
}
