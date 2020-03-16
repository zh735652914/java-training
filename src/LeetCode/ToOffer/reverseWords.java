package LeetCode.ToOffer;
/*
面试题58 - I. 翻转单词顺序
输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
例如输入字符串"I am a student. "，则输出"student. a am I"。



示例 1：

输入: "the sky is blue"
输出: "blue is sky the"
示例 2：

输入: "  hello world!  "
输出: "world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
示例 3：

输入: "a good   example"
输出: "example good a"
解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。


说明：

无空格字符构成一个单词。
输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
注意：本题与主站 151 题相同：https://leetcode-cn.com/problems/reverse-words-in-a-string/

注意：此题对比原题有改动

通过次数4,311提交次数10,349
 */

import java.util.Scanner;
import java.util.Stack;

public class reverseWords {
    static class Solution {

        //别人的写法，自己没想到。。。
        public String reverseWords(String s) {
            String[] a = s.split(" ");
            StringBuffer sb = new StringBuffer();
            for (int i = a.length - 1; i >= 0; i--) {
                if (!a[i].equals("")) {
                    sb.append(a[i]);
                    sb.append(" ");
                }
            }
            return sb.toString().trim();

        }

        //自己写的。。。
        public String reverseWords0(String s) {
//            if (s.length() < 2) return s;
            if (s.length() == 0) return s;
            Stack<String> stack = new Stack<>();
            int start, end;
            for (start = 0, end = start + 1; start < s.length() - 1 && end < s.length(); end++) {
                if (s.charAt(start) == ' ') {
                    start++;
                } else if (s.charAt(end) == ' ') {
                    stack.push(s.substring(start, end));
                    start = end;
                }
            }
            if (s.charAt(end - 1) != ' ' && s.charAt(start) != ' ') {
                stack.push(s.substring(start, end));
            }
            StringBuilder builder = new StringBuilder();
            while (!stack.isEmpty()) {
                builder.append(stack.pop());
                if (!stack.isEmpty()) {
                    builder.append(" ");
                }
            }
            return builder.toString();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            System.out.println(new Solution().reverseWords(s));
        }
    }
}
