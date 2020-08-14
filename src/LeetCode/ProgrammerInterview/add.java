package LeetCode.ProgrammerInterview;
/*
面试题 17.01. 不用加号的加法
设计一个函数把两个数字相加。不得使用 + 或者其他算术运算符。

示例:

输入: a = 1, b = 1
输出: 2


提示：

a, b 均可能是负数或 0
结果不会溢出 32 位整数
通过次数4,589提交次数8,219
 */

//这题想到了异或位运算，但是自己没想到这样写。。。。
public class add {
    static class Solution {
        public int add(int a, int b) {
            int sum = a, carry = 0;
            while (b != 0) {
                sum = a ^ b;
                carry = (a & b) << 1;
                a = sum;
                b = carry;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        int a = 3, b = 0;
        System.out.println(new Solution().add(a, b));
    }
}
