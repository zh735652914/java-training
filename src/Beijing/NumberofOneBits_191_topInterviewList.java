package Beijing;
/*
https://leetcode.cn/problems/number-of-1-bits/
 */

// 记得要无符号位移
public class NumberofOneBits_191_topInterviewList {
    static public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int count = 0;
            while (n != 0) {
                if ((n & 1) == 1) {
                    count++;
                }
                n >>>= 1;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int n = -3;
        System.out.println(new Solution().hammingWeight(n));
    }
}
