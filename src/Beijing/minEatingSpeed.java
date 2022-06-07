package Beijing;
/*
https://leetcode.cn/problems/koko-eating-bananas/
 */

public class minEatingSpeed {
    // 这个二分我没想到，很有意思的一道题
    static class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int low = 1, high = 0;
            for (int pile : piles) {
                high = Math.max(high, pile);
            }
            int ans = 1;
            while (low <= high) {
                int speed = low + (high - low) / 2;
                int time = getTime(piles, speed);
                if (time <= h) {
                    ans = speed;
                    high = speed - 1;
                } else {
                    low = speed + 1;
                }
            }
            return ans;
        }

        private int getTime(int[] piles, int speed) {
            int time = 0;
            for (int pile : piles) {
                time += (pile + speed - 1) / speed;
            }
            return time;
        }
    }

    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println(new Solution().minEatingSpeed(piles, h));
    }
}
