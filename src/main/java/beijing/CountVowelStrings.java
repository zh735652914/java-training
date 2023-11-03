package beijing;
/*
https://leetcode.cn/problems/count-sorted-vowel-strings/
 */

import java.util.Arrays;

/**
 * @author zhouhao
 * @date 2023/3/29 12:40
 */
public class CountVowelStrings {
    // 自己太菜了啊
    static class Solution {
        public int countVowelStrings(int n) {
            int[] dp = new int[5];
            Arrays.fill(dp, 1);
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < 5; j++) {
                    dp[j] += dp[j - 1];
                }
            }
            return Arrays.stream(dp).sum();
        }
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(new Solution().countVowelStrings(n));
    }
}
