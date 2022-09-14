package Beijing;
/*
https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/
 */

// 这次自己写的要快一些
public class findtheIndexoftheFirstOccurrenceinaString_28_topInterviewList {
    static class Solution {
        public int strStr(String haystack, String needle) {
            int len1 = haystack.length(), len2 = needle.length();
            for (int i = 0; i <= len1 - len2; i++) {
                int index = 0;
                int nextStart = i;
                while (index < len2 && haystack.charAt(i) == needle.charAt(index)) {
                    i++;
                    index++;
                }
                if (index >= len2) {
                    return nextStart;
                }
                i = nextStart;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        String haystack = "adbutad", needle = "sad";
        System.out.println(new Solution().strStr(haystack, needle));
    }
}
