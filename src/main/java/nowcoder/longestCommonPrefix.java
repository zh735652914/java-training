package nowcoder;
/*
 牛客题霸-名企高频面试题
最长公共前缀 相似的企业真题
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：11945
本题知识点： 字符串
 算法知识视频讲解
题目描述
编写一个函数来查找字符串数组中的最长公共前缀。
示例1
输入
复制
["a","b"]
输出
复制
""
 */

public class longestCommonPrefix {
    static public class Solution {
        /**
         * @param strs string字符串一维数组
         * @return string字符串
         */
        public String longestCommonPrefix(String[] strs) {
            StringBuilder stringBuilder = new StringBuilder();
            if (strs.length == 0) {
                return stringBuilder.toString();
            }
            int index = 0;
            while (index < strs[0].length()) {
                char x = strs[0].charAt(index);
                for (String s : strs) {
                    if (index >= s.length() || s.charAt(index) != x) {
                        return stringBuilder.toString();
                    }
                }
                stringBuilder.append(x);
                index++;
            }
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        String[] strs = {"a", "b"};
        System.out.println(new Solution().longestCommonPrefix(strs));
    }
}
