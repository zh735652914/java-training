package Beijing;
/*
https://leetcode-cn.com/problems/merge-intervals/
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
    static class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length == 0) {
                return intervals;
            }
            Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);
            List<int[]> merged = new LinkedList<>();
            for (int i = 0; i < intervals.length; i++) {
                int L = intervals[i][0], R = intervals[i][1];
                if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                    merged.add(intervals[i]);
                } else {
                    merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
                }
            }
            return merged.toArray(new int[merged.size()][]);
        }
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] ans = new Solution().merge(intervals);
        for (int[] an : ans) {
            System.out.print("[");
            for (int i : an) {
                System.out.print(i + ",");
            }
            System.out.print("], ");
        }
    }
}
