package beijing;
/*
https://leetcode.cn/problems/longest-subsequence-with-limited-sum/
 */

import java.util.Arrays;

/**
 * @author zhouhao
 * @date 2023/3/17 12:36
 */
public class AnswerQueries {
    // 这是简单题？
    static class Solution {
        public int[] answerQueries(int[] nums, int[] queries) {
            Arrays.sort(nums);
            int[] ans = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int sum = 0;
                for (int j = 0; j < nums.length && sum <= queries[i]; j++) {
                    sum += nums[j];
                    if (sum <= queries[i]) {
                        ans[i]++;
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 1}, queries = {3, 10, 21};
        int[] ans = new Solution().answerQueries(nums, queries);
        for (int x : ans) {
            System.out.print(x + ", ");
        }
    }
}
