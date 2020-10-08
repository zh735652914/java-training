package nowcoder;
/*
 牛客题霸-名企高频面试题
通配符匹配 相似的企业真题
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：8877
本题知识点： 贪心 字符串 动态规划 回溯
 算法知识视频讲解
题目描述
请实现支持'?'and'*'.的通配符模式匹配
'?' 可以匹配任何单个字符。
'*' 可以匹配任何字符序列（包括空序列）。
返回两个字符串是否匹配
函数声明为：
bool isMatch(const char *s, const char *p)
下面给出一些样例：
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "d*a*b") → false
 */

public class NC44 {
    //超时
    static public class Solution0 {
        public boolean isMatch(String s, String p) {
            if (p.length() == 0) {
                return s.length() == 0;
            }
            if (s.length() == 0) {
                return p.equals("*") || p.equals("?");
            }

            if (p.charAt(0) == '?') {
                return isMatch(s.substring(1), p.substring(1));
            }
            if (p.charAt(0) == '*') {
                if (p.length() == 1) {
                    return true;
                }
                boolean flag = false;
                for (int i = 1; i < p.length(); i++) {
                    if (p.charAt(i) == s.charAt(0)) {
                        flag = isMatch(s.substring(1), p.substring(i + 1));
                    }
                }
                if (!flag) {
                    return isMatch(s, p.substring(1));
                } else {
                    return true;
                }
            }
            return s.charAt(0) == p.charAt(0) && isMatch(s.substring(1), p.substring(1));
        }
    }

    static public class Solution {
        public boolean isMatch(String s, String p) {
            if (s == null) {
                return p == null || p.equals("*");
            }
            int index_s = 0, index_p = 0;
            int back_s = -1, back_p = -1;
            while (index_s < s.length()) {
                if (index_p < p.length() && (s.charAt(index_s) == p.charAt(index_p) || p.charAt(index_p) == '?')) {
                    index_p++;
                    index_s++;
                } else if (index_p < p.length() && p.charAt(index_p) == '*') {
                    back_s = index_s;
                    back_p = index_p++;
                } else if (back_p != -1) {
                    index_s = back_s + 1;
                    index_p = back_p++;
                    back_s = index_s;
                } else {
                    return false;
                }
            }
            while (index_p < p.length() && p.charAt(index_p) == '*') {
                index_p++;
            }
            return index_p == p.length();
        }
    }

    public static void main(String[] args) {
        String s = "a";
        String p = "aa";
        System.out.println(new Solution().isMatch(s, p));
    }
}
