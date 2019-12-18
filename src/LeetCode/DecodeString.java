package LeetCode;
/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets
is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those
repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */


import java.util.Stack;

class DecodeStringSolution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                StringBuilder tmp = new StringBuilder();
                Stack<String> T = new Stack<>();
                while (!stack.peek().equals("[")) {
                    T.push(stack.pop());
                }
                while (!T.isEmpty()) {
                    tmp.append(T.pop());
                }
                StringBuilder res = new StringBuilder(tmp.toString());
                stack.pop();
                StringBuilder count = new StringBuilder();

                while (!stack.empty() && stack.peek().length() == 1 && stack.peek().charAt(0) - '0' >= 0 && stack.peek().charAt(0) - '0' <= 9) {
                    count = count.insert(0, stack.pop());
//                    count.append(stack.pop());
                }
                for (int n = 0; n < Integer.parseInt(count.toString()) - 1; n++) {
                    res.append(tmp.toString());
                }
                stack.push(res.toString());
            } else {
                stack.push(String.valueOf(s.charAt(i)));
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.insert(0, stack.pop());
        }
        return ans.toString();
    }
}

public class DecodeString {
    public static void main(String[] args) {
//        String s = "3[a2[c]]";
//        String s = "3[a]2[bc]";
//        String s = "2[abc]3[cd]ef";
//        String s = "100[leetcode]";
        String s = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        System.out.println(new DecodeStringSolution().decodeString(s));
    }
}
