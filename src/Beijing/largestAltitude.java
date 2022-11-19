package Beijing;
/*
https://leetcode.cn/problems/find-the-highest-altitude/
 */

public class largestAltitude {
    // 的确是简单题
    static class Solution {
        public int largestAltitude(int[] gain) {
            int ans = 0, height = 0;
            for (int i = 0; i < gain.length; i++) {
                height += gain[i];
                ans = Math.max(ans, height);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] gain = {-5, 1, 5, 0, -7};
        System.out.println(new Solution().largestAltitude(gain));
    }
}
