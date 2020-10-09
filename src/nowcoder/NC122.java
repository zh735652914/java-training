package nowcoder;
/*
 牛客题霸-名企高频面试题
正则表达式匹配 相似的企业真题
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：382112
本题知识点： 字符串
 算法知识视频讲解
题目描述
请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */

public class NC122 {
    static public class Solution {
        public boolean match(char[] str, char[] pattern) {
            return isMatch(str, pattern, 0, 0);
        }

        private boolean isMatch(char[] str, char[] pattern, int index_s, int index_p) {
            if (index_s == str.length && index_p == pattern.length) {
                return true;
            }
            if (index_p >= pattern.length) {
                return index_s >= str.length;
            }
            boolean first = index_s < str.length && (str[index_s] == pattern[index_p] || pattern[index_p] == '.' || pattern[index_p] == '*');
            if (index_p < pattern.length - 1 && pattern[index_p + 1] == '*' || pattern[index_p] == '*') {
                return isMatch(str, pattern, index_s, index_p + 2) || first && isMatch(str, pattern, index_s + 1, index_p);
            } else {
                return first && isMatch(str, pattern, index_s + 1, index_p + 1);
            }
        }
    }

    public static void main(String[] args) {
//        String s1 = "aaa";
//        String s2 = "ab*ac*a";
        String s1 = "a";
        String s2 = ".*";
        char[] str = s1.toCharArray();
        char[] pattern = s2.toCharArray();
        System.out.println(new Solution().match(str, pattern));
    }
}
