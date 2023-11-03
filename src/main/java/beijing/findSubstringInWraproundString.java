package beijing;
/*
https://leetcode.cn/problems/unique-substrings-in-wraparound-string/
 */

import java.util.HashSet;
import java.util.Set;

public class findSubstringInWraproundString {
    // 官方解析，自己没想到
    static class Solution {
        public int findSubstringInWraproundString(String p) {
            int[] dp = new int[26];
            int k = 1, len = p.length();
            for (int i = 0; i < len; i++) {
                if (i == 0) {
                    dp[p.charAt(i) - 'a'] = 1;
                    continue;
                }
                if (p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i) == 'a' && p.charAt(i - 1) == 'z') {
                    k++;
                } else {
                    k = 1;
                }
                dp[p.charAt(i) - 'a'] = Math.max(dp[p.charAt(i) - 'a'], k);
            }
            int ans = 0;
            for (int x : dp) {
                ans += x;
            }
            return ans;
        }
    }

    // 自己写的超时了
    static class Solution0 {
        private int count;
        private Set<String> subS;
        private int Len;

        public int findSubstringInWraproundString(String p) {
            count = 0;
            subS = new HashSet<>();
            Len = p.length();
            for (int i = 0; i < Len; i++) {
                dfs(p, i);
            }
            return count;
        }

        private void dfs(String p, int index) {
            if (index >= Len) {
                return;
            }
            for (int i = index; i < Len; i++) {
                for (int j = i + 1; j <= Len; j++) {
                    String sub = p.substring(index, j);
                    if (subS.contains(sub)) {
                        continue;
                    }
                    if (isInWrapround(sub)) {
                        count++;
                    }
                }
            }
        }

        private boolean isInWrapround(String s) {
            int len = s.length();
            subS.add(s);
            for (int i = 0; i < len - 1; i++) {
                if (s.charAt(i) == 'z' && s.charAt(i + 1) == 'a') {
                    continue;
                }
                if ((s.charAt(i + 1) - s.charAt(i)) != 1) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String p = "zab";
        System.out.println(new Solution().findSubstringInWraproundString(p));
    }
}
