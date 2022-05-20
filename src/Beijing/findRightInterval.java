package Beijing;
/*
https://leetcode.cn/problems/find-right-interval/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 官方的解析是在自己写的方法上加上二分搜索
public class findRightInterval {
    static class Solution {
        public int[] findRightInterval(int[][] intervals) {
            int[][] interIndex = new int[intervals.length][2];
            for (int i = 0; i < intervals.length; i++) {
                interIndex[i][0] = intervals[i][0];
                interIndex[i][1] = i;
            }
            Arrays.sort(interIndex, ((o1, o2) -> o1[0] - o2[0]));
            int[] ans = new int[intervals.length];
            for (int i = 0; i < intervals.length; i++) {
                int target = intervals[i][1];
                int pos = -1;
                int left = 0, right = interIndex.length - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (interIndex[mid][0] >= target) {
                        right = mid - 1;
                        pos = interIndex[mid][1];
                    } else {
                        left = mid + 1;
                    }
                }
                ans[i] = pos;
            }
            return ans;
        }
    }

    // 超时了
    static class Solution0 {
        public int[] findRightInterval(int[][] intervals) {
            List<List<Integer>> list = new ArrayList<>();
            for (int i = 0; i < intervals.length; i++) {
                List<Integer> aPir = new ArrayList<>();
                aPir.add(intervals[i][0]);
                aPir.add(i);
                list.add(aPir);
            }
            list.sort((o1, o2) -> o1.get(0) - o2.get(0));
            int[] ans = new int[intervals.length];
            Arrays.fill(ans, -1);
            for (int i = 0; i < intervals.length; i++) {
                for (List<Integer> pir : list) {
                    if (intervals[i][1] <= pir.get(0)) {
                        ans[i] = pir.get(1);
                        break;
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[][] intervals = {{3, 4}, {2, 3}, {1, 2}};
        int[] ans = new Solution().findRightInterval(intervals);
        for (int x : ans) {
            System.out.print(x + ", ");
        }
    }
}
