package beijing;
/*
https://leetcode.cn/problems/number-of-times-binary-string-is-prefix-aligned/
 */

/**
 * @author zhouhao
 * @date 2023/6/14 12:49
 */
public class NumTimesAllBlue {
    // 自己不会，脑筋急转弯？
    static class Solution {
        public int numTimesAllBlue(int[] flips) {
            int ans = 0, max = 0;
            for (int i = 0; i < flips.length; i++) {
                max = Math.max(flips[i], max);
                ans += max == i + 1 ? 1 : 0;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] flips = {3, 2, 4, 1, 5};
        System.out.println(new Solution().numTimesAllBlue(flips));
    }
}
