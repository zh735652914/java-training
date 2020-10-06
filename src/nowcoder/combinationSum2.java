package nowcoder;
/*
 牛客题霸-名企高频面试题
加起来和为目标值的组合 相似的企业真题
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：11847
本题知识点： 数组 回溯
 算法知识视频讲解
题目描述
给出一组候选数\ C C 和一个目标数\ T T，找出候选数中起来和等于\ T T 的所有组合。
\ C C 中的每个数字在一个组合中只能使用一次。
注意：
题目中所有的数字（包括目标数\ T T ）都是正整数
组合中的数字 (a_1, a_2, … , a_ka
1
​
 ,a
2
​
 ,…,a
k
​
 ) 要按非递增排序 (a_1 \leq a_2 \leq … \leq a_ka
1
​
 ≤a
2
​
 ≤…≤a
k
​
 ).
结果中不能包含重复的组合
例如：给定的候选数集是[100,10,20,70,60,10,50]，目标数是80
解集是：
[10, 70]
[10, 20, 50]
[20, 60]
[10, 10, 60]
题解 讨论 通过的代码笔记 纠错 收藏
 */

import java.util.ArrayList;
import java.util.Arrays;

public class combinationSum2 {
    static public class Solution {
        ArrayList<ArrayList<Integer>> ans;
        boolean[] visited;

        public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
            ans = new ArrayList<>();
            Arrays.sort(num);
            visited = new boolean[num.length];
            dfs(num, target, new ArrayList<>(), 0, 0);
            return ans;
        }

        private void dfs(int[] nums, int target, ArrayList<Integer> list, int index, int sum) {
            if (sum == target) {
//                if (!ans.contains(list)) {
//                    ans.add(list);
//                }
                ans.add(list);
                return;
            }
            for (int i = index; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1] || visited[i]) {
                    continue;
                }
                if (nums[i] + sum > target) {
                    return;
                }
                list.add(nums[i]);
                visited[i] = true;
                dfs(nums, target, new ArrayList<>(list), i + 1, sum + nums[i]);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 5, 1, 1};
        int target = 8;
        System.out.println(new Solution().combinationSum2(nums, target));
    }
}
