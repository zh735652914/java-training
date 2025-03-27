package next;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertTrue;

/**
 * @author zhouhao
 * @date 2025/3/27 08:31
 * https://leetcode.cn/problems/word-break/
 */
public class LeetCode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        /**
         * dp[i]=dp[j]&&dp[i-j]
         */
        Set<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
        }
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

    @Test
    public void test() {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        assertTrue(wordBreak(s, wordDict));
    }
}
