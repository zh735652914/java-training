package Beijing.hot100;
/*
https://leetcode.cn/problems/permutations/
 */

import java.util.ArrayList;
import java.util.List;

public class permutations_46 {
    // 自己写的，但是就怕面试的时候脑子短路
    static class Solution {
        private List<List<Integer>> ans;
        private boolean[] flag;

        public List<List<Integer>> permute(int[] nums) {
            ans = new ArrayList<>();
            flag = new boolean[nums.length];
            backtrack(new ArrayList<>(), nums, 0);
            return ans;
        }

        private void backtrack(List<Integer> aAns, int[] nums, int index) {
            if (aAns.size() == nums.length) {
                ans.add(new ArrayList<>(aAns));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                int pos = (index + i) % nums.length; // 这一步没必要
                pos = i;
                if (!flag[pos]) {
                    flag[pos] = true;
                    aAns.add(nums[pos]);
                    backtrack(aAns, nums, pos);
                    aAns.remove(aAns.size() - 1);
                    flag[pos] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
//        int[] nums = {1};
        System.out.println(new Solution().permute(nums));
    }
}
