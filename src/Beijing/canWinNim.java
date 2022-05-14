package Beijing;
/*
https://leetcode.cn/problems/nim-game/
 */

// 我是傻逼
public class canWinNim {
    static class Solution {
        public boolean canWinNim(int n) {
            return n % 4 != 0;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(new Solution().canWinNim(n));
    }
}
