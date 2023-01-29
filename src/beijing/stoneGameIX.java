package beijing;
/*
https://leetcode-cn.com/problems/stone-game-ix/
 */

public class stoneGameIX {
    static class Solution {
        // 不会，解析都看不太明白
        public boolean stoneGameIX(int[] stones) {
            int cnt0 = 0, cnt1 = 0, cnt2 = 0;
            for (int val : stones) {
                int type = val % 3;
                if (type == 0) {
                    ++cnt0;
                } else if (type == 1) {
                    ++cnt1;
                } else {
                    ++cnt2;
                }
            }
            if (cnt0 % 2 == 0) {
                return cnt1 >= 1 && cnt2 >= 1;
            }
            return cnt1 - cnt2 > 2 || cnt2 - cnt1 > 2;
        }
    }

    public static void main(String[] args) {
        int[] stones = {5, 1, 2, 4, 3};
        System.out.println(new Solution().stoneGameIX(stones));
    }
}
