package beijing;
/*
https://leetcode.cn/problems/nim-game/
 */

// 重点是解析的推理，这个还是要看看
public class nimGame_292 {
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
