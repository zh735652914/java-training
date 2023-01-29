package beijing;
/*
https://leetcode-cn.com/problems/insert-interval/
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InsertInterval {
    // 这个题目，哎，上个月写过还是不会
    static class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            int[][] newInter = new int[intervals.length + 1][2];
            for (int i = 0; i < newInter.length; i++) {
                if (i == newInter.length - 1) {
                    newInter[i] = newInterval;
                } else {
                    newInter[i] = intervals[i];
                }
            }
            Arrays.sort(newInter, (inter1, inter2) -> (inter1[0] - inter2[0]));
            List<int[]> merged = new LinkedList<>();
            for (int i = 0; i < newInter.length; i++) {
                int L = newInter[i][0], R = newInter[i][1];
                if (i == 0 || merged.get(merged.size() - 1)[1] < L) {
                    merged.add(newInter[i]);
                } else if (R > merged.get(merged.size() - 1)[1]) {
                    merged.get(merged.size() - 1)[1] = R;
                }
            }
            return merged.toArray(new int[merged.size()][2]);
        }
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        int[][] ans = new Solution().insert(intervals, newInterval);
        for (int[] an : ans) {
            System.out.print("{");
            for (int a : an) {
                System.out.print(a + ",");
            }
            System.out.print("}, ");
        }
    }
}
