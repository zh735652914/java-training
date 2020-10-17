package LeetCode;
/*
3. 无重复字符的最长子串
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
通过次数695,350提交次数1,944,598
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class lengthOfLongestSubstring {
    static class Solution {
        public int lengthOfLongestSubstring0(String s) {
            if (s.length() < 1) {
                return 0;
            }
            Map<Character, Integer> map = new HashMap<>();
            int[] dp = new int[s.length()];
            dp[0] = 1;
            map.put(s.charAt(0), 0);
            int maxLen = 1;
            for (int i = 1; i < s.length(); i++) {
                if (!map.containsKey(s.charAt(i))) {
                    dp[i] = dp[i - 1] + 1;
                    map.put(s.charAt(i), i);
                } else {
                    int start = map.get(s.charAt(i));
                    dp[i] = i - start;
                    map.clear();
                    for (int j = start; j <= i; j++) {
                        map.put(s.charAt(j), j);
                    }
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
            return maxLen;
        }

        public int lengthOfLongestSubstring(String s) {
            Set<Character> set = new HashSet<>();
            int ans = 0;
            int end = -1;
            for (int i = 0; i < s.length(); i++) {
                if (i != 0) {
                    set.remove(s.charAt(i - 1));
                }
                while (end + 1 < s.length() && !set.contains(s.charAt(end + 1))) {
                    set.add(s.charAt(++end));
                }
                ans = Math.max(ans, set.size());
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(new Solution().lengthOfLongestSubstring(s));
    }
}
