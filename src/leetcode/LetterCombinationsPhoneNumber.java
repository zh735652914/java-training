/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */

package leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class LetterCombinationsPhoneNumberSolution {
    List<String> ans = new ArrayList<>();
    HashMap<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
//        List<String> ans=new ArrayList<>();
//        String letters = phone.get(digits.substring(0,1));
        if (digits.length() == 0) return ans;
        backtrack("", digits);
        return ans;
    }

    public void backtrack(String combinations, String digits) {
        if (digits.length() == 0) {
            ans.add(combinations);
            return;
        }
        String letters = phone.get(digits.substring(0, 1));
        for (int i = 0; i < letters.length(); i++) {
//            combinations=combinations+letters.charAt(i);
            backtrack(combinations + letters.charAt(i), digits.substring(1));
        }
    }
}

public class LetterCombinationsPhoneNumber {
    public static void main(String[] args) {
        String digits = "23";
        LetterCombinationsPhoneNumberSolution LCN = new LetterCombinationsPhoneNumberSolution();
        List<String> ans = new ArrayList<>();
        ans = LCN.letterCombinations(digits);
        System.out.println("ans=" + ans);
    }
}
