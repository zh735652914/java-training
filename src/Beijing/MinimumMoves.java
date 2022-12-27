package Beijing;
/*
https://leetcode.cn/problems/minimum-moves-to-convert-string/
 */

/**
 * @author zhouhao
 * @date 2022/12/27 12:58
 */
public class MinimumMoves {
    // 这种题我自己都不会写了
    static class Solution {
        public int minimumMoves(String s) {
            int ans = 0, coverd = -1;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'X' && i > coverd) {
                    coverd = i + 2;
                    ans++;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String s = "XXOX";
        System.out.println(new Solution().minimumMoves(s));
    }
}
