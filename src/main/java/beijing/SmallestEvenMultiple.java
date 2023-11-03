package beijing;
/*
https://leetcode.cn/problems/smallest-even-multiple/
 */

/**
 * @author zhouhao
 * @date 2023/4/21 13:18
 */
// 这题是来搞笑的吧
public class SmallestEvenMultiple {
    static class Solution {
        public int smallestEvenMultiple(int n) {
            return (n & 1) == 0 ? n : n << 1;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(new Solution().smallestEvenMultiple(n));
    }
}
