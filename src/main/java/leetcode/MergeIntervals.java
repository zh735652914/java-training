package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
class MergeIntervalsSolution {

    public int[][] merge(int[][] intervals) {
        List<List<Integer>> H = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0], R = intervals[i][1];
            int a = intervals[i][0], b = intervals[i][1];
            int[] pos = new int[H.size()];
            int p = 0, len = H.size();
            for (int j = 0; j < len; j++) {
                int x = H.get(j).get(0), y = H.get(j).get(1);
                if (x > R || y < L) continue;
                if (x <= R || y >= L) {
                    pos[p] = j;
                    p++;
                    L = Math.min(x, L);
                    R = Math.max(y, R);
                }
            }
            //必须得倒着循环！！！！！
            for (int j = p - 1; j >= 0; j--) {
                H.remove(pos[j]);
            }
            List<Integer> aAns = new ArrayList<>();
            aAns.add(L);
            aAns.add(R);
            H.add(aAns);
        }
        int[][] ans = new int[H.size()][2];
        for (int i = 0; i < H.size(); i++) {
            ans[i][0] = H.get(i).get(0);
            ans[i][1] = H.get(i).get(1);
        }
        return ans;
    }
}

public class MergeIntervals {
    public static void main(String[] args) {
//        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        int[][] intervals = {{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
        int[][] intervals = {{1, 4}, {5, 6}};
        MergeIntervalsSolution MIS = new MergeIntervalsSolution();
        int[][] ans = MIS.merge(intervals);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                System.out.print(ans[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }
}
