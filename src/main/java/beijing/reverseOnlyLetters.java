package beijing;
/*
https://leetcode-cn.com/problems/reverse-only-letters/
 */

import java.util.ArrayList;
import java.util.List;

public class reverseOnlyLetters {
    // 官方写的效率要高一些
    static class Solution {
        public String reverseOnlyLetters(String s) {
            int left = 0, right = s.length() - 1;
            char[] chs = s.toCharArray();
            while (left < right) {
                if (!Character.isLetter(chs[left])) {
                    left++;
                    continue;
                }
                if (!Character.isLetter(chs[right])) {
                    right--;
                    continue;
                }
                swap(chs, left, right);
                left++;
                right--;
            }
            return new String(chs);
        }

        private void swap(char[] chs, int a, int b) {
            char tmp = chs[a];
            chs[a] = chs[b];
            chs[b] = tmp;
        }
    }

    // 这是自己写的
    static class Solution0 {
        public String reverseOnlyLetters(String s) {
            StringBuilder stringBuilder = new StringBuilder();
            List<Integer> listIndex = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                if (!Character.isLetter(s.charAt(i))) {
                    listIndex.add(i);
                } else {
                    stringBuilder.append(s.charAt(i));
                }
            }
            stringBuilder.reverse();
            for (int index : listIndex) {
                stringBuilder.insert(index, s.charAt(index));
            }
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        String s = "a-bC-dEf-ghIj";
        System.out.println(new Solution().reverseOnlyLetters(s));
    }
}
