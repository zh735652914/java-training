package beijing;
/*
https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks/
 */

/**
 * @author zhouhao
 * @date 2023/3/9 12:51
 */
// 这可是最基本的滑动窗口啊
public class MinimumRecolors {
    static class Solution {
        public int minimumRecolors(String blocks, int k) {
            int windows = 0, left = 0, right = 0;
            int ans = blocks.length();
            while (right < k) {
                if (blocks.charAt(right) == 'B') {
                    windows++;
                }
                right++;
            }
            ans = Math.min(ans, k - windows);
            while (right < blocks.length()) {
                if (blocks.charAt(right) == 'B') {
                    windows++;
                }
                if (blocks.charAt(left++) == 'B') {
                    windows--;
                }
                ans = Math.min(ans, k - windows);
                right++;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String blocks = "WBWBBBW";
        int k = 2;
        System.out.println(new Solution().minimumRecolors(blocks, k));
    }
}
