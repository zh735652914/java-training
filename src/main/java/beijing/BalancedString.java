package beijing;
/*
https://leetcode.cn/problems/replace-the-substring-for-balanced-string/
 */

/**
 * @author zhouhao
 * @date 2023/2/13 12:55
 */
public class BalancedString {
    // 又是自己不会写的
    static class Solution {
        public int balancedString(String s) {
            int[] count = new int[4];
            int len = s.length();
            for (int i = 0; i < len; i++) {
                count[idx(s.charAt(i))]++;
            }
            int ans = len, target = len / 4;
            if (check(count, target)) {
                return 0;
            }
            for (int l = 0, r = 0; l < len; l++) {
                while (r < len && !check(count, target)) {
                    count[idx(s.charAt(r))]--;
                    r++;
                }
                if (!check(count, target)) {
                    break;
                }
                ans = Math.min(ans, r - l);
                count[idx(s.charAt(l))]++;
            }
            return ans;
        }

        private int idx(char x) {
            switch (x) {
                case 'Q':
                    return 0;
                case 'W':
                    return 1;
                case 'E':
                    return 2;
                case 'R':
                    return 3;
            }
            return 0;
        }

        private boolean check(int[] count, int target) {
            for (int j : count) {
                if (j > target) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String s = "QQQW";
        System.out.println(new Solution().balancedString(s));
    }
}
