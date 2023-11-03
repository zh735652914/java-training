package beijing;
/*
https://leetcode-cn.com/problems/binary-gap/
 */

public class binaryGap {
    // 位运算，很简单
    static class Solution {
        public int binaryGap(int n) {
            int ans = 0;
            int last = -1;
            int index = 0;
            while (n > 0) {
                if ((n & 1) == 1) {
                    if (last == -1) {
                        last = index;
                    }
                    ans = Math.max(ans, index - last);
                    last = index;
                }
                n = n >> 1;
                index++;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(new Solution().binaryGap(n));
    }
}
