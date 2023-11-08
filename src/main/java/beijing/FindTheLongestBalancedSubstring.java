package beijing;
/*
https://leetcode.cn/problems/find-the-longest-balanced-substring-of-a-binary-string/?envType=daily-question&envId=2023-11-08
 */

/**
 * @author zhouhao
 * @date 2023/11/8 13:48
 */
public class FindTheLongestBalancedSubstring {
    // 自己没写出来，情况没想清楚
    static class Solution {
        public int findTheLongestBalancedSubstring(String s) {
            int ans = 0;
            int[] count = new int[2];
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    count[1]++;
                    ans = Math.max(ans, Math.min(count[0], count[1]));
                } else if (i == 0 || s.charAt(i - 1) == '1') {
                    count[0] = 1;
                    count[1] = 0;
                } else {
                    count[0]++;
                }
            }
            return ans * 2;
        }
    }

    public static void main(String[] args) {
        String s = "01000111";
        System.out.println(new Solution().findTheLongestBalancedSubstring(s));
    }
}
