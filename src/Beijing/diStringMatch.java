package Beijing;
/*
https://leetcode.cn/problems/di-string-match/
 */

// 简单题我都不会了
public class diStringMatch {
    static class Solution {
        public int[] diStringMatch(String s) {
            int n = s.length();
            int left = 0, right = n;
            int[] ans = new int[n + 1];
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == 'I') {
                    ans[i] = left++;
                } else {
                    ans[i] = right--;
                }
            }
            ans[n] = left;
            return ans;
        }
    }

    public static void main(String[] args) {
        String s = "IDID";
        int[] ans = new Solution().diStringMatch(s);
        for (int x : ans) {
            System.out.print(x + ", ");
        }
    }
}
