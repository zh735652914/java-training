package Beijing;
/*
https://leetcode.cn/problems/maximum-score-after-splitting-a-string/
 */

// 的确比较简单
public class maxScore {
    static class Solution {
        public int maxScore(String s) {
            int[] LtR = new int[s.length()];
            int[] RtL = new int[s.length()];
            int len = s.length();
            LtR[0] = s.charAt(0) == '0' ? 1 : 0;
            for (int i = 1; i < len; i++) {
                LtR[i] = LtR[i - 1] + (s.charAt(i) == '0' ? 1 : 0);
            }
            RtL[len - 1] = s.charAt(len - 1) == '1' ? 1 : 0;
            for (int i = len - 2; i >= 0; i--) {
                RtL[i] = RtL[i + 1] + (s.charAt(i) == '1' ? 1 : 0);
            }
            int ans = 0, count = 0;
            for (int i = 0; i < len - 1; i++) {
                count = LtR[i] + RtL[i + 1];
                ans = Math.max(ans, count);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String s = "1111";
        System.out.println(new Solution().maxScore(s));
    }
}
