package LeetCode.ToOffer;
/*
面试题05. 替换空格
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。



示例 1：

输入：s = "We are happy."
输出："We%20are%20happy."


限制：

0 <= s 的长度 <= 10000

通过次数6,871提交次数8,608
 */

import java.util.Scanner;

public class replaceSpace {
    static class Solution {
        public String replaceSpace(String s) {
//            char[] Arr = s.toCharArray();
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                ans.append(s.charAt(i) == ' ' ? "%20" : s.charAt(i));
            }
            return ans.toString();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //s = "We are happy."
        String s = scanner.nextLine();
        System.out.println(new Solution().replaceSpace(s));
    }
}
