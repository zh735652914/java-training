package beijing;
/*
https://leetcode.cn/problems/insert-interval/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhouhao
 * @date 2023/8/28 13:48
 */
public class InsertInterval_57 {
    // 这题还是要看看
    static class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            int[][] arr = new int[intervals.length + 1][2];
            for (int i = 0; i < arr.length; i++) {
                if (i == arr.length - 1) {
                    arr[i] = newInterval;
                } else {
                    arr[i] = intervals[i];
                }
            }
            Arrays.sort(arr, (o1, o2) -> (o1[0] - o2[0]));
            List<int[]> merge = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                int left = arr[i][0], right = arr[i][1];
                if (merge.size() == 0 || merge.get(merge.size() - 1)[1] < left) {
                    merge.add(arr[i]);
                } else if (merge.get(merge.size() - 1)[1] < right) {
                    merge.get(merge.size() - 1)[1] = right;
                }
            }
            return merge.toArray(new int[merge.size()][2]);
        }
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] ans = new Solution().insert(intervals, newInterval);
        for (int[] row : ans) {
            System.out.println(Arrays.toString(row));
        }
    }
}
