package Beijing.hot100;
/*
https://leetcode.cn/problems/palindromic-substrings/
 */

public class palindromicSubstrings_647 {
    // 自己第一次写的算法还是很牛逼的
    static class Solution {
        // 回文从中心扩展是子回文
        public int countSubstrings(String s) {
            int count = 0, len = s.length();
            for (int i = 0; i < len; i++) {
                count += countPalindromic(s, i, i);
                count += countPalindromic(s, i, i + 1);
            }
            return count;
        }

        private int countPalindromic(String s, int left, int right) {
            int count = 0, len = s.length();
            while (left >= 0 && right < len) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
                count++;
                left--;
                right++;
            }
            return count;
        }
    }

    static class Solution0 {
        public int countSubstrings(String s) {
            int len = s.length();
            int count = len;
            char[] chs = s.toCharArray();
            for (int i = 1; i <= len; i++) {
                for (int j = 0; j < len - i; j++) {
                    if (isPalindromic(chs, j, j + i)) {
                        count++;
                    }
                }
            }
            return count;
        }

        private boolean isPalindromic(char[] chs, int start, int end) {
            while (start < end) {
                if (chs[start] != chs[end]) {
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(new Solution().countSubstrings(s));
    }
}
