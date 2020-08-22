package LeetCode.ProgrammerInterview;
/*
面试题 17.15. 最长单词
给定一组单词words，编写一个程序，找出其中的最长单词，且该单词由这组单词中的其他单词组合而成。
若有多个长度相同的结果，返回其中字典序最小的一项，若没有符合要求的单词则返回空字符串。

示例：

输入： ["cat","banana","dog","nana","walk","walker","dogwalker"]
输出： "dogwalker"
解释： "dogwalker"可由"dog"和"walker"组成。
提示：

0 <= len(words) <= 200
1 <= len(words[i]) <= 100
通过次数2,072提交次数5,521
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//自己连思路都没有，真的是太久没刷题了。。。
public class longestWord {
    static class Solution {
        public String longestWord(String[] words) {
            Arrays.sort(words, ((o1, o2) -> {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return Integer.compare(o2.length(), o1.length());
                }
            }));
            Set<String> set = new HashSet<>(Arrays.asList(words));
            for (String word : words) {
                set.remove(word);
                if (find(word, set)) {
                    return word;
                }
            }
            return "";
        }

        private boolean find(String word, Set<String> set) {
            if (word.length() == 0) {
                return true;
            }
            for (int i = 0; i < word.length(); i++) {
                if (set.contains(word.substring(0, i + 1)) && find(word.substring(i + 1), set)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        String[] words = {"ttaaaa", "pp", "tpa", "kpaqkt", "tktpqq", "aqppatp"};
        System.out.println(new Solution().longestWord(words));
    }
}
