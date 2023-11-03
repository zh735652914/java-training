package beijing;
/*
https://leetcode.cn/problems/smallest-integer-divisible-by-k/
 */

/**
 * @author zhouhao
 * @date 2023/5/10 12:57
 */
// 数论的知识，自己是垃圾
public class SmallestRepunitDivByK {
    static class Solution {
        public int smallestRepunitDivByK(int k) {
            // 2,5
            if ((k & 1) == 0 || k % 5 == 0) {
                return -1;
            }
            int res = 1 % k, len = 1;
            while (res != 0) {
                res = (res * 10 + 1) % k;
                len++;
            }
            return len;
        }
    }

    public static void main(String[] args) {
        int k = 3;
        System.out.println(new Solution().smallestRepunitDivByK(k));
    }
}
