package LeetCode;
/*
https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
17. 电话号码的字母组合
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。





示例 1：

输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
示例 2：

输入：digits = ""
输出：[]
示例 3：

输入：digits = "2"
输出：["a","b","c"]


提示：

0 <= digits.length <= 4
digits[i] 是范围 ['2', '9'] 的一个数字。
 */

import java.util.*;

public class letterCombinations {
    static class Solution {
        public List<String> letterCombinations(String digits) {
            if (digits.length() == 0 || digits.equals("1")) {
                return new ArrayList<>();
            }
            Map<Character, String> map = new HashMap<>();
            map.put('2', "abc");
            map.put('3', "def");
            map.put('4', "ghi");
            map.put('5', "jkl");
            map.put('6', "mno");
            map.put('7', "pqrs");
            map.put('8', "tuv");
            map.put('9', "wxyz");
            List<String> ans = new ArrayList<>();
            backtrack(ans, 0, digits, new StringBuilder(), map);
            return ans;
        }

        private void backtrack(List<String> ans, int index, String digits, StringBuilder aAns, Map<Character, String> map) {
            if (digits.length() == index) {
                ans.add(aAns.toString());
                return;
            }
            String now = map.get(digits.charAt(index));
            for (int i = 0; i < now.length(); i++) {
                aAns.append(now.charAt(i));
                backtrack(ans, index + 1, digits, aAns, map);
                aAns.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(new Solution().letterCombinations(scanner.next()));
        }
    }
}
