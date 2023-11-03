package nowcoder;
/*
 牛客题霸-名企高频面试题
没有重复项数字的所有排列
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：12530
本题知识点： 回溯
 算法知识视频讲解
题目描述
给出一组数字，返回该组数字的所有排列
例如：
[1,2,3]的所有排列如下
[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2], [3,2,1].
（以数字在数组中的位置靠前为优先级，按字典序排列输出。）
 */

import java.util.ArrayList;
import java.util.Arrays;

public class permute {
    static public class Solution {
        ArrayList<ArrayList<Integer>> ans;

        public ArrayList<ArrayList<Integer>> permute(int[] num) {
            Arrays.sort(num);
            ans = new ArrayList<>();
            boolean[] visited = new boolean[num.length];
            for (int i = 0; i < num.length; i++) {
                backtrack(num, i, new ArrayList<>(), visited);
            }
            return ans;
        }

        private void backtrack(int[] nums, int index, ArrayList<Integer> list, boolean[] visited) {
            list.add(nums[index]);
            visited[index] = true;
            if (list.size() >= nums.length) {
                ans.add(list);
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) {
                    continue;
                }
                backtrack(nums, i, new ArrayList<>(list), visited);
//                visited[i] = false;
            }
            visited[index] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Solution().permute(nums));
    }
}
