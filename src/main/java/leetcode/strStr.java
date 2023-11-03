package leetcode;
/*
https://leetcode-cn.com/problems/implement-strstr/
28. 实现 strStr()
实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:

输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:

输入: haystack = "aaaaa", needle = "bba"
输出: -1
说明:

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。

通过次数320,840提交次数807,907
 */

public class strStr {

    static public class Solution2 {

        public int strStr(String haystack, String needle) {
            int L = needle.length();
            int n = haystack.length();
            for (int start = 0; start < n - L + 1; start++) {
                if (haystack.substring(start, start + L).equals(needle)) {
                    return start;
                }
            }
            return -1;
        }
    }

    static class Solution {
        public int strStr(String haystack, String needle) {
            if (needle.length() < 1) {
                return 0;
            }
            if (haystack.length() == needle.length()) {
                return haystack.equals(needle) ? 0 : -1;
            }
            int pos = 0;
            for (int i = 0; i <= haystack.length() - needle.length(); i++) {
                if (haystack.charAt(i) == needle.charAt(pos)) {
                    int j = i;
                    while (pos < needle.length()) {
                        if (needle.charAt(pos) != haystack.charAt(j)) {
                            break;
                        }
                        pos++;
                        j++;
                    }
                    if (pos >= needle.length()) {
                        return i;
                    }
                    pos = 0;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        String haystack = "csa";
        String needle = "a";
        System.out.println(new Solution().strStr(haystack, needle));
    }
}
