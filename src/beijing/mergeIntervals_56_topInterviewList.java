package beijing;
/*
https://leetcode.cn/problems/merge-intervals/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mergeIntervals_56_topInterviewList {
    // 排序，自己写的
    static class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                } else {
                    return a[0] - b[0];
                }
            });
            List<int[]> list = new ArrayList<>();
            int[] preInterval = intervals[0];
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] > preInterval[1]) {
                    list.add(preInterval);
                    preInterval = intervals[i];
                } else if (intervals[i][1] >= preInterval[1]) {
                    preInterval[1] = intervals[i][1];
                }
            }
            list.add(preInterval);
            int[][] ans = new int[list.size()][2];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = list.get(i);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        int[][] intervals = {{1, 4}, {2, 3}};
        int[][] ans = new Solution().merge(intervals);
        for (int[] nums : ans) {
            for (int num : nums) {
                System.out.print(num + ", ");
            }
            System.out.println();
        }
    }
}
