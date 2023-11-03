package beijing;
/*
https://leetcode.cn/problems/word-break/description/
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhouhao
 * @date 2023/10/31 12:30
 */
public class WordBreak_139_HotOneHundred {
    static class Solution {
        // 还是不会
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> set = new HashSet<>(wordDict);
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    dp[i] = dp[j] && set.contains(s.substring(j, i));
                    if (dp[i]) {
                        break;
                    }
                }
            }
            return dp[s.length()];
        }
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(new Solution().wordBreak(s, wordDict));
    }
}
