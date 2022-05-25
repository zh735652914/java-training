package Beijing.hot100;
/*
https://leetcode.cn/problems/merge-intervals/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mergeIntervals_56 {
    // 自己写的效率太低了
    static class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, ((o1, o2) -> o1[0] - o2[0]));
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> aList = new ArrayList<>();
            aList.add(intervals[0][0]);
            aList.add(intervals[0][1]);
            list.add(aList);
            for (int i = 1; i < intervals.length; i++) {
                int index = list.size() - 1;
                int low = intervals[i][0], high = intervals[i][1];
                int left = list.get(index).get(0), right = list.get(index).get(1);
                if (low > right) {
                    List<Integer> nList = new ArrayList<>();
                    nList.add(intervals[i][0]);
                    nList.add(intervals[i][1]);
                    list.add(nList);
                } else if (low >= left && high > right) {
                    list.get(index).remove(1);
                    list.get(index).add(high);
                }
            }
            int[][] ans = new int[list.size()][2];
            for (int i = 0; i < ans.length; i++) {
                ans[i][0] = list.get(i).get(0);
                ans[i][1] = list.get(i).get(1);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        int[][] intervals = {{1, 4}, {1, 5}};
        int[][] ans = new Solution().merge(intervals);
        for (int[] interval : ans) {
            for (int x : interval) {
                System.out.print(x + ", ");
            }
            System.out.println();
        }
    }
}
