package beijing;
/*
https://leetcode.cn/problems/count-the-number-of-vowel-strings-in-range/?envType=daily-question&envId=2023-11-07
 */

/**
 * @author zhouhao
 * @date 2023/11/7 13:23
 */
public class VowelStrings_2586 {
    static class Solution {
        public int vowelStrings(String[] words, int left, int right) {
            int ans = 0;
            for (int i = left; i <= right; i++) {
                if (isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length() - 1))) {
                    ans++;
                }
            }
            return ans;
        }

        private boolean isVowel(char x) {
            return x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u';
        }
    }

    public static void main(String[] args) {
        String[] words = {"are", "amy", "u"};
        int left = 0, right = 2;
        System.out.println(new Solution().vowelStrings(words, left, right));
    }
}
