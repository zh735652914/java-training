package LeetCode;
/*
14. 最长公共前缀
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。

通过次数382,718提交次数984,732
 */

public class longestCommonPrefix {
    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            StringBuilder stringBuilder = new StringBuilder();
            if (strs.length == 1) {
                return strs[0];
            }
            int index = 0;
            char x = ' ';
            for (int i = 0; i < strs.length; i++) {
                if (i == 0 && index < strs[i].length()) {
                    x = strs[i].charAt(index);
                    continue;
                }
                if (index >= strs[i].length() || strs[i].charAt(index) != x) {
                    break;
                }
                if (i == strs.length - 1) {
                    stringBuilder.append(x);
                    index++;
                    i = -1;
                }
            }
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
//        String[] strs = {"dog", "racecar", "car"};
        String[] strs = {"a"};
        System.out.println(new Solution().longestCommonPrefix(strs));
    }
}
