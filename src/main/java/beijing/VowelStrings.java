package beijing;
/*
https://leetcode.cn/problems/count-vowel-strings-in-ranges/
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhouhao
 * @date 2023/6/2 13:10
 */
public class VowelStrings {
    // 其实是不难的
    static class Solution {
        public int[] vowelStrings(String[] words, int[][] queries) {
            int[] prefixSums = new int[words.length + 1];
            for (int i = 1; i < prefixSums.length; i++) {
                prefixSums[i] = prefixSums[i - 1] + (isMatch(words[i - 1]) ? 1 : 0);
            }
            int[] ans = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                ans[i] = prefixSums[queries[i][1] + 1] - prefixSums[queries[i][0]];
            }
            return ans;
        }

        private boolean isMatch(String word) {
            Set<Character> set = new HashSet<>();
            set.add('a');
            set.add('e');
            set.add('i');
            set.add('o');
            set.add('u');
            return set.contains(word.charAt(0)) && set.contains(word.charAt(word.length() - 1));
        }
    }

    public static void main(String[] args) {
        String[] words = {"aba", "bcb", "ece", "aa", "e"};
        int[][] queries = {{0, 2}, {1, 4}, {1, 1}};
        System.out.println(Arrays.toString(new Solution().vowelStrings(words, queries)));
    }
}
