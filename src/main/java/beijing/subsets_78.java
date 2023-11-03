package beijing;
/*
https://leetcode.cn/problems/subsets/
 */

import java.util.ArrayList;
import java.util.List;

public class subsets_78 {
    // 评论中的写法，比自己想的好
    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>());
            for (int num : nums) {
                List<List<Integer>> addSubs = new ArrayList<>();
                for (List<Integer> sub : ans) {
                    List<Integer> plusSub = new ArrayList<>(sub);
                    plusSub.add(num);
                    addSubs.add(plusSub);
                }
                ans.addAll(addSubs);
            }
            return ans;
        }
    }

    static class Solution1 {
        private List<List<Integer>> ans;

        public List<List<Integer>> subsets(int[] nums) {
            ans = new ArrayList<>();
            backtrack(nums, 0, new ArrayList<>());
            return ans;
        }

        private void backtrack(int[] nums, int index, List<Integer> list) {
            if (index == nums.length) {
                ans.add(new ArrayList<>(list));
                return;
            }
            list.add(nums[index]);
            backtrack(nums, index + 1, list);
            list.remove(list.size() - 1);
            backtrack(nums, index + 1, list);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Solution().subsets(nums));
    }
}
