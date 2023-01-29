package beijing.hot100;
/*
https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
 */

import java.util.ArrayList;
import java.util.List;

// 第二次写，需要细心点
public class letterCombinationsofaPhoneNumber {
    static class Solution {
        private List<Character>[] nums;
        private List<String> ans;

        public List<String> letterCombinations(String digits) {
            nums = new List[10];
            char ch = 'a';
            for (int i = 2; i < 7; i++) {
                nums[i] = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    nums[i].add(ch);
                    ch++;
                }
            }
            nums[7] = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                nums[7].add(ch);
                ch++;
            }
            nums[8] = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                nums[8].add(ch);
                ch++;
            }
            nums[9] = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                nums[9].add(ch);
                ch++;
            }
            ans = new ArrayList<>();
            if (digits.length() < 1) {
                return ans;
            }
            dfs(digits, 0, new StringBuilder());
            return ans;
        }

        private void dfs(String digits, int index, StringBuilder stringBuilder) {
            int len = digits.length();
            if (index > len) {
                return;
            }
            if (index == len) {
                ans.add(stringBuilder.toString());
                return;
            }
            List<Character> chs = nums[digits.charAt(index) - '0'];
            for (Character c : chs) {
                stringBuilder.append(c);
                dfs(digits, index + 1, new StringBuilder(stringBuilder));
                stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
            }
        }
    }

    public static void main(String[] args) {
        String digits = "7";
        System.out.println(new Solution().letterCombinations(digits));
    }
}
