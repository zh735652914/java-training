package nowcoder;
/*
 牛客题霸-名企高频面试题
回文数字 相似的企业真题
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：15044
 算法知识视频讲解
题目描述
在不使用额外的内存空间的条件下判断一个整数是否是回文数字
提示：
负整数可以是回文吗？（比如-1）
如果你在考虑将数字转化为字符串的话，请注意一下不能使用额外空间的限制
你可以将整数翻转。但是，如果你做过题目“反转数字”，你会知道将整数翻转可能会出现溢出的情况，你怎么处理这个问题？


示例1
输入
复制
121
输出
复制
true
 */

public class isPalindrome {
    static public class Solution {
        /**
         * @param x int整型
         * @return bool布尔型
         */
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            if (x < 10) {
                return true;
            }
            while (x > 0) {
                int len = Integer.toString(x).length();
                int top = (int) Math.pow(10, len - 1);
                if (x % 10 != x / top) {
                    return false;
                }
                x = x - x / top * top;
                x /= 10;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int x = 1221;
        System.out.println(new Solution().isPalindrome(x));
    }
}
