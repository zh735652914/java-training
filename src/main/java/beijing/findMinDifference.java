package beijing;
/*
https://leetcode-cn.com/problems/minimum-time-difference/
 */

import java.util.Arrays;
import java.util.List;

public class findMinDifference {
    static class Solution {
        public int findMinDifference(List<String> timePoints) {
            int[] times = new int[timePoints.size()];
            for (int i = 0; i < timePoints.size(); i++) {
                String T = timePoints.get(i);
                times[i] = Integer.parseInt(T.substring(0, 2)) * 60 + Integer.parseInt(T.substring(3));
            }
            Arrays.sort(times);
            int min = Integer.MAX_VALUE;
            for (int i = 1; i < times.length; i++) {
                min = Math.min(min, times[i] - times[i - 1]);
            }
            // 这一句很重要
            return Math.min(min, times[0] + 60 * 24 - times[times.length - 1]);
        }
    }

    public static void main(String[] args) {
        String[] strings = {"12:12", "00:13"};
        List<String> timePoints = Arrays.asList(strings);
        System.out.println(new Solution().findMinDifference(timePoints));
    }
}
