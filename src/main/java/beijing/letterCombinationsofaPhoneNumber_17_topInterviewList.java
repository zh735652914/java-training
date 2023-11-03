package beijing;
/*
https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
 */

import java.util.ArrayList;
import java.util.List;

// 第三次写了，注意特例就行
public class letterCombinationsofaPhoneNumber_17_topInterviewList {
    static class Solution {
        private List<String> ans;

        public List<String> letterCombinations(String digits) {
            int len = digits.length();
            if (len < 1) {
                ans = new ArrayList<>();
                return ans;
            }
            List<String> strs = new ArrayList<>(len);
            for (int i = 0; i < len; i++) {
                strs.add(getCharString(digits.charAt(i)));
            }
            ans = new ArrayList<>();
            backtrack(strs, new StringBuilder(), 0);
            return ans;
        }

        private void backtrack(List<String> strs, StringBuilder combination, int index) {
            if (index >= strs.size()) {
                ans.add(combination.toString());
                return;
            }
            String str = strs.get(index);
            int len = str.length();
            for (int i = 0; i < len; i++) {
                combination.append(str.charAt(i));
                backtrack(strs, combination, index + 1);
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
        String digits = "";
        System.out.println(new Solution().letterCombinations(digits));
    }
}
