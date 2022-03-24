package Beijing;
/*
https://leetcode-cn.com/problems/triangle/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    // 这个dp有可以优化的地方
    static class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            // dp[i][j]=min(dp[i-1][j],dp[i-1][j-1])+matrix[i][j];
            int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
            for (int[] row : dp) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
            for (int i = 0; i < triangle.get(0).size(); i++) {
                dp[0][i] = triangle.get(0).get(i);
            }
            for (int i = 1; i < triangle.size(); i++) {
                for (int j = 0; j < triangle.get(i).size(); j++) {
                    if (j == 0) {
                        dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                    }
                }
            }
            int ans = dp[triangle.size() - 1][0];
            for (int x : dp[triangle.size() - 1]) {
                ans = Math.min(x, ans);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
//        [[2],[3,4],[6,5,7],[4,1,8,3]]
        int[] nums0 = {2};
        int[] nums1 = {3, 4};
        int[] nums2 = {6, 5, 7};
        int[] nums3 = {4, 1, 8, 3};
        triangle.add(addNum(nums0));
        triangle.add(addNum(nums1));
        triangle.add(addNum(nums2));
        triangle.add(addNum(nums3));
        System.out.println((new Solution().minimumTotal(triangle)));
    }

    private static List<Integer> addNum(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        for (int num : nums) {
            list.add(num);
        }
        return list;
    }
}
