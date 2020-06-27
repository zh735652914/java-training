package LeetCode.ProgrammerInterview;
/*
面试题 08.04. 幂集
幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。

说明：解集不能包含重复的子集。

示例:

 输入： nums = [1,2,3]
 输出：
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
通过次数4,780提交次数6,001
 */

import java.util.ArrayList;
import java.util.List;

//这题自己没写出来，写过的题目。。。
public class subsets {
    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> subset = new ArrayList<>();
            backtrack(nums, 0, ans, subset);
            return ans;
        }

        private void backtrack(int[] nums, int pos, List<List<Integer>> ans, List<Integer> subset) {
            ans.add(new ArrayList<>(subset));
            for (int i = pos; i < nums.length; i++) {
                subset.add(nums[i]);
                backtrack(nums, i + 1, ans, subset);
                subset.remove(subset.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Solution().subsets(nums));
    }
}
