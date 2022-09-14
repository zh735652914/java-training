package Beijing;
/*
https://leetcode.cn/problems/mean-of-array-after-removing-some-elements/
 */

import java.util.Arrays;

public class trimMean {
    // 自己写的效率不高
    static class Solution {
        public double trimMean(int[] arr) {
            Arrays.sort(arr);
            int count = (int) (arr.length * 0.05);
            int sum = 0;
            for (int i = count; i < (arr.length - count); i++) {
                sum += arr[i];
            }
            return (double) sum / (arr.length - 2 * count);
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 0, 7, 0, 7, 5, 7, 8, 3, 4, 0, 7, 8, 1, 6, 8, 1, 1, 2, 4, 8, 1, 9, 5, 4, 3, 8, 5, 10, 8,
                6, 6, 1, 0, 6, 10, 8, 2, 3, 4};
        System.out.println(new Solution().trimMean(arr));
    }
}
