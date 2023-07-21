package beijing;
/*
https://leetcode.cn/problems/subsets/
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouhao
 * @date 2023/7/21 12:49
 */
public class Subsets_78_HotOneHundred {
    static class Solution {
        // 这个写法真的很牛逼
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>());
            for (int num : nums) {
                List<List<Integer>> nextSubSet = new ArrayList<>();
                for (List<Integer> subSet : ans) {
                    List<Integer> subPlus = new ArrayList<>(subSet);
                    subPlus.add(num);
                    nextSubSet.add(subPlus);
                }
                ans.addAll(nextSubSet);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Solution().subsets(nums));
    }
}
