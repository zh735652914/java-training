package beijing;
/*
https://leetcode-cn.com/problems/count-of-matches-in-tournament/
 */

public class numberOfMatches {
    static class Solution {
        public int numberOfMatches(int n) {
            int ans = 0;
            while (n > 1) {
                ans += n / 2;
                if (n % 2 != 0) {
                    n = (n + 1) >> 1;
                } else {
                    n = n >> 1;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int n = 14;
        System.out.println((new Solution().numberOfMatches(n)));
    }
}
