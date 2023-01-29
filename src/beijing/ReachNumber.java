package beijing;
/*
https://leetcode.cn/problems/reach-a-number/
 */

public class ReachNumber {
    // 自己没有思路
    static class Solution {
        public int reachNumber(int target) {
            target = Math.abs(target);
            int s = 0, n = 0;
            while (s < target || ((s - target) & 1) == 1) {
                s += ++n;
            }
            return n;
        }
    }

    public static void main(String[] args) {
        int target = 2;
        System.out.println(new Solution().reachNumber(target));
    }
}
