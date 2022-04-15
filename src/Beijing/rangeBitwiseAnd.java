package Beijing;
/*
https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/
 */

// 这个算法得看看，自己没想到
public class rangeBitwiseAnd {
    static class Solution {
        public int rangeBitwiseAnd(int left, int right) {
            int count = 0;
            while (left != right) {
                left >>= 1;
                right >>= 1;
                count++;
            }
            return left << count;
        }
    }

    public static void main(String[] args) {
        int left = 5, right = 7;
        System.out.println(new Solution().rangeBitwiseAnd(left, right));
    }
}
