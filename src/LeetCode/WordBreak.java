package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
 */
//自己写的递归超时了，看了discuss

//class WordBreakSolution0 {
//    public boolean wordBreak(String s, List<String> wordDict) {
//        if (s.length() == 0) return true;
//        boolean flag = false;
//        for (int i = 0; i < wordDict.size(); i++) {
//            String sub = "";
//            if (s.length() >= wordDict.get(i).length()) {
//                sub = s.substring(0, wordDict.get(i).length());
//            } else {
//                continue;
//            }
//            if (sub.equals(wordDict.get(i))) {
//                flag = flag || wordBreak(s.substring(sub.length()), wordDict);
//            }
//        }
//        return flag;
//    }
//}

class WordBreakSolution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return false;
        int len = s.length();
        boolean[] dp = new boolean[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                String sub = s.substring(j, i + 1);
                if (wordDict.contains(sub) && (j == 0 || dp[j - 1])) {
                    dp[i] = true;
                    break;  //只会跳出一层循环！！！
                }
            }
        }
        return dp[len - 1];
    }
}


public class WordBreak {
    public static void main(String[] args) {
        WordBreakSolution wordBreakSolution = new WordBreakSolution();
        String s = "leetcode";
//        String s = "catsandog";
//        String s="applepenapple";
//        String s = "abcd";
//        String s = "cars";
        List<String> wordDict = new ArrayList<>();
//        String[] dict = {"car", "ca", "rs"};
//        String[] dict = {"cats", "dog", "sand", "and", "cat"};
        String[] dict = {"leet", "code"};
        for (int i = 0; i < dict.length; i++) {
            wordDict.add(dict[i]);
        }
        System.out.println(wordBreakSolution.wordBreak(s, wordDict));
//        boolean[] dp = new boolean[2];
//        System.out.println("dp[0]= " + dp[0]);
    }
}
