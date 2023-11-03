package beijing;
/*
https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouhao
 * @date 2023/3/28 13:00
 */
// 太久没刷了
public class LetterCombinationsofaPhoneNumber_17_HotOneHundred {
    static class Solution {
        private List<String> ans;

        public List<String> letterCombinations(String digits) {
            ans = new ArrayList<>();
            if (digits.length() == 0) {
                return ans;
            }
            backtrack(digits, 0, new StringBuilder());
            return ans;
        }

        private void backtrack(String digits, int index, StringBuilder combination) {
            if (index == digits.length()) {
                ans.add(combination.toString());
                return;
            }
            String word = getCharString(digits.charAt(index));
            for (int i = 0; i < word.length(); i++) {
                combination.append(word.charAt(i));
                backtrack(digits, index + 1, combination);
                combination.deleteCharAt(combination.length() - 1);
            }
        }

        private String getCharString(char num) {
            switch (num) {
                case '2':
                    return "abc";
                case '3':
                    return "def";
                case '4':
                    return "ghi";
                case '5':
                    return "jkl";
                case '6':
                    return "mno";
                case '7':
                    return "pqrs";
                case '8':
                    return "tuv";
                case '9':
                    return "wxyz";
            }
            return "";
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(new Solution().letterCombinations(digits));
    }
}
