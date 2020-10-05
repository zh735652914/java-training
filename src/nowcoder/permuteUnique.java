package nowcoder;
/*
 牛客题霸-名企高频面试题
有重复项数字的所有排列
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：12399
本题知识点： 回溯
 算法知识视频讲解
题目描述
给出一组可能包含重复项的数字，返回该组数字的所有排列
例如；
[1,1,2]的排列如下：
[1,1,2],[1,2,1], [2,1,1].
题解 讨论 通过的代码笔记 纠错 收藏
 */

import java.util.ArrayList;
import java.util.Arrays;

public class permuteUnique {
    static public class Solution {
        ArrayList<ArrayList<Integer>> ans;
        boolean[] visited;

        public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
            ans = new ArrayList<>();
            Arrays.sort(num);
            visited = new boolean[num.length];
            dfs(num, new ArrayList<>());
            return ans;
        }

        private void dfs(int[] nums, ArrayList<Integer> list) {
            if (list.size() == nums.length) {
                ans.add(list);
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) {
                    continue;
                }
                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                    continue;
                }
                list.add(nums[i]);
                visited[i] = true;
                dfs(nums, new ArrayList<>(list));
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(new Solution().permuteUnique(nums));
    }
}
