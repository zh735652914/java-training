package beijing;
/*
https://leetcode.cn/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/?envType=daily-question&envId=2023-10-27
 */

import java.util.Arrays;

/**
 * @author zhouhao
 * @date 2023/10/27 11:50
 */
public class MaxArea {
    // 又不会写
    static class Solution {

        private static final int MOD = 1000000007;

        public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
            Arrays.sort(horizontalCuts);
            Arrays.sort(verticalCuts);
            return (int) (((long) getMax(horizontalCuts, h) * (long) getMax(verticalCuts, w)) % MOD);
        }

        private int getMax(int[] cuts, int border) {
            int max = 0, per = 0;
            for (int cut : cuts) {
                max = Math.max(max, cut - per);
                per = cut;
            }
            return Math.max(max, border - per);
        }
    }

    public static void main(String[] args) {
        int h = 5, w = 4;
        int[] horizontalCuts = {1, 2, 4}, verticalCuts = {1, 3};
        System.out.println(new Solution().maxArea(h, w, horizontalCuts, verticalCuts));
    }
}
