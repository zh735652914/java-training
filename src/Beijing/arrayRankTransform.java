package Beijing;
/*
https://leetcode.cn/problems/rank-transform-of-an-array/
 */

import java.util.Arrays;

public class arrayRankTransform {
    static class Solution {
        // 这是简单题？
        public int[] arrayRankTransform(int[] arr) {
            int[][] nums = new int[arr.length][2];
            for (int i = 0; i < arr.length; i++) {
                nums[i][0] = arr[i];
                nums[i][1] = i;
            }
//            Arrays.sort(nums, (Comparator.comparingInt(o -> o[0])));
            Arrays.sort(nums, ((o1, o2) -> o1[0] - o2[0]));
            int[] ans = new int[arr.length];
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i][0] == nums[i - 1][0]) {
                    ans[nums[i][1]] = count;
                } else {
                    count++;
                    ans[nums[i][1]] = count;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] arr = {40, 10, 20, 30, 20};
        int[] ans = new Solution().arrayRankTransform(arr);
        for (int x : ans) {
            System.out.print(x + ", ");
        }
    }
}
