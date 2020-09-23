package nowcoder;
/*
时间限制：C/C++ 3秒，其他语言6秒 空间限制：C/C++ 32M，其他语言64M 热度指数：20496
本题知识点： 字符串 动态规划
 算法知识视频讲解
题目描述
对于一个字符串，请设计一个高效算法，计算其中最长回文子串的长度。

给定字符串A以及它的长度n，请返回最长回文子串的长度。

测试样例：
"abc1234321ab",12
返回：7
题解 讨论 通过的代码笔记 纠错 收藏
 */

public class getLongestPalindrome {
    static public class Palindrome {
        public int getLongestPalindrome(String A, int n) {
            int max1 = Integer.MIN_VALUE;
            int max2 = Integer.MIN_VALUE;
            for (int i = 0; i < A.length(); i++) {
                int len1 = find(A, 0, i - 1, i + 1);
                int len2 = find(A, 0, i, i + 1);
                max1 = Math.max(max1, len1);
                max2 = Math.max(max2, len2);
            }
            return max1 >= max2 ? 1 + 2 * max1 : 2 * max2;
        }

        private int find(String s, int count, int left, int right) {
            if (left < 0 || right >= s.length()) {
                return count;
            }
            if (s.charAt(left) == s.charAt(right)) {
                count++;
                return find(s, count, --left, ++right);
            } else {
                return count;
            }
        }
    }

    public static void main(String[] args) {
        String s = "babcbcacababb";
        int n = 12;
        System.out.println(new Palindrome().getLongestPalindrome(s, n));
    }
}
