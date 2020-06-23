package LeetCode.ProgrammerInterview;
/*
面试题 05.03. 翻转数位
给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。

示例 1：

输入: num = 1775(110111011112)
输出: 8
示例 2：

输入: num = 7(01112)
输出: 4
通过次数2,415提交次数4,977
 */

import java.util.Scanner;

//自己没有思路,看了讨论，发现很牛逼
public class reverseBits {
    static class Solution {
        public int reverseBits(int num) {
            int cur_len = 0, per_len = 0, max_len = 0;
            for (int i = 0; i < 32; i++) {
                if ((num & 1) == 0) {
                    cur_len -= per_len;
                    per_len = cur_len + 1;
                }
                cur_len++;
                max_len = Math.max(cur_len, max_len);
                num >>= 1;
            }
            return max_len;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(new Solution().reverseBits(scanner.nextInt()));
        }
    }
}
