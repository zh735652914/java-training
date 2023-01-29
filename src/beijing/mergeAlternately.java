package beijing;
/*
https://leetcode.cn/problems/merge-strings-alternately/
 */

public class mergeAlternately {
    // 这就是练手的
    static class Solution {
        public String mergeAlternately(String word1, String word2) {
            if (word1.length() < 1 || word2.length() < 1) {
                return word1.length() < 1 ? word2 : word1;
            }
            StringBuilder ans = new StringBuilder();
            int index1 = 0, index2 = 0;
            int len1 = word1.length(), len2 = word2.length();
            while (index1 < len1 && index2 < len2) {
                ans.append(word1.charAt(index1++));
                ans.append(word2.charAt(index2++));
            }
            if (index1 < len1) {
                ans.append(word1.substring(index1));
            }
            if (index2 < len2) {
                ans.append(word2.substring(index2));
            }
            return ans.toString();
        }
    }

    public static void main(String[] args) {
        String word1 = "abc", word2 = "pqr";
        System.out.println(new Solution().mergeAlternately(word1, word2));
    }
}
