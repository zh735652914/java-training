package beijing;
/*
https://leetcode.cn/problems/compare-strings-by-frequency-of-the-smallest-character/
 */

import java.util.Arrays;

/**
 * @author zhouhao
 * @date 2023/6/10 15:05
 */
public class NumSmallerByFrequency {
    // 魔鬼的二分查找
    static class Solution {
        public int[] numSmallerByFrequency(String[] queries, String[] words) {
            int[] q = new int[queries.length];
            int[] w = new int[words.length];
            for (int i = 0; i < queries.length; i++) {
                q[i] = getNum(queries[i]);
            }
            for (int i = 0; i < words.length; i++) {
                w[i] = getNum(words[i]);
            }
            Arrays.sort(w);
            int[] ans = new int[q.length];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = w.length - findPos(w, q[i]);
            }
            return ans;
        }

        // 在 nums 中二分查找第一个大于target的位置
        private int findPos(int[] nums, int target) {
            int left = 0, right = nums.length;
            while (left < right) {
                int mid = (left + right) / 2;
                if (target >= nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }

        private int getNum(String str) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            int count = 1;
            for (int i = 1; i < ch.length && ch[i] == ch[i - 1]; i++) {
                count++;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        String[] queries = {"bbb", "cc"}, words = {"a", "aa", "aaa", "aaaa"};
//        String[] queries = {"aabbabbb", "abbbabaa", "aabbbabaa", "aabba", "abb", "a", "ba", "aa", "ba", "baabbbaaaa", "babaa", "bbbbabaa"};
//        String[] words = {"b", "aaaba", "aaaabba", "aa", "aabaabab", "aabbaaabbb", "ababb", "bbb", "aabbbabb", "aab", "bbaaababba", "baaaaa"};
        System.out.println(Arrays.toString(new Solution().numSmallerByFrequency(queries, words)));
    }
}
