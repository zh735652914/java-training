package beijing;

/*
https://leetcode-cn.com/problems/implement-strstr/
 */
public class strStr {
    static class Solution {
        public int strStr(String haystack, String needle) {
            if (needle.length() == 0) {
                return 0;
            }
            int len = needle.length();
            for (int i = 0; i <= haystack.length() - len; i++) {
                if (haystack.substring(i, i + len).equals(needle)) {
                    return i;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        String haystack = "hello", needle = "ll";
        System.out.println(new Solution().strStr(haystack, needle));
    }
}
