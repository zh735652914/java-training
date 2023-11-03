package beijing.hot100;
/*
https://leetcode.cn/problems/word-break/
 */

import java.util.*;

public class wordBreak_139 {
    // 第二次写还是不会
    static class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> set = new HashSet<>(wordDict.size());
            int maxLen = 0;
            for (String word : wordDict) {
                set.add(word);
                maxLen = Math.max(maxLen, word.length());
            }
            int len = s.length();
            boolean[] dp = new boolean[len + 1];
            dp[0] = true;
            for (int i = 1; i < len + 1; i++) {
                for (int j = i; j >= 0 && j >= (i - maxLen); j--) {
                    if (dp[j] && set.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[len];
        }
    }

    public static void main(String[] args) {
        String s = "applepenapple";
        String[] Dict = {"apple", "pen"};
        List<String> wordDict = new ArrayList<>(Arrays.asList(Dict));
        System.out.println(new Solution().wordBreak(s, wordDict));
    }
}
