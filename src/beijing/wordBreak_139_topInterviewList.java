package beijing;
/*
https://leetcode.cn/problems/word-break/
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class wordBreak_139_topInterviewList {
    // 第三次了，自己还是不会写
    static class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            int len = s.length();
            Set<String> set = new HashSet<>(wordDict);
            int maxLen = 0;
            for (String word : wordDict) {
                maxLen = Math.max(maxLen, word.length());
            }
            boolean[] dp = new boolean[len + 1];
            /*
            dp[i]=dp[j]&&check(s.sub(j,i))
             */
            dp[0] = true;
            for (int i = 0; i < len + 1; i++) {
                for (int j = Math.max(0, i - maxLen); j < i; j++) {
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
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(new Solution().wordBreak(s, wordDict));
    }
}
