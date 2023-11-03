package leetcode;
/*
6. Z 字形变换
将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);
示例 1:

输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"
示例 2:

输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:

L     D     R
E   O E   I I
E C   I H   N
T     S     G
通过次数181,538提交次数371,058
 */

public class convert {
    static class Solution {
        public String convert(String s, int numRows) {
            if (s == null || s.length() < 2 || numRows < 2) {
                return s;
            }
            StringBuilder[] builders = new StringBuilder[numRows];
            int index = 0;
            int flag = -1;
            for (char c : s.toCharArray()) {
                if (builders[index] == null) {
                    builders[index] = new StringBuilder();
                }
                builders[index].append(c);
                if (index == 0 || index == numRows - 1) {
                    flag = -flag;
                }
                index += flag;
            }
            for (int i = 1; i < numRows; i++) {
                builders[0].append(builders[i] == null ? "" : builders[i]);
            }
            return builders[0].toString();
        }
    }

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        int numRows = 4;
        System.out.println(new Solution().convert(s, numRows));
    }
}
