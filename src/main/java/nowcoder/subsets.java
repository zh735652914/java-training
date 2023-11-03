package nowcoder;
/*
 牛客题霸-名企高频面试题
集合的所有子集 相似的企业真题
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：22425
本题知识点： 位运算 数组 回溯
 算法知识视频讲解
题目描述
现在有一个没有重复元素的整数集合S，求S的所有子集
注意：
你给出的子集中的元素必须按升序排列
给出的解集中不能出现重复的元素
例如：
如果S=[1,2,3], 给出的解集应为：
[
[3],
[1],
[2],
[1,2,3],
[1,3],
[2,3],
[1,2],
[]
]
题解 讨论 通过的代码笔记 纠错 收藏
 */

import java.util.ArrayList;
import java.util.Arrays;

public class subsets {
    static public class Solution {
        ArrayList<ArrayList<Integer>> ans;

        public ArrayList<ArrayList<Integer>> subsets(int[] S) {
            Arrays.sort(S);
            ans = new ArrayList<>();
            backtrack(S, 0, new ArrayList<>());
            ans.add(new ArrayList<>());
            return ans;
        }

        private void backtrack(int[] S, int index, ArrayList<Integer> list) {
            for (int i = index; i < S.length; i++) {
                list.add(S[i]);
                backtrack(S, i + 1, list);
                ans.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] S = {1, 2, 3};
        System.out.println(new Solution().subsets(S));
    }
}
