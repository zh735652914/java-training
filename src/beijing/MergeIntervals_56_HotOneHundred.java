package beijing;
/*
https://leetcode.cn/problems/merge-intervals/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhouhao
 * @date 2023/6/28 20:16
 */
public class MergeIntervals_56_HotOneHundred {
    // 不难，边界条件要考虑清楚
    static class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, ((o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }));
            List<int[]> list = new ArrayList<>();
            int left = intervals[0][0], right = intervals[0][1];
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] <= right) {
                    right = Math.max(intervals[i][1], right);
                } else {
                    list.add(new int[]{left, right});
                    left = intervals[i][0];
                    right = intervals[i][1];
                }
            }
            list.add(new int[]{left, right});
            int[][] ans = new int[list.size()][2];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = list.get(i);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
//        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals = {{1, 4}, {1, 4}};
        int[][] ans = new Solution().merge(intervals);
        for (int[] x : ans) {
            System.out.println(Arrays.toString(x));
        }
    }
}
