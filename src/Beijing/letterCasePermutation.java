package Beijing;
/*
https://leetcode.cn/problems/letter-case-permutation/
 */

import java.util.ArrayList;
import java.util.List;

public class letterCasePermutation {
    // 自己没写出来
    static class Solution {
        private List<String> ans;

        public List<String> letterCasePermutation(String s) {
            ans = new ArrayList<>();
            char[] chs = s.toCharArray();
            backtrack(chs, 0);
            return ans;
        }

        private void backtrack(char[] chs, int index) {
            while (index < chs.length && Character.isDigit(chs[index])) {
                index++;
            }
            if (index >= chs.length) {
                ans.add(new String(chs));
                return;
            }
            chs[index] = Character.toUpperCase(chs[index]);
            backtrack(chs, index + 1);
            chs[index] = Character.toLowerCase(chs[index]);
            backtrack(chs, index + 1);
        }
    }

    public static void main(String[] args) {
        String s = "a1b2";
        System.out.println(new Solution().letterCasePermutation(s));
    }
}
