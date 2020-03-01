package LeetCode.ToOffer;
/*
面试题17. 打印从1到最大的n位数
输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

示例 1:

输入: n = 1
输出: [1,2,3,4,5,6,7,8,9]


说明：

用返回一个整数列表来代替打印
n 为正整数
通过次数4,659提交次数5,809
 */

import java.util.Scanner;

public class printNumbers {
    static class Solution {
        public int[] printNumbers(int n) {
            int count = (int) Math.pow(10, n);
            int[] nums = new int[count - 1];
            for (int i = 0; i < count - 1; i++) {
                nums[i] = i + 1;
            }
            return nums;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int[] nums = new Solution().printNumbers(scanner.nextInt());
            for (int x : nums) {
                System.out.print(x + ", ");
            }
            System.out.println();
        }
    }
}
