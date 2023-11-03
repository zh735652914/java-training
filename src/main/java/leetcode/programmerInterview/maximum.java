package leetcode.programmerInterview;

/*面试题 16.07. 最大数值
编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。

示例：

输入： a = 1, b = 2
输出： 2
通过次数7,115提交次数9,764
 */

//这题有点意思，自己没写出来。。。
public class maximum {
    static class Solution {
        public int maximum(int a, int b) {
            long A = a;
            long B = b;
            return (int) ((A + B + Math.abs(A - B)) / 2);
        }
    }

    public static void main(String[] args) {
        int a = 1, b = 2;
        System.out.println(new Solution().maximum(a, b));
    }
}
